package ru.javarush.islande.hozhasaitov.app.service;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.islande.hozhasaitov.app.entity.map.Cell;
import ru.javarush.islande.hozhasaitov.app.interfaces.PredatoryAnimal;
import ru.javarush.islande.hozhasaitov.app.util.AppendEukaryotesToSet;
import ru.javarush.islande.hozhasaitov.app.util.ImplementationConduct;

import java.util.*;

public class PredatorWorker implements Runnable {

    private  final PredatoryAnimal predatoryAnimal;

    public PredatorWorker(PredatoryAnimal predatoryAnimal) {
        this.predatoryAnimal = predatoryAnimal;

    }


    @Override
    public void run() {

        predatoryAnimal.die();
        predatoryAnimal.move(predatoryAnimal.searchPrey());
        predatoryAnimal.eat();
        predatoryAnimal.spawn();
    }

}
