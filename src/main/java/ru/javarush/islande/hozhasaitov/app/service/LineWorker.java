package ru.javarush.islande.hozhasaitov.app.service;

import ru.javarush.islande.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.islande.hozhasaitov.app.entity.map.Cell;
import ru.javarush.islande.hozhasaitov.app.util.AppendEukaryotesToSet;
import ru.javarush.islande.hozhasaitov.app.util.ImplementationConduct;

import java.util.*;

public class LineWorker implements Runnable {

    private  final Cell[] lineMap;

    public LineWorker(Cell[] lineMap) {
        this.lineMap = lineMap;
    }


    @Override
    public void run() {
        Set<Eukaryote> eukaryotes = new HashSet<>();
        AppendEukaryotesToSet.append(lineMap, eukaryotes);
        ImplementationConduct.invokMethods(eukaryotes);
    }

}
