package ru.hozhasaitov.app.entity.eukaryotes.animals.predatores;

import ru.hozhasaitov.app.constants.Diets;
import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.constants.Constants;
import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.hozhasaitov.app.interfaces.HerbivorousAnimal;
import ru.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.HashMap;
import java.util.Map;

public class Bear extends PredatoryAnimal {
    private static int count;


    public Bear() {
        super.weight = Constants.BEAR_WEIGHT;
        super.speed = 3;
        count++;
        super.diet = Diets.DIET_BEAR;
    }

    public int getCount() {
        return count;
    }

    public static void decrementCount() {
        count--;
    }

    @Override
    public void die() {

    }

    @Override
    public void spawn() {

    }
}
