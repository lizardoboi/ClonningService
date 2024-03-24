package org.example;
import java.util.Objects;


public class NestedClass {
    @CloneableField
    private int nestedValue;

    public NestedClass(int nestedValue) {
        this.nestedValue = nestedValue;
    }
    public NestedClass() {
        // Конструктор без аргументов
        this.nestedValue = 0;
    }

    public NestedClass clone() {
        return new NestedClass(nestedValue);
    }


    public int getNestedValue() {
        return nestedValue;
    }

    public void setNestedValue(int nestedValue) {
        this.nestedValue = nestedValue;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NestedClass that = (NestedClass) o;
        return nestedValue == that.nestedValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nestedValue);
    }

    @Override
    public String toString() {
        return "NestedClass{" +
                "nestedValue=" + nestedValue +
                '}';
    }
}