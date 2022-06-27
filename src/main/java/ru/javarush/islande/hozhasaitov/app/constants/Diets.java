package ru.javarush.islande.hozhasaitov.app.constants;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;

import java.util.HashMap;
import java.util.Map;

public class Diets {

    private Diets() {
    }

    public static final Map<Class<?> , Integer> DIET_BEAR = new HashMap<>();
    static {
        DIET_BEAR.put(Boar.class, 100);
    }
}
