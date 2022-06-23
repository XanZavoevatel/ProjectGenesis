package ru.hozhasaitov.app.entity.map;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.util.ConfigClass;

public enum GameMap {
    GAME_MAP;

    private static Cell[][] cells = new Cell[ConfigClass.CONFIG_CLASS.getSizeYfield()]
            [ConfigClass.CONFIG_CLASS.getSizeXfield()];
    GameMap() {
    }

    public Cell[][] getMap() {
        return cells;
    }

    public void addEukaryote(Eukaryote eukaryote, int x, int y) {
        cells[y][x].addEukaryote(eukaryote);
        eukaryote.setCoorY(y);
        eukaryote.setCoorX(x);
    }

}
