package chess;

import boardgame.Position;

public class ChessPosition {
	
	//Aqui é outro sistema de coordenadas
	private char column;
	private int row;
	
	//construtores com argumentos
	public ChessPosition(char column, int row) {
		//Porgramação Defensiva!
		if(column < 'a'|| column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantitating ChessPosition. Valid values areare from a1 to h8!");
		}
		this.column = column;
		this.row = row;
	}
	
	
	//Criando os getters 
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	//Aqui é a parte protegida e vai retornar uma nova position
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//inverter a situação
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row; 
	} 
	

}
