package ru.javarush.islande.hozhasaitov.app.util;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;
import ru.javarush.islande.hozhasaitov.app.entity.map.GameMap;
import ru.javarush.islande.hozhasaitov.app.entity.map.InitializeMap;
import ru.javarush.islande.hozhasaitov.app.entity.map.PrintMap;
import ru.javarush.islande.hozhasaitov.app.service.GameWorker;

public class StartGenesis {


    public static void start() throws InterruptedException {
        ConfigClass configClass = ConfigClass.getInstance();

        InitializeMap.initializeMap(GameMap.GAME_MAP.getMap());
//
//        Bear bear = new Bear();
//        Bear bear1 = new Bear();
//        Boar boar = new Boar();
//        Boar boar1 = new Boar();
//        Boar boar2 = new Boar();
//        GameMap.GAME_MAP.addEukaryote(bear, 0, 2);
//        GameMap.GAME_MAP.addEukaryote(bear1, 0, 2);
//        GameMap.GAME_MAP.addEukaryote(boar, 1, 2);
//        GameMap.GAME_MAP.addEukaryote(boar1, 4, 2);
//        GameMap.GAME_MAP.addEukaryote(boar2, 3, 2);
//        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
//        System.out.println("boar:" + Boar.getCount());
        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        bear.spawn();
//        bear.move(bear.searchPrey());
//        bear.eat();
//        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
//        System.out.println("boar:" + Boar.getCount());
//        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        bear.move(bear.searchPrey());
//        bear.eat();
//        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
//        System.out.println("boar:" + Boar.getCount());
//        PrintMap.printMap(GameMap.GAME_MAP.getMap());
        GameWorker gameWorker = new GameWorker(GameMap.GAME_MAP.getMap());
        gameWorker.start();
    }

}
