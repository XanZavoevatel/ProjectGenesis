package ru.hozhasaitov.app.classes.map;

import ru.hozhasaitov.app.classes.eukaryotes.Eukaryote;

import java.util.concurrent.ThreadLocalRandom;

public class Field {
    private Eukaryote eukaryote;
    private Relief relief;

    public Field() {
        randomRelief();
    }

    public Eukaryote getEukaryote() {
        return eukaryote;
    }

    public void setEukaryote(Eukaryote eukaryote) {
        this.eukaryote = eukaryote;
    }

    public Relief getRelief() {
        return relief;
    }

    private void randomRelief() {
       int random = ThreadLocalRandom.current().nextInt(1, 101);
       if (random < 30)
           relief = Relief.MOUNTAINS;
       if (random > 30 && random < 70)
           relief = Relief.PLAIN;
       if (random > 70)
           relief = Relief.MEADOW;

    }
}
