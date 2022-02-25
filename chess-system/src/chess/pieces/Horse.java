package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
import lombok.NonNull;

public class Horse extends ChessPiece{
	
	public Horse(@NonNull Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "H";
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
		
		//Cima Esquerda
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Cima Direita
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Baixo Esquerda
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Baixo Direita
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Esquerda Cima
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Esquerda Baixo
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Direita Cima
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		//Direita Baixo
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if(getBoard().positionExists(p) && canMove(p))
			mat[p.getRow()][p.getColumn()] = true;
		
		return mat;
	}
}