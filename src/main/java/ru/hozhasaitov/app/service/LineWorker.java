package ru.hozhasaitov.app.service;

import ru.hozhasaitov.app.entity.map.Cell;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.util.ConfigClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class LineWorker implements  Runnable{

    private int numLine;
    private final List<Cell> lineCell = new ArrayList<>(ConfigClass.CONFIG_CLASS.getSizeYfield());

    public LineWorker(int numLine) {
        this.numLine = numLine;
    }

    @Override
    public void run() {

        Cell[][] map = GameMap.GAME_MAP.getMap();
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < map[numLine].length; i++) {
            int size = map[numLine][i].getHerbivorousAnimals().size();
            for (int j = 0; j < size ; j++) {

                tasks.add(new AnimalWorker(map[numLine][i].getHerbivorousAnimals().get(j)));
            }
            size = map[numLine][i].getPredatoryAnimals().size();
            for (int j = 0; j < size ; j++) {

                tasks.add(new AnimalWorker(map[numLine][i].getPredatoryAnimals().get(j)));
            }

        }


        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            System.out.println("Не получилось запустить форкжойнпулл");
        }
    }
}
