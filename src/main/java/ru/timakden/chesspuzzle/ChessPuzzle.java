package ru.timakden.chesspuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает решение шахматной задачи.
 */
class ChessPuzzle {
	/**
	 * Фабрика для создания шахматных фигур.
	 */
	private ChessPieceFactory chessPieceFactory = new ChessPieceFactory();

	/**
	 * Количество уникальных решений задачи с указанными параметрами.
	 */
	private int numberOfUniqueSolutions;

	/**
	 * Шахматная доска.
	 */
	private ChessBoard chessBoard;

	/**
	 * Ассоциативный массив для хранения последних размещённых шахматных фигур каждого типа.
	 */
	private Map<String, ChessPiece> lastPlacedChessPieces = new HashMap<>();

	ChessPuzzle(int rows, int columns, int kings, int queens, int rooks, int bishops, int knights) {
		numberOfUniqueSolutions = 0;

		List<String> remainingChessPieces = new ArrayList<>(kings + queens + bishops + rooks + knights);
		for (int i = 0; i < kings; i++) {
			remainingChessPieces.add("K");
		}
		for (int i = 0; i < queens; i++) {
			remainingChessPieces.add("Q");
		}
		for (int i = 0; i < rooks; i++) {
			remainingChessPieces.add("R");
		}
		for (int i = 0; i < bishops; i++) {
			remainingChessPieces.add("B");
		}
		for (int i = 0; i < knights; i++) {
			remainingChessPieces.add("N");
		}

		chessBoard = new ChessBoard(rows, columns, remainingChessPieces);
	}

	int getNumberOfUniqueSolutions() {
		return numberOfUniqueSolutions;
	}

	void solve() {
		List<String> remainingChessPieces = chessBoard.getRemainingChessPieces();

		// Берём первую доступную фигуру
		String chessPieceType = remainingChessPieces.remove(0);

		// Получаем последнюю поставленную фигуру такого типа
		ChessPiece lastPlacedChessPiece = lastPlacedChessPieces.get(chessPieceType);

		int r = 0;
		int c = 0;

		if (lastPlacedChessPiece != null) {
			// Пропускаем повторяющиеся решения
			r = lastPlacedChessPiece.getRow();
			c = lastPlacedChessPiece.getColumn() + 1;
		}

		for (int row = r; row < chessBoard.getRows(); row++) {
			for (int column = c; column < chessBoard.getColumns(); column++) {
				// Если клетка занята, то пропускаем итерацию
				if (!chessBoard.isCellFree(row, column)) {
					continue;
				}

				ChessPiece chessPieceToPlace = chessPieceFactory.getChessPiece(chessPieceType, row, column);

				// Если фигуру нельзя безопасно разместить на доске, то пропускаем итерацию
				if (!chessPieceToPlace.isSafe(chessBoard)) {
					continue;
				}

				// Добавляем фигуру на доску
				chessBoard.addChessPiece(chessPieceToPlace);
				lastPlacedChessPieces.put(chessPieceToPlace.toString(), chessPieceToPlace);

				if (remainingChessPieces.isEmpty()) {
					// Если фигур больше не осталось, то решение найдено
					numberOfUniqueSolutions++;
				} else {
					// Продолжение поиска решения
					solve();
				}

				// Убираем последнюю фигуру
				chessBoard.removePiece(chessPieceToPlace);
			}

			c = 0;
		}

		// Возвращаем фигуру
		remainingChessPieces.add(0, chessPieceType);
		lastPlacedChessPieces.put(chessPieceType, null);
	}
}
