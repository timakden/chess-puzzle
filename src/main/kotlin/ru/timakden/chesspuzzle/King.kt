package ru.timakden.chesspuzzle

/**
 * Король, перемещается на любое соседнее поле в любом направлении.
 */
class King(row: Int, column: Int) : ChessPiece(row, column) {

    override fun toString(): String {
        return "K"
    }

    override fun canAttackAnotherChessPiece(anotherChessPiece: ChessPiece): Boolean {
        val row = row
        val column = column
        val anotherRow = anotherChessPiece.row
        val anotherColumn = anotherChessPiece.column

        return Math.abs(row - anotherRow) == 1 && Math.abs(column - anotherColumn) == 1 ||
                row == anotherRow && Math.abs(column - anotherColumn) == 1 ||
                column == anotherColumn && Math.abs(row - anotherRow) == 1
    }
}
