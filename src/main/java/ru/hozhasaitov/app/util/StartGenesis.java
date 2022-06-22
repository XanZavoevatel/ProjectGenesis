package ru.hozhasaitov.app.util;

import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.entity.map.InitializeMap;
import ru.hozhasaitov.app.entity.map.PrintMap;

public class StartGenesis {


    public static void start() throws InterruptedException {
        ConfigClass configClass = ConfigClass.getInstance();

        InitializeMap.initializeMap(GameMap.GAME_MAP.getMap());
        Bear bear = new Bear();
        Boar boar = new Boar();
        Boar boar1 = new Boar();
        GameMap.GAME_MAP.addEukaryote(bear, 0, 2);
  //      GameMap.GAME_MAP.addEukaryote(boar, 0, 4);
        GameMap.GAME_MAP.addEukaryote(boar1, 2, 2);
        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
        PrintMap.printMap(GameMap.GAME_MAP.getMap());
        bear.move();
        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
        PrintMap.printMap(GameMap.GAME_MAP.getMap());

    }

}
