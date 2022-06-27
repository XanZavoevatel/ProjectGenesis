package ru.hozhasaitov.app.interfaces;

import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.entity.map.Cell;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.util.DecrementСounterAnimal;
import ru.hozhasaitov.app.util.Randomaizer;

import java.util.List;

public abstract class PredatoryAnimal extends Animal {

    @Override
    public void eat() {
        List<HerbivorousAnimal> herbivorousAnimals = gameMap[this.getCoorY()][this.getCoorX()]
                .getHerbivorousAnimals().stream().filter(h -> diet.containsKey(h.getClass())).toList();
        for (HerbivorousAnimal h : herbivorousAnimals) {
            if (tryingEat(h, diet.get(h.getClass()))) {
                break;
            }
        }
    }

    private boolean tryingEat(HerbivorousAnimal h, Integer integer) {
        List<HerbivorousAnimal> herbivorousAnimals = gameMap[h.getCoorY()][getCoorX()]
                .getHerbivorousAnimals();

        if (integer >= Randomaizer.randomInt()) {

            herbivorousAnimals.remove(h);
            DecrementСounterAnimal.decrement(h);
            return  true;
        }
        return false;
    }
}
