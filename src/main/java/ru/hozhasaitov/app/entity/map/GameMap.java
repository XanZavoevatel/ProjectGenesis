package ru.hozhasaitov.app.entity.map;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.util.ConfigClass;

public enum GameMap {
    GAME_MAP;

    private static Field[][] fields = new Field[ConfigClass.CONFIG_CLASS.getSizeYfield()]
            [ConfigClass.CONFIG_CLASS.getSizeXfield()];
    GameMap() {
    }

    public Field[][] getMap() {
        return fields;
    }

    public void addEukaryote(Eukaryote eukaryote, int x, int y) {
        fields[y][x].addEukaryote(eukaryote);
        eukaryote.setCoorY(y);
        eukaryote.setCoorX(x);
    }

}
