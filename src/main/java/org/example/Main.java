package org.example;


public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        SampleClass original = new SampleClass(1337, "Jambo_Juicy", new NestedClass(322));
        SampleClass clone = UniversalCloner.cloneObject(original);

        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);

        if (original.equals(clone)) {
            System.out.println("Клонирование прошло успешно: объекты идентичны.");
        } else {
            System.out.println("Клонирование не удалось: объекты различаются.");
        }
    }
}