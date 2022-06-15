package ru.hozhasaitov.app.service;

import ru.hozhasaitov.app.entity.eukaryotes.Plant;
import ru.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.hozhasaitov.app.entity.map.Field;
import ru.hozhasaitov.app.entity.map.GameMap;
import ru.hozhasaitov.app.interfaces.HerbivorousAnimal;
import ru.hozhasaitov.app.interfaces.Movable;
import ru.hozhasaitov.app.interfaces.PredatoryAnimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveEucaryote implements Movable{
    private Field[][] fields = GameMap.GAME_MAP.getMap();


    public MoveEucaryote() {
        

    }

    //---------------Implementation------------

    public void run() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j].getPredatoryAnimals().size() > 0) {
                    List<PredatoryAnimal> predatoryAnimals = fields[i][j].getPredatoryAnimals();
                    List<HerbivorousAnimal> herbivorousAnimals = fields[i][j].getHerbivorousAnimals();
                    List<Plant> plants = fields[i][j].getPlants();
                    move(predatoryAnimals);


                }
            }
        }
    }

    @Override
    public void move(List<?> eukaryotes) {
        List<PredatoryAnimal> predatoryAnimals = new ArrayList<>();
        List<HerbivorousAnimal> herbivorousAnimals = new ArrayList<>();
        if (eukaryotes.get(0) instanceof PredatoryAnimal) {
            predatoryAnimals = eukaryotes.stream().map(o -> (PredatoryAnimal) o).collect(Collectors.toList());

        } else if (eukaryotes.get(0) instanceof HerbivorousAnimal) {
            herbivorousAnimals = eukaryotes.stream().map(o-> (HerbivorousAnimal) o).collect(Collectors.toList());
        }

        movePredatory(predatoryAnimals);


    }

    private Field[] getLineXForMove(Animal animal) {
        int x = animal.getCoorX();
        int y = animal.getCoorY();
        int off = Math.max(x - animal.getSpeed(), 0);
        int to = Math.min(x + animal.getSpeed(), fields[y].length);

        return Arrays.copyOfRange(fields[y], off, to);
    }
    private Field[] getLineYForMove(Animal animal) {
        int x = animal.getCoorX();
        int y = animal.getCoorY();
        int off = Math.max(y - animal.getSpeed(), 0);
        int to = Math.min(y + animal.getSpeed(), fields.length);
        Field[] lineY = new Field[to - off + 1];
        for (int i = 0; i < fields.length; i++) {
            lineY[i] = fields[i][x];
        }
        return lineY;
    }

    private void movePredatory(List<PredatoryAnimal> predatoryAnimals) {
        predatoryAnimals.forEach(predatoryAnimal -> {
            boolean isMoved = false;
            int coorX = predatoryAnimal.getCoorX();
            int coorY = predatoryAnimal.getCoorY();

            int off = Math.max(coorX - predatoryAnimal.getSpeed(), 0);
            int to = Math.min(coorX + predatoryAnimal.getSpeed() + 1, fields[coorY].length);
            Field[] lineX = Arrays.copyOfRange(fields[coorY], off, to);

            int offY = Math.max(coorY - predatoryAnimal.getSpeed(), 0);
            int toY = Math.min(coorY + predatoryAnimal.getSpeed() + 1, fields.length);
            /*TODO вот тут проблема
            первый элемент является нул, с учетом того, чтон берется из инициализированного
            многомерного массив*/
            Field[] lineY =  new Field[toY - offY];
            for (int i = off, j = 0; i < fields.length; i++, j++) {
                lineY[j] = fields[i][coorX];
            }

            isMoved = searchWayX(predatoryAnimal, coorX, coorY, lineX, off);
            if (!isMoved)
                searchWayY(predatoryAnimal, coorX, coorY, lineY, offY);
        });

//        for (PredatoryAnimal predatoryAnimal : predatoryAnimals) {
//            boolean isMoved = false;
//            int coorX = predatoryAnimal.getCoorX();
//            int coorY = predatoryAnimal.getCoorY();
//            Field[] lineX = getLineXForMove(predatoryAnimal);
//            Field[] lineY = getLineYForMove(predatoryAnimal);
//            isMoved = searchWay(predatoryAnimal, coorX, coorY, lineX);
//            if (!isMoved)
//                searchWay(predatoryAnimal, coorX, coorY, lineY);
//
//        }

    }

    private boolean searchWayX(PredatoryAnimal predatoryAnimal, int coorX, int coorY, Field[] line, int off) {
        int start = line.length % 2 == 0 ? line.length / 2 : line.length / 2 + 1;
        int counter = start;
        boolean isFoundRoute = false;
        while (!isFoundRoute && counter < line.length) {
            if (line[counter].getHerbivorousAnimals().size() != 0) {
                fields[coorY][coorX].getPredatoryAnimals().remove(predatoryAnimal);
                fields[coorY][off + counter].getPredatoryAnimals().add(predatoryAnimal);
                isFoundRoute = true;
                break;
            }
            counter++;
        }
        if (!isFoundRoute) {
            counter = start - 1;

            while (counter >= 0) {
                if (line[counter].getHerbivorousAnimals().size() != 0) {
                    fields[coorY][off + counter].getPredatoryAnimals().add(predatoryAnimal);
                    fields[coorY][coorX].getPredatoryAnimals().remove(predatoryAnimal);
                    isFoundRoute = true;

                }
                counter--;
            }
        }

        return isFoundRoute;

    }
    private boolean searchWayY(PredatoryAnimal predatoryAnimal, int coorX, int coorY, Field[] line, int off) {
        int start = line.length % 2 == 0 ? line.length / 2 : line.length / 2 + 1;
        int counter = start;
        boolean isFoundRoute = false;
        while (!isFoundRoute && counter < line.length) {
            if (line[counter].getHerbivorousAnimals().size() != 0) {
                fields[coorY][coorX].getPredatoryAnimals().remove(predatoryAnimal);
                fields[off + counter][coorX].getPredatoryAnimals().add(predatoryAnimal);
                isFoundRoute = true;
            }
            counter++;
        }
        if (!isFoundRoute) {
            counter = start - 1;

            while (counter >= 0) {
                if (line[counter].getHerbivorousAnimals().size() != 0) {
                    fields[off + counter][coorX].getPredatoryAnimals().add(predatoryAnimal);
                    fields[coorY][coorX].getPredatoryAnimals().remove(predatoryAnimal);
                    isFoundRoute = true;

                }
                counter--;
            }
        }

        return isFoundRoute;

    }

    private void shiftAnimal(PredatoryAnimal predatoryAnimal, int coorX, int coorY, int start) {
        fields[coorY][coorX].getPredatoryAnimals().remove(predatoryAnimal);
        fields[coorY][coorX + start].getPredatoryAnimals().add(predatoryAnimal);
    }
}
