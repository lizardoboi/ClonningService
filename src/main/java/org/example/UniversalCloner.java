package org.example;

import java.util.HashMap;
import java.util.Map;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class UniversalCloner {
    public static <T> T cloneObject(T object) throws IllegalAccessException {
        if (object == null) {
            return null;
        }
        return deepCloneObject(object, new HashMap<>());
    }

    private static <T> T deepCloneObject(T object, Map<Object, Object> cloneMap)
            throws IllegalAccessException {
        if (object == null) {
            return null;
        }

        if (cloneMap.containsKey(object)) {
            return (T) cloneMap.get(object);
        }

        Class<?> clazz = object.getClass();
        if (clazz.isPrimitive() || clazz == String.class) {
            return object;
        }

        T clone;
        try {
            clone = (T) clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot create an instance of the class.");
        }
        cloneMap.put(object, clone);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Установка доступа к полю
            if (!field.isAnnotationPresent(CloneableField.class) || Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            Object value = field.get(object);
            if (value != null) {
                if (field.getType().isPrimitive() || field.getType() == String.class) {
                    field.set(clone, value);
                } else {
                    field.set(clone, deepCloneObject(value, cloneMap));
                }
            }
        }

        return clone;
    }
}