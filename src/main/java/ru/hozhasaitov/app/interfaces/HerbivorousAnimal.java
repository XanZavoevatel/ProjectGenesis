package ru.hozhasaitov.app.interfaces;

import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;

public abstract class HerbivorousAnimal extends Animal implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
