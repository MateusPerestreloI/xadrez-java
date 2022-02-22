package boardgame;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@RequiredArgsConstructor
@Data
@ToString
@NoArgsConstructor
public abstract class Piece {
	
	protected Position position;
	
	@NonNull
	@Getter(AccessLevel.PROTECTED)
	private Board board;
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position)
	{
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove()
	{
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j])
					return true;
			}
		}
		return false;
	}
}
