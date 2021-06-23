package ru.timakden.chesspuzzle

data class ChessPuzzle(
    val rows: Int,
    val columns: Int,
    val kings: Int,
    val queens: Int,
    val rooks: Int,
    val bishops: Int,
    val knights: Int
) {
    var numberOfUniqueSolutions = 0
        private set

    private val board: ChessBoard

    private val lastPlacedPieces = mutableMapOf<String, ChessPiece?>()

    init {
        val remainingChessPieces = mutableListOf<String>()

        repeat(kings) { remainingChessPieces += KING }
        repeat(queens) { remainingChessPieces += QUEEN }
        repeat(rooks) { remainingChessPieces += ROOK }
        repeat(bishops) { remainingChessPieces += BISHOP }
        repeat(knights) { remainingChessPieces += KNIGHT }

        board = ChessBoard(rows, columns, ArrayDeque(remainingChessPieces))
    }

    fun solve() {
        // Take first available piece
        val pieceType = board.remainingPieces.removeFirst()

        var r = 0
        var c = 0

        // Get last placed piece of that type
        lastPlacedPieces[pieceType]?.let {
            // Skip duplicated solutions
            r = it.row
            c = it.column + 1
        }

        for (row in r until board.rows) {
            for (column in c until board.columns) {
                // If cell is occupied then skip current iteration
                if (!board.isCellFree(row, column)) continue

                val pieceToPlace = ChessPieceFactory.getPiece(pieceType, row, column)

                // If this piece can't be safely placed then skip current iteration
                if (!pieceToPlace.isSafe(board)) continue

                // Add piece to board
                board.placedPieces.add(0, pieceToPlace)
                lastPlacedPieces[pieceToPlace.toString()] = pieceToPlace

                if (board.remainingPieces.isEmpty()) numberOfUniqueSolutions++ else solve()

                // Remove last placed piece
                board.placedPieces.remove(pieceToPlace)
            }

            c = 0
        }

        // Return piece to board
        board.remainingPieces.addFirst(pieceType)
        lastPlacedPieces[pieceType] = null
    }
}
