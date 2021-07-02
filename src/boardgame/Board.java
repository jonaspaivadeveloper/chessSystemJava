package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//construtores de rows e columns
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];//Sendo instanciada.
	}
	
	
	//Gettes e setters dos rows e columns.
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	//Método para retornar para dá peça da coluna!
	
	public Piece piece(int rows, int columns) {
		return pieces[rows][columns];
	}
	
	//fazer a sobrecarga do método acima!
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	

}
