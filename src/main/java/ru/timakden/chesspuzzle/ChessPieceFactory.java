package ru.timakden.chesspuzzle;

/**
 * Фабрика для создания шахматных фигур.
 */
class ChessPieceFactory {
    ChessPiece getChessPiece(String chessPieceType, int row, int column) {
        switch (chessPieceType) {
            case "K":
                return new King(row, column);
            case "R":
                return new Rook(row, column);
            case "N":
                return new Knight(row, column);
            case "Q":
                return new Queen(row, column);
            case "B":
                return new Bishop(row, column);
            default:
                return null;
        }
    }
}
