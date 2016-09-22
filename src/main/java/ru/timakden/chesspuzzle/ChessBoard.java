package ru.timakden.chesspuzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Шахматная доска.
 */
class ChessBoard {
	/**
	 * Число строк (высота доски).
	 */
	private int rows;

	/**
	 * Число столбцов (ширина доски).
	 */
	private int columns;

	/**
	 * Шахматные фигуры, расположенные на доске.
	 */
	private List<ChessPiece> placedChessPieces;

	/**
	 * Шахматные фигуры, которые осталось разместить на доске.
	 */
	private List<String> remainingChessPieces;

	ChessBoard(int rows, int columns, List<String> remainingChessPieces) {
		this.columns = columns;
		this.rows = rows;
		this.placedChessPieces = new ArrayList<>(remainingChessPieces.size());
		this.remainingChessPieces = remainingChessPieces;
	}

	int getColumns() {
		return columns;
	}

	int getRows() {
		return rows;
	}

	List<ChessPiece> getPlacedChessPieces() {
		return placedChessPieces;
	}

	List<String> getRemainingChessPieces() {
		return remainingChessPieces;
	}

	/**
	 * Добавление шахматной фигуры на доску.
	 */
	void addChessPiece(ChessPiece chessPiece) {
		placedChessPieces.add(0, chessPiece);
	}

	/**
	 * Удаление шахматной фигуры с доски.
	 */
	void removePiece(ChessPiece chessPieceToRemove) {
		placedChessPieces.remove(chessPieceToRemove);
	}

	/**
	 * Определение того, занята ли клетка с координатами {@code (row, column)} какой-нибудь шахматной фигурой.
	 */
	boolean isCellFree(int row, int column) {
		for (ChessPiece chessPiece : placedChessPieces) {
			if (chessPiece.getRow() == row && chessPiece.getColumn() == column) {
				return false;
			}
		}
		return true;
	}
}
