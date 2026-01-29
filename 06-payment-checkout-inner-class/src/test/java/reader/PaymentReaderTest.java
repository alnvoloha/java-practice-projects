package reader;

import entity.Payment;
import exception.InvalidItemException;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.*;

public class PaymentReaderTest {

    @Test
    public void testReadFromFileShouldReturnCorrectPayment() throws IOException {
        Path tempFile = Files.createTempFile("test-data", ".txt");

        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("Молоко,2.5,1\n");
            writer.write("Хлеб,1.2,2\n");
        }

        Payment payment = PaymentReader.readFromFile(tempFile.toString());

        assertEquals(payment.getItems().size(), 2);
        assertEquals(payment.getItems().get(0).name(), "Молоко");
        assertEquals(payment.getItems().get(1).price(), 1.2);
    }

    @Test
    public void testReadFromFileShouldSkipInvalidLine() throws IOException {
        Path tempFile = Files.createTempFile("test-skip-invalid", ".txt");

        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("Сыр,3.5,1\n"); // valid
            writer.write("Сумка\n"); // invalid
            writer.write("Хлеб,1.0,2\n"); // valid
        }

        Payment payment = PaymentReader.readFromFile(tempFile.toString());

        assertEquals(payment.getItems().size(), 2);
        assertEquals(payment.getItems().get(0).name(), "Сыр");
        assertEquals(payment.getItems().get(1).name(), "Хлеб");
    }
}
