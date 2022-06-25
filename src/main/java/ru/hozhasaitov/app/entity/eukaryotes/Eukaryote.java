package ru.hozhasaitov.app.entity.eukaryotes;

public abstract class Eukaryote {

    protected int limitAmount;
    protected int coorX;
    protected int coorY;


    public Eukaryote() {

    }

    protected double weight;

    public double getWeight() {
        return weight;
    }

    public int getLimitAmount() {
        return limitAmount;
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
