package boardgame;

import lombok.Getter;

public class Board {
	
	@Getter
	private int rows;

	@Getter
	private int columns;
	
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1)
			throw new BoardException("Erro ao criar tabuleiro: tem que ter pelo menos 1 linha e 1 coluna!");
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}
	
	public Piece piece(int row, int column)
	{
		if(!positionExists(row, column))
			throw new BoardException("Posicao nao esta dentro do tabuleiro!");
		return pieces[row][column];
	}
	
	public Piece piece(Position position)
	{
		if(!positionExists(position))
			throw new BoardException("Posicao nao esta dentro do tabuleiro! Posicao: " + position.toString());
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position)
	{
		if(thereIsAPiece(position))
			throw new BoardException("Ja tem uma peca na posicao " + position);
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position)
	{
		if(!positionExists(position))
			throw new BoardException("Posicao nao esta dentro do tabuleiro!");
		if(piece(position) == null)
			return null;
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column)
	{
		return row >=0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position)
	{
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position)
	{
		if(!positionExists(position))
			throw new BoardException("Posicao nao esta dentro do tabuleiro!");
		return piece(position) != null;
	}
	
}
