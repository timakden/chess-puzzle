package ru.timakden.chesspuzzle;

/**
 * Король, перемещается на любое соседнее поле в любом направлении.
 */
class King extends ChessPiece {
	King(int row, int column) {
		super(row, column);
	}

	@Override
	public String toString() {
		return "K";
	}

	public boolean canAttackAnotherChessPiece(ChessPiece anotherChessPiece) {
		int row = getRow();
		int column = getColumn();
		int anotherRow = anotherChessPiece.getRow();
		int anotherColumn = anotherChessPiece.getColumn();

		return ((Math.abs(row - anotherRow) == 1) && (Math.abs(column - anotherColumn) == 1)) ||
		       ((row == anotherRow) && (Math.abs(column - anotherColumn) == 1)) ||
		       ((column == anotherColumn) && (Math.abs(row - anotherRow) == 1));
	}
}
