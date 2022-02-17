package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;
import lombok.NonNull;

public class King extends ChessPiece{
	
	public King(@NonNull Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "K";
	}
}
