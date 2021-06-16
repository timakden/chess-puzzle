package ru.timakden.chesspuzzle

object ChessPieceFactory {
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
