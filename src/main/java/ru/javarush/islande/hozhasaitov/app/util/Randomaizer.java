package ru.javarush.islande.hozhasaitov.app.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomaizer {
    private Randomaizer() {
    }

    public  static int randomInt() {
        return ThreadLocalRandom.current().nextInt(0, 101);
    }
}
