package ru.hozhasaitov.app.service;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;

public class PrinterInfo {

    private PrinterInfo() {
    }

    public static void print(Eukaryote eukaryote) {
        System.out.printf("%s: X = %d, Y = %d.", eukaryote.getClass().getName(),
                eukaryote.getCoorX(), eukaryote.getCoorY());
    }
}
