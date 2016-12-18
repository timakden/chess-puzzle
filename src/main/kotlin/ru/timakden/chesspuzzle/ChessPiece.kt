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
    fun isSafe(chessBoard: ChessBoard): Boolean {
        var isSafe = true

        chessBoard.placedChessPieces.forEach { chessPiece ->
            isSafe = isSafe && (!(this.canAttackAnotherChessPiece(chessPiece) ||
                    (chessPiece.canAttackAnotherChessPiece(this))))
        }

        return isSafe
    }

    abstract fun canAttackAnotherChessPiece(anotherChessPiece: ChessPiece): Boolean
}
