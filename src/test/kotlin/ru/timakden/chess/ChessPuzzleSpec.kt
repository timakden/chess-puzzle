package ru.timakden.chess

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class ChessPuzzleSpec : FunSpec({
    context("ChessPuzzle") {
        withData(
            nameFn = { "input = ${it.first}, expected = ${it.second}" },
            ts = listOf(
                ChessPuzzle(8, 8, 0, 8, 0, 0, 0) to 92,
                ChessPuzzle(11, 11, 0, 11, 0, 0, 0) to 2680,
                ChessPuzzle(3, 3, 2, 0, 1, 0, 0) to 4,
                ChessPuzzle(4, 4, 0, 0, 2, 0, 4) to 8,
                ChessPuzzle(6, 9, 2, 1, 1, 1, 1) to 20136752
            )
        ) { (puzzle, expected) ->
            shouldNotThrowAny { puzzle.solve() }
            puzzle.numberOfUniqueSolutions shouldBe expected
        }
    }
})
