package ru.timakden.chesspuzzle

/**
 * Конь, перемещается на любое поле доски Г-образным или L-образным ходом.
 */
class Knight(row: Int, column: Int) : ChessPiece(row, column) {

    override fun toString(): String {
        return "N"
    }

    override fun canAttackAnotherChessPiece(anotherChessPiece: ChessPiece): Boolean {
        val row = row
        val column = column
        val anotherRow = anotherChessPiece.row
        val anotherColumn = anotherChessPiece.column

        return Math.abs(row - anotherRow) == 2 && Math.abs(column - anotherColumn) == 1 ||
                Math.abs(row - anotherRow) == 1 && Math.abs(column - anotherColumn) == 2
    }
}
