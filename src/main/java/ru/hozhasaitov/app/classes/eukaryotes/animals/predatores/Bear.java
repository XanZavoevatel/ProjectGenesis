package ru.hozhasaitov.app.classes.eukaryotes.animals.predatores;

import ru.hozhasaitov.app.classes.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.constants.Constants;

public class Bear extends Animal implements PredatoryAnimal {

    public Bear() {
        super.weight = Constants.BEAR_WEIGHT;

    }

    @Override
    protected void spawn() {

    }

    @Override
    protected void move() {

    }

    @Override
    protected void die() {

    }

    @Override
    public void predatoryAnimalEat() {

    }
}
