package ru.hozhasaitov.app.entity.map;

import java.util.Arrays;

public class PrintMap {
    private PrintMap() {
    }

    public static void printMap(Field[][] fields) {
//        Arrays.stream(fields).forEach(
//                f -> {
//                    Arrays.stream(f).forEach(
//                        s -> System.out.print(s.getRelief().getImage()));
//                System.out.println();
//                });

        for (Field[] field : fields) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[j].getView());
            }
            System.out.println();
        }
    }
}
