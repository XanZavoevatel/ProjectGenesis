package ru.hozhasaitov.app.entity.map;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.entity.eukaryotes.Plant;
import ru.hozhasaitov.app.interfaces.HerbivorousAnimal;
import ru.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Field {
    private List<PredatoryAnimal> predatoryAnimals = new ArrayList<>();
    private List<HerbivorousAnimal> herbivorousAnimals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    private Relief relief;

    private String view;

    public Field() {
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
        if (predatoryAnimals.size() != 0) {
            view = " |+| ";
        } else if (herbivorousAnimals.size() != 0) {
            view = " |-| ";
        } else
        view = " | | ";
    }


}
