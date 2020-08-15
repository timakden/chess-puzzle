package ru.timakden.chesspuzzle

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class ChessPuzzleSpec : WordSpec({
    "ChessPuzzleSolver" should {
        "solve \"Eight Queens Problem\"" {
            val eightQueensPuzzle = ChessPuzzle(8, 8, 0, 8, 0, 0, 0)
            eightQueensPuzzle.solve()
            eightQueensPuzzle.numberOfUniqueSolutions shouldBe 92
        }

        "solve \"Eleven Queens Problem\"" {
            val elevenQueensPuzzle = ChessPuzzle(11, 11, 0, 11, 0, 0, 0)
            elevenQueensPuzzle.solve()
            elevenQueensPuzzle.numberOfUniqueSolutions shouldBe 2680
        }

        "solve \"Two Kings, One Rook Problem\"" {
            val twoKingsOneRookPuzzle = ChessPuzzle(3, 3, 2, 0, 1, 0, 0)
            twoKingsOneRookPuzzle.solve()
            twoKingsOneRookPuzzle.numberOfUniqueSolutions shouldBe 4
        }

        "solve \"Two Rooks, Eight Knights Problem\"" {
            val twoRooksEightKnightsPuzzle = ChessPuzzle(4, 4, 0, 0, 2, 0, 4)
            twoRooksEightKnightsPuzzle.solve()
            twoRooksEightKnightsPuzzle.numberOfUniqueSolutions shouldBe 8
        }
    }
})
