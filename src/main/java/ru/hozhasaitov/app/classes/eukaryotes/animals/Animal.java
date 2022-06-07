package ru.hozhasaitov.app.classes.eukaryotes.animals;

import ru.hozhasaitov.app.classes.eukaryotes.Eukaryote;

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

    protected abstract void move();
    protected abstract void die();




}
