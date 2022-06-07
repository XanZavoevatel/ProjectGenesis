package ru.hozhasaitov.app.classes.eukaryotes;

public abstract class Eukaryote {
    protected int maximumAmount;


    protected double weight;

    public double getWeight() {
        return weight;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

//-------------ABSTRACT------------------
    protected abstract void spawn();
}
