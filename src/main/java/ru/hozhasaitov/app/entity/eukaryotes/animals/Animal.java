package ru.hozhasaitov.app.entity.eukaryotes.animals;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.interfaces.Dieable;
import ru.hozhasaitov.app.interfaces.Movable;

public abstract class Animal extends Eukaryote {
    protected int speed;
    protected double amountFod;

    public int getSpeed() {
        return speed;
    }

    public double getAmountFod() {
        return amountFod;
    }

    //-------------ABSTRACT------------------




}
