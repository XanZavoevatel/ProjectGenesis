package ru.javarush.islande.hozhasaitov.app.entity.eukaryotes;

import ru.javarush.islande.hozhasaitov.app.constants.Constants;
import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.javarush.islande.hozhasaitov.app.entity.map.Cell;
import ru.javarush.islande.hozhasaitov.app.entity.map.GameMap;
import ru.javarush.islande.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.concurrent.atomic.AtomicInteger;

public class Plant extends Eukaryote{
    private Cell[][] gameMap = GameMap.GAME_MAP.getMap();
    private Cell cell = gameMap[this.getCoorY()][this.getCoorX()];

    public Plant() {
        this.weightMax = Constants.PLANTS_WEIGHT;
        this.weight = weightMax;
        this.maximumAmount = Constants.PLANTS_MAXIMUM_AMOUNT;
    }

    @Override
    public void die() {

    }

    @Override
    public String getView() {
        return "|/|";
    }

    @Override
    public void spawn() {
        AtomicInteger counter = new AtomicInteger(0);
        cell.getPlants().forEach(p -> {
            if(counter.get() > 0) {
                for(int i = 0; i < 10; i++) {
                    counter.getAndIncrement();
                }
            }
        });
        if (counter.get() > 0 && counter.get() < maximumAmount) {

            try {
                for (int i = 0; i < 10; i++) {

                    cell.getPlants()
                            .add((Plant) this.clone());
                }
            } catch (CloneNotSupportedException e) {
                System.out.println("Не получилось клонировать");
            }

        }
    }
}
