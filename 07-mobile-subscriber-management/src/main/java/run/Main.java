package run;

import entity.CorporateSubscriberImpl;
import entity.InternetSubscriberImpl;
import entity.Subscriber;
import reader.SubscriberFileReader;
import util.RandomSubscriberWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    /**
     * 2 Вариант. Абонент мобильного оператора. Возможности: оформить договор; открыть счет и номер; редактировать учетную запись абонента; получить всю актуальную информацию по номеру абонента; проверить состояние баланса и остаток трафика; просмотреть детализацию и информацию о платежах; сменить тарифный план, оператора; пополнить счет; закрыть счет и номер. Добавить специализированные методы для Учетной записи интернет и корпоративного абонента.
     *
     * Функционал main:
     * - Читает абонентов из файла (subscribers.txt)
     * - Добавляет каждому два платежа (Интернет, SMS)
     * - Выводит данные и историю платежей
     * - Создаёт вручную интернет- и корпоративного абонента
     * - Генерирует 5 случайных абонентов и сохраняет в файл
     */

    private static final Logger logger = LogManager.getLogger(Main.class);



    public static void main(String[] args) {

        logger.info("==== Чтение обычных абонентов из файла ====");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/subscribers.txt"))) {
            SubscriberFileReader fileReader = new SubscriberFileReader();
            List<Subscriber> subscribers = fileReader.readFromReader(reader);

            for (Subscriber s : subscribers) {
                s.viewAccountInfo();
                s.addPayment("Интернет", 12.0);
                s.addPayment("SMS", 3.0);
                s.viewPayments();
            }

        } catch (IOException e) {
            logger.error("Ошибка чтения файла: " + e.getMessage());
        }

        logger.info("\n==== Интернет-абонент вручную ====");
        InternetSubscriberImpl net = new InternetSubscriberImpl("Ольга", "375296661100", "life:)", "Интернет 30GB");
        net.setStaticIP("192.168.0.1");
        net.requestAdditionalDataPackage(5);
        net.viewAccountInfo();

        logger.info("\n==== Корпоративный абонент вручную ====");
        CorporateSubscriberImpl corp = new CorporateSubscriberImpl("ООО Бизнес", "375331112233", "МТС", "Корп 100");
        corp.addEmployeeNumber("375291234000");
        corp.addEmployeeNumber("375291234001");
        corp.generateCorporateInvoice();

        logger.info("\n==== Генерация случайных абонентов в файл ====");
        RandomSubscriberWriter.writeRandomSubscribers(Paths.get("src/main/resources/generated_subscribers.txt"), 5);
    }
}
