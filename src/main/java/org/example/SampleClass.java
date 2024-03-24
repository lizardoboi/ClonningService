package org.example;
import java.util.Objects;

public class SampleClass {
    @CloneableField
    private int intValue;
    @CloneableField
    private String stringValue;
    @CloneableField
    private NestedClass nested;

    public SampleClass(int intValue, String stringValue, NestedClass nested) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.nested = nested;
    }
    public SampleClass() {
        // Конструктор без аргументов
        this.intValue = 0;
        this.stringValue = null;
        this.nested = new NestedClass();
    }

    public SampleClass clone() {
        NestedClass clonedNested = nested.clone();
        return new SampleClass(intValue, stringValue, clonedNested);
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public NestedClass getNested() {
        return nested;
    }

    public void setNested(NestedClass nested) {
        this.nested = nested;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleClass that = (SampleClass) o;
        return intValue == that.intValue &&
                Objects.equals(stringValue, that.stringValue) &&
                Objects.equals(nested, that.nested);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intValue, stringValue, nested);
    }

    @Override
    public String toString() {
        return "SampleClass{" +
                "intValue=" + intValue +
                ", stringValue='" + stringValue + '\'' +
                ", nested=" + nested +
                '}';
    }
}