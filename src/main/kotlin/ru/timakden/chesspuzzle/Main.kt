package ru.timakden.chesspuzzle

import org.tinylog.kotlin.Logger
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
fun main(args: Array<String>) {
    try {
        require(args.size == 7) {
            "This program must be executed with 7 args: rows columns kings queens rooks bishops knights"
        }

        val rows = args[0].toInt()
        val columns = args[1].toInt()
        val kings = args[2].toInt()
        val queens = args[3].toInt()
        val rooks = args[4].toInt()
        val bishops = args[5].toInt()
        val knights = args[6].toInt()

        val chessPuzzle = ChessPuzzle(rows, columns, kings, queens, rooks, bishops, knights)

        Logger.info { "Initial data: $chessPuzzle" }

        val duration = measureTime { chessPuzzle.solve() }

        Logger.info { "Number of unique solutions: ${chessPuzzle.numberOfUniqueSolutions}" }
        Logger.info { "Elapsed time: $duration" }
    } catch (e: Exception) {
        Logger.error(e) { "An error occurred during the execution!" }
    }
}
