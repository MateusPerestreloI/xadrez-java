package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
import lombok.NonNull;

public class Pawn extends ChessPiece{
	
	public Pawn(@NonNull Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean[][] possibleMoves()
	{
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);

		//Acima Pe�o Branco
		if(getColor() == Color.WHITE)
		{
			//Andar 1 Casa
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			//Andar 2 casas
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0)
				mat[p.getRow()][p.getColumn()] = true;
			
			//Captura de pe�a na Diagonal esquerda
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			//Captura de pe�a na Diagonal direita
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
		}
		//Acima Pe�o Preta
		else
		{
			//Andar 1 Casa
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;

			//Andar 2 casas
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) 
			{
				mat[p.getRow()][p.getColumn()] = true;
			}
		
			//Captura de pe�a na Diagonal esquerda
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
				
			//Captura de pe�a na Diagonal direita
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
