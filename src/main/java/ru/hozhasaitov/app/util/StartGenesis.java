package ru.hozhasaitov.app.util;

import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.entity.map.InitializeMap;
import ru.hozhasaitov.app.entity.map.PrintMap;
import ru.hozhasaitov.app.service.AnimalWorker;
import ru.hozhasaitov.app.service.CreatorStreams;

public class StartGenesis {


    public static void start() throws InterruptedException {
        ConfigClass configClass = ConfigClass.getInstance();

        InitializeMap.initializeMap(GameMap.GAME_MAP.getMap());
        PrintMap.printMap(GameMap.GAME_MAP.getMap());
        System.out.println("-------------------------");

        CreatorStreams creatorStreams = new CreatorStreams();
        creatorStreams.run();
        Thread.sleep(1000);
        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        Bear bear = new Bear();
//        Bear bear1 = new Bear();
//        Boar boar = new Boar();
//        Boar boar1 = new Boar();
//        GameMap.GAME_MAP.addEukaryote(bear, 0, 2);
//        GameMap.GAME_MAP.addEukaryote(bear1, 0, 2);
//        GameMap.GAME_MAP.addEukaryote(boar, 2, 0);
//        GameMap.GAME_MAP.addEukaryote(boar1, 0, 0);


//        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
//        System.out.println("boar:" + Boar.getCount());
//        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        bear.move();
//        bear.eat();
//        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
//        System.out.println("boar:" + Boar.getCount());
//        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        bear.move();
//        bear.eat();
//        System.out.println("Координаты медведя: " + bear.getCoorX() + "/" + bear.getCoorY());
//        System.out.println("boar:" + Boar.getCount());
//        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        AnimalWorker animalWorker = new AnimalWorker(bear);
//        animalWorker.run();


    }

}
