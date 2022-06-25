package ru.hozhasaitov.app.service;

import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;

import java.util.concurrent.Callable;

public class AnimalWorker implements Callable<Void> {

    private final Animal animal;

    public AnimalWorker(Animal animal) {
        this.animal = animal;
    }

    @Override

    public Void call() {

//            PrintMap.printMap(GameMap.GAME_MAP.getMap());
//            System.out.println("Координаты животного: " + animal.getCoorX() + "/" + animal.getCoorY());
        animal.move();
        animal.eat();
        animal.spawn();
        animal.die();
        animal.finishRound();

//        PrintMap.printMap(GameMap.GAME_MAP.getMap());
//        System.out.println("Координаты животного: " + animal.getCoorX() + "/" + animal.getCoorY());
            return null;
    }
}
