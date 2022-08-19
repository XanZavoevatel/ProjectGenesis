package ru.javarush.islande.hozhasaitov.app.entity.map;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.Plant;
import ru.javarush.islande.hozhasaitov.app.interfaces.HerbivorousAnimal;
import ru.javarush.islande.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private volatile List<PredatoryAnimal> predatoryAnimals = new ArrayList<>();
    private volatile List<HerbivorousAnimal> herbivorousAnimals = new ArrayList<>();
    private volatile List<Plant> plants = new ArrayList<>();

    private Relief relief;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    private String view;

    public Cell() {
       // randomRelief();

    }

    public List<PredatoryAnimal> getPredatoryAnimals() {
        return predatoryAnimals;
    }

    public List<HerbivorousAnimal> getHerbivorousAnimals() {
        return herbivorousAnimals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void addEukaryote(Eukaryote eukaryote) {
        if (eukaryote instanceof PredatoryAnimal predatoryAnimal) {
            predatoryAnimals.add(predatoryAnimal);
        } else if (eukaryote instanceof HerbivorousAnimal herbivorousAnimal) {
            herbivorousAnimals.add(herbivorousAnimal);
        } else if (eukaryote instanceof Plant plant) {
            plants.add(plant);
        }
    }
    public Relief getRelief() {
        return relief;
    }

    public String getView() {
        printView();
        return view;
    }

    private void randomRelief() {
       int random = ThreadLocalRandom.current().nextInt(1, 101);
       if (random < 30)
           relief = Relief.MOUNTAINS;
       if (random > 30 && random < 70)
           relief = Relief.PLAIN;
       if (random > 70)
           relief = Relief.MEADOW;

    }

    private void printView() {
        if (predatoryAnimals.size() > herbivorousAnimals.size() && predatoryAnimals.size() > plants.size()) {
            view = " |+| ";
        } else if (herbivorousAnimals.size() > predatoryAnimals.size() && herbivorousAnimals.size() > plants.size()) {
            view = " |-| ";
        } else if (plants.size() > herbivorousAnimals.size() && plants.size() > predatoryAnimals.size()) {
            view = " |/| ";

        } else
        view = " |0| ";

//        if (predatoryAnimals.size() > herbivorousAnimals.size()) {
//            view = " |+| ";
//        } else if (herbivorousAnimals.size() > predatoryAnimals.size()) {
//            view = " |-| ";
//        } else {
//            view = " |/| ";
//        }

    }


}
