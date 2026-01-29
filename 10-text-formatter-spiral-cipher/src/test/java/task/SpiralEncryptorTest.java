package task;

import exception.InvalidTextException;
import org.testng.annotations.Test;
import task.SpiralEncryptor;

import static org.testng.Assert.*;

public class SpiralEncryptorTest {


    /*1. Исходный текст: "abcd"
   → таблица (2×2):
   a  b
   c  d

2. Поворот на 90° по часовой:
   c  a
   d  b

3. Инверсия строк:
   d  b
   c  a

4. Инверсия столбцов:
   b  d
   a  c

5. Спираль:
   → b d
   ↓    c
   ← a

   ➜ результат: "bdca"
*/
    @Test
    public void testEncryptWithStringMethodsMiniExample() {
        // Исходный текст: "abcd"
        // Ожидаемый результат после всех операций: "bdca"
        String result = SpiralEncryptor.encryptWithStringMethods("abcd");
        assertEquals(result, "bdca");
    }

    @Test
    public void testEncryptWithStreamsMiniExample() {
        // Проверим, что Stream-реализация даёт тот же результат
        String result = SpiralEncryptor.encryptWithStreams("abcd");
        assertEquals(result, "bdca");
    }

    @Test(expectedExceptions = InvalidTextException.class)
    public void testEncryptWithStringMethodsInvalid() {
        SpiralEncryptor.encryptWithStringMethods(" ");
    }

    @Test(expectedExceptions = InvalidTextException.class)
    public void testEncryptWithStreamsInvalid() {
        SpiralEncryptor.encryptWithStreams(null);
    }
}
