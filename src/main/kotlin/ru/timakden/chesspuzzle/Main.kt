package ru.timakden.chesspuzzle

import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val logger = LoggerFactory.getLogger("ru.timakden.chesspuzzle.Main")
    if (args.size != 7) {
        println("Программу нужно запускать с 7 аргументами: строки столбцы короли ферзи ладьи слоны кони")
    } else {
        try {
            val rows = args[0].toInt()
            val columns = args[1].toInt()
            val kings = args[2].toInt()
            val queens = args[3].toInt()
            val rooks = args[4].toInt()
            val bishops = args[5].toInt()
            val knights = args[6].toInt()

            val chessPuzzle = ChessPuzzle(rows, columns, kings, queens, rooks, bishops, knights)

            var milliseconds = measureTimeMillis {
                chessPuzzle.solve()
            }

            val hours = milliseconds / (1000 * 60 * 60) % 24
            val minutes = milliseconds / (1000 * 60) % 60
            val seconds = milliseconds / 1000 % 60
            milliseconds %= 1000

            val elapsedTime = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds)

            println("Количество комбинаций: ${chessPuzzle.numberOfUniqueSolutions}")
            println("    Затраченное время: $elapsedTime")
        } catch (e: NumberFormatException) {
            logger.error("Один из указанных аргументов командной строки не является целым числом", e)
        }
    }
}
