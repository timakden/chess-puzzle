package ru.timakden.chesspuzzle

/**
 * Класс описывает решение шахматной задачи.
 */
class ChessPuzzle(rows: Int, columns: Int, kings: Int, queens: Int, rooks: Int, bishops: Int, knights: Int) {
    /**
     * Фабрика для создания шахматных фигур.
     */
    private val pieceFactory = ChessPieceFactory()

    /**
     * Количество уникальных решений задачи с указанными параметрами.
     */
    var numberOfUniqueSolutions = 0
        private set

    /**
     * Шахматная доска.
     */
    private val board: ChessBoard

    /**
     * Ассоциативный массив для хранения последних размещённых шахматных фигур каждого типа.
     */
    private val lastPlacedPieces = mutableMapOf<String, ChessPiece?>()

    init {
        val remainingChessPieces = mutableListOf<String>()

        (0 until kings).forEach { remainingChessPieces.add("K") }
        (0 until queens).forEach { remainingChessPieces.add("Q") }
        (0 until rooks).forEach { remainingChessPieces.add("R") }
        (0 until bishops).forEach { remainingChessPieces.add("B") }
        (0 until knights).forEach { remainingChessPieces.add("N") }

        board = ChessBoard(rows, columns, remainingChessPieces)
    }

    fun solve() {
        // Берём первую доступную фигуру
        val pieceType = board.remainingPieces.removeAt(0)

        // Получаем последнюю поставленную фигуру такого типа
        val lastPlacedPiece = lastPlacedPieces[pieceType]

        var r = 0
        var c = 0

        lastPlacedPiece?.let {
            // Пропускаем повторяющиеся решения
            r = lastPlacedPiece.row
            c = lastPlacedPiece.column + 1
        }

        for (row in r until board.rows) {
            for (column in c until board.columns) {
                // Если клетка занята, то пропускаем итерацию
                if (!board.isCellFree(row, column)) {
                    continue
                }

                val pieceToPlace = pieceFactory.getPiece(pieceType, row, column)

                // Если фигуру нельзя безопасно разместить на доске, то пропускаем итерацию
                if (!pieceToPlace.isSafe(board)) {
                    continue
                }

                // Добавляем фигуру на доску
                board.placedPieces.add(0, pieceToPlace)
                lastPlacedPieces[pieceToPlace.toString()] = pieceToPlace

                if (board.remainingPieces.isEmpty()) {
                    // Если фигур больше не осталось, то решение найдено
                    numberOfUniqueSolutions++
                } else {
                    // Продолжение поиска решения
                    solve()
                }

                // Убираем последнюю фигуру
                board.placedPieces.remove(pieceToPlace)
            }

            c = 0
        }

        // Возвращаем фигуру
        board.remainingPieces.add(0, pieceType)
        lastPlacedPieces[pieceType] = null
    }
}
