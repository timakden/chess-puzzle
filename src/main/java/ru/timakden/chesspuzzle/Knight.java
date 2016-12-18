package ru.timakden.chesspuzzle;

/**
 * Конь, перемещается на любое поле доски Г-образным или L-образным ходом.
 */
class Knight extends ChessPiece {
    Knight(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        return "N";
    }

    public boolean canAttackAnotherChessPiece(ChessPiece anotherChessPiece) {
        int row = getRow();
        int column = getColumn();
        int anotherRow = anotherChessPiece.getRow();
        int anotherColumn = anotherChessPiece.getColumn();

        return ((Math.abs(row - anotherRow) == 2) && (Math.abs(column - anotherColumn) == 1)) ||
                ((Math.abs(row - anotherRow) == 1) && (Math.abs(column - anotherColumn) == 2));
    }
}
