package boardgame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Position {
	
	private int row;
	private int column;
	
	public void setValues(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
}
