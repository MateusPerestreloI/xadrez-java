package chess;

import boardgame.Board;
import boardgame.Piece;
import lombok.NonNull;

public class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(@NonNull Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
