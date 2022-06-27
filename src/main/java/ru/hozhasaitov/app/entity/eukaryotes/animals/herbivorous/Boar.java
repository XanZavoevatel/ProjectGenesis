package ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous;

import ru.hozhasaitov.app.constants.Constants;
import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.interfaces.HerbivorousAnimal;

public class Boar extends HerbivorousAnimal {

    private static int count;
    public Boar() {
        super.weight = Constants.BOAR_WEIGHT;
        super.maximumAmount = Constants.BOAR_MAXIMUM_AMOUNT;
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
    public void move(int[] coordinates) {

    }

    @Override
    public void spawn() {

    }

    @Override
    public int[] searchPrey() {
        return new int[0];
    }

    @Override
    public void eat() {

    }
}
