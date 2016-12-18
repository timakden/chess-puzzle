package ru.timakden.chesspuzzle;

/**
 * Абстрактный класс для описания шахматной фигуры; содержит методы для определения, может ли фигура атаковать или быть атакованной
 * другой фигурой.
 */
abstract class ChessPiece {
    /**
     * Строка, на которой расположена шахматная фигура.
     */
    private int row;

    /**
     * Столбец, на котором расположена шахматная фигура.
     */
    private int column;

    ChessPiece(int row, int column) {
        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    /**
     * Фигура является "безопасной", если она не может атаковать другую фигуру или другая фигура не может атаковать её.
     */
    boolean isSafe(ChessBoard chessBoard) {
        boolean isSafe = true;

        for (ChessPiece chessPiece : chessBoard.getPlacedChessPieces()) {
            isSafe &= !(this.canAttackAnotherChessPiece(chessPiece) || chessPiece.canAttackAnotherChessPiece(this));
        }

        return isSafe;
    }

    public abstract boolean canAttackAnotherChessPiece(ChessPiece anotherChessPiece);
}
