package ru.hozhasaitov.app.entity.eukaryotes;

import ru.hozhasaitov.app.interfaces.Spawnable;

import java.util.Map;

public abstract class Eukaryote {

    protected Map<Class<?> , Integer> diet;

    protected int maximumAmount;
    protected int coorX;
    protected int coorY;


    public Eukaryote() {

    }

    protected double weight;

    public double getWeight() {
        return weight;
    }

    public Map<Class<?>, Integer> getDiet() {
        return diet;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }

//-------------ABSTRACT------------------

}
