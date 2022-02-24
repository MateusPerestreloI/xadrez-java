package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
import lombok.NonNull;

public class Bishop extends ChessPiece{
	
	public Bishop(@NonNull Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves()
	{
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		
		//Diagonal Superior Esquerda
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues((p.getRow() - 1), p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Diagonal Superior Direita
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues((p.getRow() - 1), p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Diagonal Inferior Esquerda
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues((p.getRow() + 1), p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Diagonal Inferior Direita
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
		{
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues((p.getRow() + 1), p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		return mat;
	}
}
