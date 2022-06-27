package ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.animals.predatores;

import ru.javarush.islande.hozhasaitov.app.constants.Diets;
import ru.javarush.islande.hozhasaitov.app.constants.Constants;
import ru.javarush.islande.hozhasaitov.app.interfaces.PredatoryAnimal;

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
