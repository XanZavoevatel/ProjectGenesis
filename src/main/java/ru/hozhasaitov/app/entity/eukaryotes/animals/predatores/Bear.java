package ru.hozhasaitov.app.entity.eukaryotes.animals.predatores;

import ru.hozhasaitov.app.constants.Constants;
import ru.hozhasaitov.app.constants.Diet;
import ru.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.HashMap;
import java.util.Map;

public class Bear extends PredatoryAnimal {
    private static int count;

    public Bear() {
        super.weight = Constants.BEAR_WEIGHT;
        super.speed = 3;
        super.limitAmount = Constants.BEAR_LIMIT_AMOUNT;
        super.amountFod = 8;
        count++;
        super.foodMap = Diet.DIET_BEAR;
    }

    public int getCount() {
        return count;
    }

    public static void decrementCount() {
        count--;
    }

    @Override
    public void die() {
        super.die();
    }

    @Override
    public void move() {
        super.move();
    }



    @Override
    protected Bear clone() throws CloneNotSupportedException {
        count++;
        return (Bear) super.clone();
    }
}
