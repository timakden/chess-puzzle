package ru.timakden.chesspuzzle

/**
 * Слон, перемещается на любое число полей по диагонали.
 */
class Bishop(row: Int, column: Int) : ChessPiece(row, column) {

    override fun toString(): String {
        return "B"
    }

    override fun canAttackAnotherChessPiece(anotherChessPiece: ChessPiece): Boolean {
        val row = row
        val column = column
        val anotherRow = anotherChessPiece.row
        val anotherColumn = anotherChessPiece.column

        return Math.abs(row - anotherRow) == Math.abs(column - anotherColumn)
    }
}
