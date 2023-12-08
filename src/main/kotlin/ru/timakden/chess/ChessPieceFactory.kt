package ru.timakden.chess

object ChessPieceFactory {
    fun getPiece(pieceType: String, row: Int, column: Int): ChessPiece {
        return when (pieceType) {
            KING -> King(row, column)
            ROOK -> Rook(row, column)
            KNIGHT -> Knight(row, column)
            QUEEN -> Queen(row, column)
            BISHOP -> Bishop(row, column)
            else -> error("Unknown chess piece type: $pieceType")
        }
    }
}
