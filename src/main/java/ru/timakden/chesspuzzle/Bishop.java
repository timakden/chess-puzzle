package ru.timakden.chesspuzzle;

/**
 * Слон, перемещается на любое число полей по диагонали.
 */
class Bishop extends ChessPiece {
    Bishop(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        return "B";
    }

    public boolean canAttackAnotherChessPiece(ChessPiece anotherChessPiece) {
        int row = getRow();
        int column = getColumn();
        int anotherRow = anotherChessPiece.getRow();
        int anotherColumn = anotherChessPiece.getColumn();

        return Math.abs(row - anotherRow) == Math.abs(column - anotherColumn);
    }
}
