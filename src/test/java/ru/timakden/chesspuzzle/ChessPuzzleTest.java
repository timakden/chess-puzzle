package ru.timakden.chesspuzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChessPuzzleTest {
    @Test
    public void testEightQueens() throws Exception {
        ChessPuzzle eightQueensPuzzle = new ChessPuzzle(8, 8, 0, 8, 0, 0, 0);
        eightQueensPuzzle.solve();
        assertEquals(eightQueensPuzzle.getNumberOfUniqueSolutions(), 92);
    }

    @Test
    public void testElevenQueens() throws Exception {
        ChessPuzzle elevenQueensPuzzle = new ChessPuzzle(11, 11, 0, 11, 0, 0, 0);
        elevenQueensPuzzle.solve();
        assertEquals(elevenQueensPuzzle.getNumberOfUniqueSolutions(), 2680);
    }

    @Test
    public void testTwoKingsOneRook() throws Exception {
        ChessPuzzle twoKingsOneRookPuzzle = new ChessPuzzle(3, 3, 2, 0, 1, 0, 0);
        twoKingsOneRookPuzzle.solve();
        assertEquals(twoKingsOneRookPuzzle.getNumberOfUniqueSolutions(), 4);
    }

    @Test
    public void testTwoRooksEightKnights() throws Exception {
        ChessPuzzle twoRooksEightKnightsPuzzle = new ChessPuzzle(4, 4, 0, 0, 2, 0, 4);
        twoRooksEightKnightsPuzzle.solve();
        assertEquals(twoRooksEightKnightsPuzzle.getNumberOfUniqueSolutions(), 8);
    }
}
