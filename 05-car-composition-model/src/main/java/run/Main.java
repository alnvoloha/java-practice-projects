package run;

import entity.Car;
import entity.Engine;
import entity.Wheel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Вариант №2:
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 *
 * Обоснование архитектуры:
 * - Использовано композиционное отношение между Car, Engine и Wheel.
 * - Автомобиль всегда состоит из 4 колёс, поэтому валидация жёстко задана в конструкторе.
 * - Метод drive() уменьшает уровень топлива и логирует попытку движения.
 * - Метод changeWheel() заменяет одно случайное колесо.
 * - Метод printBrand() демонстрирует принцип SRP: отвечает только за вывод бренда.
 * - Переопределены методы equals(), hashCode(), toString() для корректного сравнения и отладки.
 * Мне кажется, что пример вывода хватает для показа функционала программы, в условии задачи не было требований, что именно требуется от программы кроме создания структуры.
 */

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Wheel[] wheels = {
                new Wheel(16),
                new Wheel(16),
                new Wheel(16),
                new Wheel(16)
        };

        Engine engine = new Engine("бензиновый", 150);
        Car car = new Car("Toyota", engine, wheels, 5.0);

        car.printBrand();
        car.drive();
        car.refuel(10);
        car.changeWheel(new Wheel(17));

        logger.info("Информация об автомобиле после операций:\n{}", car);
    }
}
