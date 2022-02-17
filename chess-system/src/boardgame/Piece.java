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
public class Piece {
	
	protected Position position;
	
	@NonNull
	@Getter(AccessLevel.PROTECTED)
	private Board board;
}
