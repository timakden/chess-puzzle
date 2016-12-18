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

            val elapsedTime = measureTimeMillis {
                chessPuzzle.solve()
            }

            println("Количество комбинаций: ${chessPuzzle.numberOfUniqueSolutions}")
            println("    Затраченное время: ${convertMillisToHumanReadableFormat(elapsedTime)}")
        } catch (e: NumberFormatException) {
            logger.error("Один из указанных аргументов командной строки не является целым числом", e)
        }
    }
}

private fun convertMillisToHumanReadableFormat(timeInMilliseconds: Long): String {
    val hours = timeInMilliseconds / (1000 * 60 * 60) % 24
    val minutes = timeInMilliseconds / (1000 * 60) % 60
    val seconds = timeInMilliseconds / 1000 % 60
    val milliseconds = timeInMilliseconds % 1000

    return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds)
}
