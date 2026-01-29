package company.util;

import company.entity.TaxPayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaxPayerConnector {
    private static final Logger logger = LogManager.getLogger(TaxPayerConnector.class);
    public static final String DEFAULT_PATH = "src/main/resources/taxpayers.ser";

    public static void serialize(List<TaxPayer> list, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(list);
            logger.info("✅ Сериализовано объектов: {}", list.size());
        } catch (IOException e) {
            logger.error("❌ Ошибка сериализации: {}", e.getMessage());
        }
    }

    public static List<TaxPayer> deserialize(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                logger.info("📥 Десериализация выполнена успешно");
                return (List<TaxPayer>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            logger.error("❌ Ошибка десериализации: {}", e.getMessage());
        }
        return new ArrayList<>();
    }
}
