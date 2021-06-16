package ru.timakden.chesspuzzle

import kotlin.math.abs

sealed class ChessPiece(val row: Int, val column: Int) {
    /** A chess piece is "safe" when it can't attack another piece or be attacked by another piece. */
    fun isSafe(board: ChessBoard): Boolean {
        board.placedPieces.forEach { piece ->
            if (canAttackAnotherPiece(piece) || piece.canAttackAnotherPiece(this)) return false
        }

        return true
    }

    abstract fun canAttackAnotherPiece(anotherPiece: ChessPiece): Boolean
}

/** Bishop can move any number of squares diagonally. */
class Bishop(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "B"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece) =
        abs(row - anotherPiece.row) == abs(column - anotherPiece.column)
}

/** King moves one square in any direction. */
class King(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "K"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece) =
        abs(row - anotherPiece.row) == 1 && abs(column - anotherPiece.column) == 1 ||
                row == anotherPiece.row && abs(column - anotherPiece.column) == 1 ||
                column == anotherPiece.column && abs(row - anotherPiece.row) == 1
}

/** Knight moves to any of the closest squares that are not on the same rank, file, or diagonal ("L"-shape). */
class Knight(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "N"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece) =
        abs(row - anotherPiece.row) == 2 && abs(column - anotherPiece.column) == 1 ||
                abs(row - anotherPiece.row) == 1 && abs(column - anotherPiece.column) == 2
}

/** Queen can move any number of squares along a rank, file, or diagonal. */
class Queen(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "Q"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece) =
        abs(row - anotherPiece.row) == abs(column - anotherPiece.column) ||
                row == anotherPiece.row || column == anotherPiece.column
}

/** Rook can move any number of squares along a rank or file. */
class Rook(row: Int, column: Int) : ChessPiece(row, column) {
    override fun toString() = "R"

    override fun canAttackAnotherPiece(anotherPiece: ChessPiece) =
        row == anotherPiece.row || column == anotherPiece.column
}
