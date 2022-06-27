package ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.animals;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.islande.hozhasaitov.app.entity.map.Cell;
import ru.javarush.islande.hozhasaitov.app.entity.map.GameMap;
import ru.javarush.islande.hozhasaitov.app.interfaces.*;

public abstract class Animal extends Eukaryote implements Movable, Eatable, SearchablePrey {
    protected Cell[][] gameMap = GameMap.GAME_MAP.getMap();
    protected int speed;
    protected double amountFod;

    public int getSpeed() {
        return speed;
    }

    public double getAmountFod() {
        return amountFod;
    }

    //-------------IMPLEMENTATION------------------


    @Override
    public void die() {

    }









}
