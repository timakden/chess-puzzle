package ru.timakden.chesspuzzle

import org.junit.Assert.assertEquals
import org.junit.Test

class ChessPuzzleTest {
    @Test
    @Throws(Exception::class)
    fun testEightQueens() {
        val eightQueensPuzzle = ChessPuzzle(8, 8, 0, 8, 0, 0, 0)
        eightQueensPuzzle.solve()
        assertEquals(eightQueensPuzzle.numberOfUniqueSolutions.toLong(), 92)
    }

    @Test
    @Throws(Exception::class)
    fun testElevenQueens() {
        val elevenQueensPuzzle = ChessPuzzle(11, 11, 0, 11, 0, 0, 0)
        elevenQueensPuzzle.solve()
        assertEquals(elevenQueensPuzzle.numberOfUniqueSolutions.toLong(), 2680)
    }

    @Test
    @Throws(Exception::class)
    fun testTwoKingsOneRook() {
        val twoKingsOneRookPuzzle = ChessPuzzle(3, 3, 2, 0, 1, 0, 0)
        twoKingsOneRookPuzzle.solve()
        assertEquals(twoKingsOneRookPuzzle.numberOfUniqueSolutions.toLong(), 4)
    }

    @Test
    @Throws(Exception::class)
    fun testTwoRooksEightKnights() {
        val twoRooksEightKnightsPuzzle = ChessPuzzle(4, 4, 0, 0, 2, 0, 4)
        twoRooksEightKnightsPuzzle.solve()
        assertEquals(twoRooksEightKnightsPuzzle.numberOfUniqueSolutions.toLong(), 8)
    }
}
