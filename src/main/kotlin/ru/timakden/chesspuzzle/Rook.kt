package ru.timakden.chesspuzzle

/**
 * Ладья, перемещается на любое число полей по вертикали или горизонтали.
 */
class Rook(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "R"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return row == anotherPiece.row || column == anotherPiece.column
    }
}
