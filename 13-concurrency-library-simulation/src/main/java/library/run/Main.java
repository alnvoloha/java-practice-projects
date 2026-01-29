package library.run;

import library.entity.Book;
import library.entity.BookType;
import library.entity.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        List<Book> allBooks = List.of(
                new Book("Грокаем алгоритмы", BookType.TAKE_HOME),
                new Book("Java Concurrency in Practice", BookType.TAKE_HOME),
                new Book("Effective Java", BookType.READING_HALL),
                new Book("Философия Java", BookType.READING_HALL),
                new Book("Spring в действии", BookType.TAKE_HOME)
        );

        BlockingQueue<Book> takeHomeQueue = new ArrayBlockingQueue<>(3);
        CopyOnWriteArrayList<Book> readingHallList = new CopyOnWriteArrayList<>();

        for (Book b : allBooks) {
            if (b.getType() == BookType.TAKE_HOME) {
                takeHomeQueue.offer(b);
            } else {
                readingHallList.add(b);
            }
        }

        Exchanger<Book> exchanger = new Exchanger<>();
        Phaser phaser = new Phaser();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            Reader reader = new Reader("Читатель #" + i, takeHomeQueue, readingHallList, exchanger, phaser);
            executor.submit(reader);
        }

        while (phaser.getRegisteredParties() > 0) {
            Thread.sleep(100);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        logger.info("Все читатели завершили работу.");
    }
}
