package ru.hozhasaitov.app.entity.map;


import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;

import java.util.concurrent.ThreadLocalRandom;

public class InitializeMap {

    private InitializeMap() {
    }

    public static void initializeMap(Field[][] fields) {

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = new Field();
//                fill(fields[i][j]);

            }
        }


    }

    private static void fill(Field field) {
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        if (random < 50) {
            field.addEukaryote(new Bear());
        } else {
            field.addEukaryote(new Boar());
        }
    }
}
