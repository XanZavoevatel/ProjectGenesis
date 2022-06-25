package ru.hozhasaitov.app.service;

import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.entity.map.PrintMap;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreatorStreams implements Runnable {


    @Override
    public void run() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < GameMap.GAME_MAP.getMap().length; i++) {

            executorService.scheduleAtFixedRate(new LineWorker(i), 0, 2, TimeUnit.SECONDS);

            //PrintMap.printMap(GameMap.GAME_MAP.getMap());
//            System.out.println("-------------------------");
        }
        executorService.shutdown();
    }
}
