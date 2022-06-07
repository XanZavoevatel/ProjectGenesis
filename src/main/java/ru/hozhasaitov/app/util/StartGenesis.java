package ru.hozhasaitov.app.util;

import ru.hozhasaitov.app.classes.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.classes.eukaryotes.animals.predatores.Bear;
import ru.hozhasaitov.app.classes.map.Field;

public class StartGenesis {
    private static Field[][] fieldApp;

    public static void start() {
        ConfigClass configClass = ConfigClass.getInstance();
        fieldApp = new Field[configClass.getSizeXfield()][configClass.getSizeYfield()];

    }

    public static Field[][] getFieldApp() {
        return fieldApp;
    }
}
