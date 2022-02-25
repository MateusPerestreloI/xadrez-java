package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;
import lombok.NonNull;

public class Pawn extends ChessPiece{
	
	private ChessMatch chessMatch;
	
	public Pawn(@NonNull Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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

		//Acima Peão Branco
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
			
			//Captura de peça na Diagonal esquerda
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			//Captura de peça na Diagonal direita
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			//Movimento Especial: En Passant
			if(position.getRow() == 3)
			{
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
					mat[left.getRow() - 1][left.getColumn()] = true;
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
					mat[right.getRow() - 1][right.getColumn()] = true;
			}
		}
		//Acima Peão Preta
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
		
			//Captura de peça na Diagonal esquerda
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
				
			//Captura de peça na Diagonal direita
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			//Movimento Especial: En Passant
			if(position.getRow() == 4)
			{
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
					mat[left.getRow() + 1][left.getColumn()] = true;
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
					mat[right.getRow() + 1][right.getColumn()] = true;
			}
		}
		return mat;
	}
}
