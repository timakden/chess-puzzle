package ru.timakden.chesspuzzle

/**
 * Слон, перемещается на любое число полей по диагонали.
 */
class Bishop(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "B"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return Math.abs(row - anotherPiece.row) == Math.abs(column - anotherPiece.column)
    }
}
