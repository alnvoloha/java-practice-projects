package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Car {
    private static final Logger logger = LoggerFactory.getLogger(Car.class);

    private String brand;
    private Engine engine;
    private Wheel[] wheels;
    private double fuelLevel;

    public Car(String brand, Engine engine, Wheel[] wheels, double fuelLevel) {
        if (wheels == null || wheels.length != 4) {
            throw new IllegalArgumentException("Автомобиль должен иметь ровно 4 колеса.");
        }
        this.brand = brand;
        this.engine = engine;
        this.wheels = wheels;
        this.fuelLevel = fuelLevel;
    }

    public void drive() {
        if (fuelLevel <= 0) {
            logger.info("Недостаточно топлива для поездки.");
            return;
        }
        fuelLevel -= 1;
        logger.info("Автомобиль {} едет. Остаток топлива: {}", brand, fuelLevel);
    }

    public void refuel(double amount) {
        if (amount <= 0) {
            logger.info("Нельзя заправить отрицательное или нулевое количество топлива.");
            return;
        }
        fuelLevel += amount;
        logger.info("Автомобиль {} заправлен на {} л. Текущий уровень топлива: {}", brand, amount, fuelLevel);
    }

    public void changeWheel(Wheel newWheel) {
        Random random = new Random();
        int index = random.nextInt(4);
        wheels[index] = newWheel;
        logger.info("Колесо на позиции {} было заменено на {}", index, newWheel);
    }

    public void printBrand() {
        logger.info("Марка автомобиля: {}", brand);
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.fuelLevel, fuelLevel) == 0 &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(engine, car.engine) &&
                Arrays.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(brand, engine, fuelLevel);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                ", fuelLevel=" + fuelLevel +
                '}';
    }
}
