package entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CarTest {
    private Car car;

    @BeforeMethod
    public void setUp() {
        Engine engine = new Engine("бензиновый", 150);
        Wheel[] wheels = {
                new Wheel(16),
                new Wheel(16),
                new Wheel(16),
                new Wheel(16)
        };
        car = new Car("Toyota", engine, wheels, 10.0);
    }

    @Test
    public void testDriveWithFuel() {
        double fuelBefore = car.getFuelLevel();
        car.drive();
        assertEquals(car.getFuelLevel(), fuelBefore - 1.0);
    }

    @Test
    public void testDriveWithoutFuel() {
        Car emptyFuelCar = new Car("BMW", new Engine("дизель", 180),
                new Wheel[]{new Wheel(17), new Wheel(17), new Wheel(17), new Wheel(17)}, 0);
        emptyFuelCar.drive();
        assertEquals(emptyFuelCar.getFuelLevel(), 0.0);
    }

    @Test
    public void testRefuelPositiveAmount() {
        double before = car.getFuelLevel();
        car.refuel(5.0);
        assertEquals(car.getFuelLevel(), before + 5.0);
    }

    @Test
    public void testRefuelZeroAmount() {
        double before = car.getFuelLevel();
        car.refuel(0.0);
        assertEquals(car.getFuelLevel(), before);
    }

    @Test
    public void testChangeWheelActuallyChangesOne() {
        Wheel oldWheel = car.getWheels()[0];
        Wheel newWheel = new Wheel(18);
        car.changeWheel(newWheel);

        int countOfNew = 0;
        for (Wheel wheel : car.getWheels()) {
            if (wheel.equals(newWheel)) countOfNew++;
        }
        assertEquals(countOfNew, 1);
    }

    @Test
    public void testChangeWheelActuallyChangesReference() {
        Wheel newWheel = new Wheel(16);
        Wheel[] before = car.getWheels().clone();
        car.changeWheel(newWheel);
        int changedCount = 0;
        for (int i = 0; i < 4; i++) {
            if (car.getWheels()[i] != before[i]) {
                assertSame(car.getWheels()[i], newWheel); // реально новое колесо
                changedCount++;
            }
        }
        assertEquals(changedCount, 1); // ровно одна замена
    }


    @Test
    public void testPrintBrandCorrectValue() {
        assertEquals(car.getBrand(), "Toyota");
    }

    @Test
    public void testPrintBrandIncorrectValue() {
        assertNotEquals(car.getBrand(), "BMW");
    }
}
