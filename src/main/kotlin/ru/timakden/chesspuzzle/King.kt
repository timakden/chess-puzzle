package ru.timakden.chesspuzzle

/**
 * Король, перемещается на любое соседнее поле в любом направлении.
 */
class King(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "K"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return Math.abs(row - anotherPiece.row) == 1 && Math.abs(column - anotherPiece.column) == 1 ||
                row == anotherPiece.row && Math.abs(column - anotherPiece.column) == 1 ||
                column == anotherPiece.column && Math.abs(row - anotherPiece.row) == 1
    }
}
