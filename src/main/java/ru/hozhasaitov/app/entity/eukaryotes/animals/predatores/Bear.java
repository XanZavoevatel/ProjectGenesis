package ru.hozhasaitov.app.entity.eukaryotes.animals.predatores;

import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.constants.Constants;
import ru.hozhasaitov.app.interfaces.PredatoryAnimal;

public class Bear extends PredatoryAnimal {
    private  int count;
    public Bear() {
        super.weight = Constants.BEAR_WEIGHT;
        super.speed = 3;
        count++;
    }


    @Override
    public void die() {

    }

    @Override
    public void spawn() {

    }
}
