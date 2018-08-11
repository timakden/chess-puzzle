package ru.timakden.chesspuzzle

/**
 * Абстрактный класс для описания шахматной фигуры; содержит методы для определения, может ли фигура атаковать или
 * быть атакованной другой фигурой.
 */
abstract class ChessPiece(
    /**
     * Строка, на которой расположена шахматная фигура.
     */
    val row: Int,

    /**
     * Столбец, на котором расположена шахматная фигура.
     */
    val column: Int
) {
    /**
     * Фигура является "безопасной", если она не может атаковать другую фигуру или другая фигура не может атаковать её.
     */
    fun isSafe(board: ChessBoard): Boolean {
        var isSafe = true

        board.placedPieces.forEach { piece ->
            isSafe = isSafe && !(this.canAttackAnotherPiece(piece) || (piece.canAttackAnotherPiece(this)))
        }

        return isSafe
    }

    abstract fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean
}

/**
 * Слон, перемещается на любое число полей по диагонали.
 */
class Bishop(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "B"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return Math.abs(row - anotherPiece.row) == Math.abs(column - anotherPiece.column)
    }
}

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

/**
 * Ладья, перемещается на любое число полей по вертикали или горизонтали.
 */
class Rook(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "R"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean {
        return row == anotherPiece.row || column == anotherPiece.column
    }
}

/**
 * Фабрика для создания шахматных фигур.
 */
class ChessPieceFactory {
    fun getPiece(pieceType: String, row: Int, column: Int): ChessPiece {
        return when (pieceType) {
            "K" -> King(row, column)
            "R" -> Rook(row, column)
            "N" -> Knight(row, column)
            "Q" -> Queen(row, column)
            "B" -> Bishop(row, column)
            else -> throw IllegalArgumentException("Unknown chess piece type: $pieceType")
        }
    }
}
