package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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
	
	public boolean canMove(Position position)
	{
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves()
	{
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//Acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Baixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Superior Esquerdo
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Superior Direito
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Inferior Esquerdo
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Inferior Direito
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		
		return mat;
	}
}
