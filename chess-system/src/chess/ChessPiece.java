package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import lombok.Getter;
import lombok.NonNull;

public abstract class ChessPiece extends Piece{
	

	@Getter
	private Color color;
	@Getter
	private int moveCount;

	public ChessPiece(@NonNull Board board, Color color) {
		super(board);
		this.color = color;
	}

	public ChessPosition getChessPosition()
	{
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position)
	{
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		return p != null && p.getColor() != color;
	}
		
	public void increaseMoveCount()
	{
		this.moveCount++;
	}
	
	public void decreaseMoveCount()
	{
		this.moveCount--;
	}
	
}
