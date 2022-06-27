package ru.hozhasaitov.app.entity.eukaryotes.animals;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.entity.map.Cell;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.interfaces.*;
import ru.hozhasaitov.app.util.GetterLineX;
import ru.hozhasaitov.app.util.SearcherPrey;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
