package ru.timakden.chesspuzzle

/**
 * Ферзь, перемещается на любое число свободных полей в любом направлении.
 */
class Queen(row: Int, column: Int) : ChessPiece(row, column) {

    override fun toString(): String {
        return "Q"
    }

    override fun canAttackAnotherChessPiece(anotherChessPiece: ChessPiece): Boolean {
        val row = row
        val column = column
        val anotherRow = anotherChessPiece.row
        val anotherColumn = anotherChessPiece.column

        return Math.abs(row - anotherRow) == Math.abs(column - anotherColumn) || row == anotherRow ||
                column == anotherColumn
    }
}
