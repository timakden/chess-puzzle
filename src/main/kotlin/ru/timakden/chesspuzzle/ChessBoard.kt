package ru.timakden.chesspuzzle

class ChessBoard(
    val rows: Int,
    val columns: Int,
    val remainingPieces: MutableList<String>
) {
    val placedPieces = mutableListOf<ChessPiece>()

    fun isCellFree(row: Int, column: Int) = placedPieces.none { it.row == row && it.column == column }
}
