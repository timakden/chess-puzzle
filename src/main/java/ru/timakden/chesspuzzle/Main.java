package ru.timakden.chesspuzzle;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        if (args.length != 7) {
            System.out.println("Программу нужно запускать с 7 аргументами: строки столбцы короли ферзи ладьи слоны кони");
        } else {
            try {
                int rows = Integer.parseInt(args[0]);
                int columns = Integer.parseInt(args[1]);
                int kings = Integer.parseInt(args[2]);
                int queens = Integer.parseInt(args[3]);
                int rooks = Integer.parseInt(args[4]);
                int bishops = Integer.parseInt(args[5]);
                int knights = Integer.parseInt(args[6]);

                ChessPuzzle chessPuzzle = new ChessPuzzle(rows, columns, kings, queens, rooks, bishops, knights);

                long start = System.currentTimeMillis();
                chessPuzzle.solve();
                long end = System.currentTimeMillis();

                long totalTime = end - start;
                String hms = String.format("%02d:%02d:%02d.%02d",
                        TimeUnit.MILLISECONDS.toHours(totalTime),
                        TimeUnit.MILLISECONDS.toMinutes(totalTime) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(totalTime)),
                        TimeUnit.MILLISECONDS.toSeconds(totalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime)),
                        totalTime - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(totalTime)));

                System.out.println("Количество комбинаций: " + chessPuzzle.getNumberOfUniqueSolutions());
                System.out.println("    Затраченное время: " + hms);

            } catch (NumberFormatException e) {
                System.out.println("Один из указанных аргументов командной строки не является целым числом");
                e.printStackTrace();
            }
        }
    }
}
