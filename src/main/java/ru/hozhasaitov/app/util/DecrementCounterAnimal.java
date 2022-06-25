package ru.hozhasaitov.app.util;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;

import java.lang.reflect.Field;

public class DecrementCounterAnimal {

    private DecrementCounterAnimal() {
    }

    public static void decrement(Eukaryote e) {
        try {
            Field count = e.getClass().getDeclaredField("count");
            count.setAccessible(true);
            int value = count.getInt(e);
            count.set(e, value - 1);
        } catch (NoSuchFieldException | IllegalAccessException u) {
            System.out.println("Не получилось уменьшить счетчик животного");
        }
    }
}
