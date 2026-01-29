package reader;

import entity.Subscriber;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.testng.Assert.*;

public class SubscriberFileReaderTest {

    @Test
    public void testValidSubscribers() throws IOException {
        String input = """
            Иван Иванов;375291234567;A1;Smart
            Андрей Миронов;375291111111;МТС;Промо
        """;

        BufferedReader reader = new BufferedReader(new StringReader(input));
        SubscriberFileReader fileReader = new SubscriberFileReader();
        List<Subscriber> list = fileReader.readFromReader(reader);

        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getPhoneNumber(), "375291234567");
    }

    @Test
    public void testInvalidLineIsSkipped() throws IOException {
        String input = """
            ;;life:);Smart
            Ольга Котова;375296660000;life:);Безлимит
        """;

        BufferedReader reader = new BufferedReader(new StringReader(input));
        SubscriberFileReader fileReader = new SubscriberFileReader();
        List<Subscriber> list = fileReader.readFromReader(reader);

        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getPhoneNumber(), "375296660000");
    }

    @Test
    public void testInvalidOperator() throws IOException {
        String input = """
            Иван Иванов;375291234567;FakeOperator;Smart
        """;

        BufferedReader reader = new BufferedReader(new StringReader(input));
        SubscriberFileReader fileReader = new SubscriberFileReader();
        List<Subscriber> list = fileReader.readFromReader(reader);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testEmptyTariff() throws IOException {
        String input = """
            Иван Иванов;375291234567;A1;
        """;

        BufferedReader reader = new BufferedReader(new StringReader(input));
        SubscriberFileReader fileReader = new SubscriberFileReader();
        List<Subscriber> list = fileReader.readFromReader(reader);

        assertTrue(list.isEmpty());
    }
}
