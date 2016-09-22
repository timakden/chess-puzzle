package ru.timakden.chesspuzzle;

/**
 * Ферзь, перемещается на любое число свободных полей в любом направлении.
 */
class Queen extends ChessPiece {
	Queen(int row, int column) {
		super(row, column);
	}

	@Override
	public String toString() {
		return "Q";
	}

	public boolean canAttackAnotherChessPiece(ChessPiece anotherChessPiece) {
		int row = getRow();
		int column = getColumn();
		int anotherRow = anotherChessPiece.getRow();
		int anotherColumn = anotherChessPiece.getColumn();

		return (Math.abs(row - anotherRow) == Math.abs(column - anotherColumn)) || (row == anotherRow) || (column == anotherColumn);
	}
}
