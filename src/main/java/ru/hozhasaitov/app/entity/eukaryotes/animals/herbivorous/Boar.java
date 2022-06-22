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
