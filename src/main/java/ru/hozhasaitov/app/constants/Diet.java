package ru.hozhasaitov.app.constants;

import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;

import java.util.HashMap;
import java.util.Map;

public class Diet {

    private Diet() {
    }

    public static final Map<Class<?>, Integer> DIET_BEAR = new HashMap<>();
    static  {
        DIET_BEAR.put(Boar.class, 100);
    }
}
