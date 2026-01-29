package library.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class Reader implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Reader.class);

    private final String name;
    private final BlockingQueue<Book> homeBooks;
    private final CopyOnWriteArrayList<Book> readingHallBooks;
    private final Exchanger<Book> exchanger;
    private final Phaser phaser;

    public Reader(String name,
                  BlockingQueue<Book> homeBooks,
                  CopyOnWriteArrayList<Book> readingHallBooks,
                  Exchanger<Book> exchanger,
                  Phaser phaser) {
        this.name = name;
        this.homeBooks = homeBooks;
        this.readingHallBooks = readingHallBooks;
        this.exchanger = exchanger;
        this.phaser = phaser;
        this.phaser.register();
    }

    @Override
    public void run() {
        try {
            Book book = homeBooks.poll(100, TimeUnit.MILLISECONDS);
            if (book == null && !readingHallBooks.isEmpty()) {
                book = readingHallBooks.get((int) (Math.random() * readingHallBooks.size()));
            }

            if (book != null) {
                logger.info("{} получил книгу {}", name, book);
                TimeUnit.MILLISECONDS.sleep(200 + (int)(Math.random() * 300));

                if (Math.random() > 0.5) {
                    logger.info("{} пытается обменяться книгой {}", name, book);
                    book = exchanger.exchange(book, 300, TimeUnit.MILLISECONDS);
                    logger.info("{} получил книгу после обмена: {}", name, book);
                }
            }

            phaser.arriveAndDeregister();
        } catch (Exception e) {
            logger.warn("Ошибка у {}: {}", name, e.getMessage());
        }
    }
}
