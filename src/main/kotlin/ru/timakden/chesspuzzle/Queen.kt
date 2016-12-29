package ru.timakden.chesspuzzle

/**
 * Ферзь, перемещается на любое число свободных полей в любом направлении.
 */
class Queen(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "Q"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return Math.abs(row - anotherPiece.row) == Math.abs(column - anotherPiece.column) ||
                row == anotherPiece.row ||
                column == anotherPiece.column
    }
}
