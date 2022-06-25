package ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous;

import ru.hozhasaitov.app.constants.Constants;
import ru.hozhasaitov.app.interfaces.HerbivorousAnimal;

import java.util.Map;

public class Boar extends HerbivorousAnimal {

    private static int count;
    public Boar() {
        super.weight = Constants.BOAR_WEIGHT;
        super.limitAmount = Constants.BOAR_LIMIT_AMOUNT;
        count++;
        //!!!!!!!!!!!!!!!!!!!!!!!!
        super.speed = 3;

    }
    public static void decrementCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void die() {

    }

    @Override
    public void move() {

    }

    @Override
    public void spawn() {

    }


}
