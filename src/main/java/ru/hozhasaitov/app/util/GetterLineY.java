package ru.hozhasaitov.app.util;

import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.entity.map.Cell;

import java.util.Arrays;

public class GetterLineY {
    private GetterLineY() {
    }

    public static Cell[] getLine(Animal animal, Cell[][] gameMap) {
        int coorX = animal.getCoorX();
        int coorY = animal.getCoorY();
        int offY = Math.max(coorY - animal.getSpeed(), 0);
        int toY = Math.min(coorY + animal.getSpeed() + 1, gameMap.length);
        Cell[] lineY = new Cell[toY - offY];
        for (int i = offY, j = 0; i < gameMap.length; i++, j++) {
            lineY[j] = gameMap[i][coorX];
        }
        return lineY;

    }
}
