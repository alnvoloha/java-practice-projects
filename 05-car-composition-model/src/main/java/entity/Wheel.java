package entity;

import java.util.Objects;

public class Wheel {
    private double diameter;

    public Wheel(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wheel)) return false;
        Wheel wheel = (Wheel) o;
        return Double.compare(wheel.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "diameter=" + diameter +
                '}';
    }
}
