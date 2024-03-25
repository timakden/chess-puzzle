package ru.timakden.chess

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.tuple
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class ChessPuzzleSpec : FunSpec({
    context("ChessPuzzle") {
        withData(
            nameFn = { "input = ${it.a}, expected = ${it.b}" },
            ts = listOf(
                tuple(ChessPuzzle(8, 8, 0, 8, 0, 0, 0), 92),
                tuple(ChessPuzzle(11, 11, 0, 11, 0, 0, 0), 2680),
                tuple(ChessPuzzle(3, 3, 2, 0, 1, 0, 0), 4),
                tuple(ChessPuzzle(4, 4, 0, 0, 2, 0, 4), 8),
                tuple(ChessPuzzle(6, 9, 2, 1, 1, 1, 1), 20136752)
            )
        ) { (puzzle, expected) ->
            shouldNotThrowAny { puzzle.solve() }
            puzzle.numberOfUniqueSolutions shouldBe expected
        }
    }
})
