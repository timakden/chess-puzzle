package ru.timakden.chesspuzzle

import org.tinylog.kotlin.Logger
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
fun main(args: Array<String>) {
    try {
        require(args.size == 7) {
            "Программу нужно запускать с 7 аргументами: строки столбцы короли ферзи ладьи слоны кони"
        }

        val rows = args[0].toInt()
        val columns = args[1].toInt()
        val kings = args[2].toInt()
        val queens = args[3].toInt()
        val rooks = args[4].toInt()
        val bishops = args[5].toInt()
        val knights = args[6].toInt()

        val chessPuzzle = ChessPuzzle(rows, columns, kings, queens, rooks, bishops, knights)

        val duration = measureTime {
            chessPuzzle.solve()
        }

        Logger.info("Число комбинаций: ${chessPuzzle.numberOfUniqueSolutions}")
        Logger.info("Затраченное время: $duration")
    } catch (e: Exception) {
        Logger.error(e, "Во время выполнения программы произошла ошибка!")
    }
}
