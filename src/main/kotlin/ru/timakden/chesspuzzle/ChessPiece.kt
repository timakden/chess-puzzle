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
        val column: Int) {
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
