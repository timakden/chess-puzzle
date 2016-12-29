package ru.timakden.chesspuzzle

/**
 * Фабрика для создания шахматных фигур.
 */
class ChessPieceFactory {
    fun getPiece(pieceType: String, row: Int, column: Int): ChessPiece {
        when (pieceType) {
            "K" -> return King(row, column)
            "R" -> return Rook(row, column)
            "N" -> return Knight(row, column)
            "Q" -> return Queen(row, column)
            "B" -> return Bishop(row, column)
            else -> throw IllegalArgumentException("Unknown chess piece type: $pieceType")
        }
    }
}
