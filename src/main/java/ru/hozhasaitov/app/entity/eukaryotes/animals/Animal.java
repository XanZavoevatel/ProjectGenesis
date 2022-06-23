package ru.hozhasaitov.app.entity.eukaryotes.animals;

import ru.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.hozhasaitov.app.entity.map.Cell;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.interfaces.*;
import ru.hozhasaitov.app.util.Randomaizer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Animal extends Eukaryote implements Movable, Spawnable, Dieable, Eatable {
    Cell[][] gameMap = GameMap.GAME_MAP.getMap();
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

    @Override
    public void move() {

        boolean isMoved = false;
        int coorX = this.getCoorX();
        int coorY = this.getCoorY();

        Cell[] lineX;
        int off = Math.max(coorX - this.getSpeed(), 0);
        int to = Math.min(coorX + this.getSpeed() + 1, gameMap[coorY].length);
        lineX = Arrays.copyOfRange(gameMap[coorY], off, to);

        int offY = Math.max(coorY - this.getSpeed(), 0);
        int toY = Math.min(coorY + this.getSpeed() + 1, gameMap.length);

        Cell[] lineY = new Cell[toY - offY];
        for (int i = offY, j = 0; i < gameMap.length; i++, j++) {
            lineY[j] = gameMap[i][coorX];
        }

        isMoved = searchWayX(this, coorX, coorY, lineX, off);
        if (!isMoved)
            searchWayY(this, coorX, coorY, lineY, offY);
    }

    private boolean searchWayX(Animal animal, int coorX, int coorY, Cell[] line, int off) {
        int start = line.length % 2 == 0 ? line.length / 2 : line.length / 2 + 1;
        int counter = start;
        boolean isFoundRoute = false;
        isFoundRoute = foundRoute(animal, coorX, coorY, line, off, start, counter, isFoundRoute, true);
        return isFoundRoute;

    }

    private boolean searchWayY(Animal animal, int coorX, int coorY, Cell[] line, int off) {
        int start = line.length % 2 == 0 ? line.length / 2 : line.length / 2 + 1;
        int counter = start;
        boolean isFoundRoute = false;
        isFoundRoute = foundRoute(animal, coorX, coorY, line, off, start, counter, isFoundRoute, false);
        return isFoundRoute;

    }

    private boolean foundRoute(Animal animal, int coorX, int coorY, Cell[] line,
                               int off, int start, int counter, boolean isFoundRoute, boolean thisX) {
        if (animal instanceof PredatoryAnimal) {
            while (!isFoundRoute && counter < line.length) {
                if (line[counter].getHerbivorousAnimals().size() != 0) {
                    removeAnimal(animal, coorX, coorY, off, counter, thisX);
                    isFoundRoute = true;
                    break;
                }
                counter++;
            }
            if (!isFoundRoute) {
                counter = start - 1;

                while (counter >= 0) {
                    if (line[counter].getHerbivorousAnimals().size() != 0) {
                        removeAnimal(animal, coorX, coorY, off, counter, thisX);
                        isFoundRoute = true;

                    }
                    counter--;
                }
            }

        } else {
            while (!isFoundRoute && counter < line.length) {
                if (line[counter].getPlants().size() != 0) {
                    removeAnimal(animal, coorX, coorY, off, counter, thisX);
                    isFoundRoute = true;
                    break;
                }
                counter++;
            }
            if (!isFoundRoute) {
                counter = start - 1;

                while (counter >= 0) {
                    if (line[counter].getPlants().size() != 0) {
                        removeAnimal(animal, coorX, coorY, off, counter, thisX);
                        isFoundRoute = true;

                    }
                    counter--;
                }
            }

        }
        return isFoundRoute;
    }

    private void removeAnimal(Animal animal, int coorX, int coorY, int off, int counter, boolean thisX) {
        if (thisX) {
            if (animal instanceof PredatoryAnimal) {
                gameMap[coorY][off + counter].getPredatoryAnimals().add((PredatoryAnimal) animal);
                animal.setCoorX(off + counter);
                animal.setCoorY(coorY);
                gameMap[coorY][coorX].getPredatoryAnimals().remove((PredatoryAnimal) animal);
            }
            if (animal instanceof HerbivorousAnimal) {
                gameMap[coorY][off + counter].getHerbivorousAnimals().add((HerbivorousAnimal) animal);
                animal.setCoorX(off + counter);
                animal.setCoorY(coorY);
                gameMap[coorY][coorX].getHerbivorousAnimals().remove((HerbivorousAnimal) animal);
            }
        } else {
            if (animal instanceof PredatoryAnimal) {
                gameMap[off + counter][coorX].getPredatoryAnimals().add((PredatoryAnimal) animal);
                animal.setCoorX(coorX);
                animal.setCoorY(off + counter);
                gameMap[coorY][coorX].getPredatoryAnimals().remove((PredatoryAnimal) animal);
            }
            if (animal instanceof HerbivorousAnimal) {
                gameMap[off + counter][coorX].getHerbivorousAnimals().add((HerbivorousAnimal) animal);
                animal.setCoorX(coorX);
                animal.setCoorY(off + counter);
                gameMap[coorY][coorX].getHerbivorousAnimals().remove((HerbivorousAnimal) animal);
            }
        }
    }


    @Override
    public void spawn() {

    }

    @Override
    public void eat(Map<Class<?>, Integer> foodMap) {
        if (this instanceof PredatoryAnimal) {
            List<HerbivorousAnimal> herbivorousAnimals = gameMap[this.getCoorY()][this.getCoorX()]
                    .getHerbivorousAnimals().stream().filter(h -> foodMap.containsKey(h.getClass())).toList();
            for (int i = 0; i < herbivorousAnimals.size(); i++) {
                HerbivorousAnimal h = herbivorousAnimals.get(i);
                if (tryingEat(h, foodMap.get(h.getClass()))) {
                    break;
                }
            }

        }
    }

    private boolean tryingEat(HerbivorousAnimal h, Integer integer) {
        List<HerbivorousAnimal> herbivorousAnimals = gameMap[h.getCoorY()][getCoorX()]
                .getHerbivorousAnimals();

        if (integer >= Randomaizer.randomInt()) {

            herbivorousAnimals.remove(h);
            decrementСounterAnimal(h);
            return  true;
        }
        return false;
    }

    private void decrementСounterAnimal(Eukaryote e) {
        try {
            java.lang.reflect.Field count = e.getClass().getDeclaredField("count");
            count.setAccessible(true);
            int value = count.getInt(e);
            count.set(e, value - 1);
        } catch (NoSuchFieldException | IllegalAccessException u) {
            System.out.println("Не получилось уменьшить счетчик животного");
        }
    }
}
