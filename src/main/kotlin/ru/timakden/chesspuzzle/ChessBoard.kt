package ru.timakden.chesspuzzle

/**
 * Шахматная доска.
 */
class ChessBoard(
        /**
         * Число строк (высота доски).
         */
        val rows: Int,
        /**
         * Число столбцов (ширина доски).
         */
        val columns: Int,
        /**
         * Шахматные фигуры, которые осталось разместить на доске.
         */
        val remainingChessPieces: MutableList<String>) {

    /**
     * Шахматные фигуры, расположенные на доске.
     */
    val placedChessPieces = mutableListOf<ChessPiece>()

    /**
     * Определение того, занята ли клетка с координатами `(row, column)` какой-нибудь шахматной фигурой.
     */
    fun isCellFree(row: Int, column: Int): Boolean {
        return placedChessPieces.none { it.row == row && it.column == column }
    }
}
