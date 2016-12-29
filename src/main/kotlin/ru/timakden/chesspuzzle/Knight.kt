package ru.timakden.chesspuzzle

/**
 * Конь, перемещается на любое поле доски Г-образным или L-образным ходом.
 */
class Knight(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "N"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return Math.abs(row - anotherPiece.row) == 2 && Math.abs(column - anotherPiece.column) == 1 ||
                Math.abs(row - anotherPiece.row) == 1 && Math.abs(column - anotherPiece.column) == 2
    }
}
