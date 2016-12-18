package ru.timakden.chesspuzzle

/**
 * Ладья, перемещается на любое число полей по вертикали или горизонтали.
 */
class Rook(row: Int, column: Int) : ChessPiece(row, column) {

    override fun toString(): String {
        return "R"
    }

    override fun canAttackAnotherChessPiece(anotherChessPiece: ChessPiece): Boolean {
        val row = row
        val column = column
        val anotherRow = anotherChessPiece.row
        val anotherColumn = anotherChessPiece.column

        return row == anotherRow || column == anotherColumn
    }
}

