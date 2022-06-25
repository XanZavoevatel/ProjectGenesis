package ru.hozhasaitov.app.interfaces;

import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.util.DecrementCounterAnimal;
import ru.hozhasaitov.app.util.Randomaizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PredatoryAnimal extends Animal implements Cloneable {

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat() {

            List<HerbivorousAnimal> herbivorousAnimals = GameMap.GAME_MAP.getMap()[this.getCoorY()][this.getCoorX()]
                    .getHerbivorousAnimals().stream().filter(h -> foodMap.containsKey(h.getClass())).toList();
            for (int i = 0; i < herbivorousAnimals.size(); i++) {
                HerbivorousAnimal h = herbivorousAnimals.get(i);
                if (tryingEat(h, foodMap.get(h.getClass()))) {
                    break;
                }
            }



    }
    private boolean tryingEat(HerbivorousAnimal h, Integer integer) {
        List<HerbivorousAnimal> herbivorousAnimals = GameMap.GAME_MAP.getMap()[h.getCoorY()][getCoorX()]
                .getHerbivorousAnimals();

        if (integer >= Randomaizer.randomInt()) {

            herbivorousAnimals.remove(h);
            DecrementCounterAnimal.decrement(h);
            return  true;
        }
        return false;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void die() {

    }
}
