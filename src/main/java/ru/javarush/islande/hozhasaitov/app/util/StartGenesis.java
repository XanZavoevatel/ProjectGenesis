package ru.javarush.islande.hozhasaitov.app.util;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.Plant;
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

        Bear bear = new Bear();
        Bear bear1 = new Bear();
        Bear bear2 = new Bear();
        Bear bear3 = new Bear();
        Bear bear4 = new Bear();
        Bear bear5 = new Bear();
        Bear bear6 = new Bear();
        Bear bear7 = new Bear();

        Plant plant = new Plant();
        Plant plant1 = new Plant();
        Plant plant2 = new Plant();
        Plant plant3 = new Plant();
        Plant plant4 = new Plant();


        Boar boar = new Boar();
        Boar boar1 = new Boar();
        Boar boar2 = new Boar();
        Boar boar3 = new Boar();
        Boar boar4 = new Boar();
        Boar boar5 = new Boar();
        Boar boar6 = new Boar();
        Boar boar7 = new Boar();
        Boar boar8 = new Boar();
        Boar boar9 = new Boar();
        Boar boar10 = new Boar();
        Boar boar11 = new Boar();
        Boar boar12 = new Boar();

        GameMap.GAME_MAP.addEukaryote(bear, 0, 0);
        GameMap.GAME_MAP.addEukaryote(bear1, 1, 1);
        GameMap.GAME_MAP.addEukaryote(bear2, 2, 2);
        GameMap.GAME_MAP.addEukaryote(bear3, 0, 3);
        GameMap.GAME_MAP.addEukaryote(bear4, 3, 4);
        GameMap.GAME_MAP.addEukaryote(bear5, 4, 0);
        GameMap.GAME_MAP.addEukaryote(bear6, 1, 2);
        GameMap.GAME_MAP.addEukaryote(bear7, 2, 3);


        GameMap.GAME_MAP.addEukaryote(boar, 1, 0);
        GameMap.GAME_MAP.addEukaryote(boar1, 3, 0);
        GameMap.GAME_MAP.addEukaryote(boar2, 0, 1);
        GameMap.GAME_MAP.addEukaryote(boar3, 3, 1);
        GameMap.GAME_MAP.addEukaryote(boar4, 0, 2);
        GameMap.GAME_MAP.addEukaryote(boar5, 3, 2);
        GameMap.GAME_MAP.addEukaryote(boar6, 3, 3);
        GameMap.GAME_MAP.addEukaryote(boar7, 4, 3);
        GameMap.GAME_MAP.addEukaryote(boar8, 4, 4);
        GameMap.GAME_MAP.addEukaryote(boar9, 0, 4);
        GameMap.GAME_MAP.addEukaryote(boar10, 1, 4);
        GameMap.GAME_MAP.addEukaryote(boar11, 4, 3);
        GameMap.GAME_MAP.addEukaryote(boar12, 2, 1);

        GameMap.GAME_MAP.addEukaryote(plant, 2, 0);
        GameMap.GAME_MAP.addEukaryote(plant1, 4, 1);
        GameMap.GAME_MAP.addEukaryote(plant2, 4, 2);
        GameMap.GAME_MAP.addEukaryote(plant3, 1, 3);
        GameMap.GAME_MAP.addEukaryote(plant4, 2, 4);



        GameWorker gameWorker = new GameWorker(GameMap.GAME_MAP.getMap());
        gameWorker.start();
        PrintMap.printMap(GameMap.GAME_MAP.getMap());
    }

}
