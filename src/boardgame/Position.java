package boardgame;

public class Position {
	
	private int row;
	private int column;
	
	//construtores 
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	//Getters and setters
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	//método para orientar a posição e atualizar
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
		
	}
	
	@Override
	public String toString() {
		return row + ", " + column;
	}

}//fim da classe Position
