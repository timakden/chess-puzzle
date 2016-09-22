package ru.timakden.chesspuzzle;

/**
 * Ладья, перемещается на любое число полей по вертикали или горизонтали.
 */
class Rook extends ChessPiece {
	Rook(int row, int column) {
		super(row, column);
	}

	@Override
	public String toString() {
		return "R";
	}

	public boolean canAttackAnotherChessPiece(ChessPiece anotherChessPiece) {
		int row = getRow();
		int column = getColumn();
		int anotherRow = anotherChessPiece.getRow();
		int anotherColumn = anotherChessPiece.getColumn();

		return (row == anotherRow) || (column == anotherColumn);
	}
}
