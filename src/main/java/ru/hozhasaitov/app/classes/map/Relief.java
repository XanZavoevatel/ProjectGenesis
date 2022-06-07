package ru.hozhasaitov.app.classes.map;

import java.util.Arrays;
import java.util.List;

public enum Relief {
    MOUNTAINS,
    MEADOW,
    PLAIN;

    public static List<Relief> getListRelief() {
        return Arrays.asList(Relief.values());
    }


}

