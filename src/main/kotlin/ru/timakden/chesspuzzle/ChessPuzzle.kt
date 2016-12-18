package ru.timakden.chesspuzzle

/**
 * Класс описывает решение шахматной задачи.
 */
class ChessPuzzle(rows: Int, columns: Int, kings: Int, queens: Int, rooks: Int, bishops: Int, knights: Int) {
    /**
     * Фабрика для создания шахматных фигур.
     */
    private val chessPieceFactory = ChessPieceFactory()

    /**
     * Количество уникальных решений задачи с указанными параметрами.
     */
    var numberOfUniqueSolutions = 0
        private set

    /**
     * Шахматная доска.
     */
    private val chessBoard: ChessBoard

    /**
     * Ассоциативный массив для хранения последних размещённых шахматных фигур каждого типа.
     */
    private val lastPlacedChessPieces = mutableMapOf<String, ChessPiece?>()

    init {
        val remainingChessPieces = mutableListOf<String>()

        (0 until kings).forEach { i -> remainingChessPieces.add("K") }
        (0 until queens).forEach { i -> remainingChessPieces.add("Q") }
        (0 until rooks).forEach { i -> remainingChessPieces.add("R") }
        (0 until bishops).forEach { i -> remainingChessPieces.add("B") }
        (0 until knights).forEach { i -> remainingChessPieces.add("N") }

        chessBoard = ChessBoard(rows, columns, remainingChessPieces)
    }

    fun solve() {
        // Берём первую доступную фигуру
        val chessPieceType = chessBoard.remainingChessPieces.removeAt(0)

        // Получаем последнюю поставленную фигуру такого типа
        val lastPlacedChessPiece = lastPlacedChessPieces[chessPieceType]

        var r = 0
        var c = 0

        if (lastPlacedChessPiece != null) {
            // Пропускаем повторяющиеся решения
            r = lastPlacedChessPiece.row
            c = lastPlacedChessPiece.column + 1
        }

        for (row in r until chessBoard.rows) {
            for (column in c until chessBoard.columns) {
                // Если клетка занята, то пропускаем итерацию
                if (!chessBoard.isCellFree(row, column)) {
                    continue
                }

                val chessPieceToPlace = chessPieceFactory.getChessPiece(chessPieceType, row, column)

                // Если фигуру нельзя безопасно разместить на доске, то пропускаем итерацию
                if (!chessPieceToPlace!!.isSafe(chessBoard)) {
                    continue
                }

                // Добавляем фигуру на доску
                chessBoard.placedChessPieces.add(0, chessPieceToPlace)
                lastPlacedChessPieces.put(chessPieceToPlace.toString(), chessPieceToPlace)

                if (chessBoard.remainingChessPieces.isEmpty()) {
                    // Если фигур больше не осталось, то решение найдено
                    numberOfUniqueSolutions++
                } else {
                    // Продолжение поиска решения
                    solve()
                }

                // Убираем последнюю фигуру
                chessBoard.placedChessPieces.remove(chessPieceToPlace)
            }

            c = 0
        }

        // Возвращаем фигуру
        chessBoard.remainingChessPieces.add(0, chessPieceType)
        lastPlacedChessPieces.put(chessPieceType, null)
    }
}
