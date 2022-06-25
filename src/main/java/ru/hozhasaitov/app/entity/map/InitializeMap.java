package ru.hozhasaitov.app.entity.map;


import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;
import ru.hozhasaitov.app.util.Randomaizer;

import java.util.concurrent.ThreadLocalRandom;

public class InitializeMap {

    private InitializeMap() {
    }

    public static void initializeMap(Cell[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
               fill(cells[i][j]);

            }
        }


    }

    private static void fill(Cell cell) {
        int random = Randomaizer.randomInt();
        if (random < 50) {
            cell.addEukaryote(new Bear());
        } else {
            cell.addEukaryote(new Boar());
        }
    }
}
