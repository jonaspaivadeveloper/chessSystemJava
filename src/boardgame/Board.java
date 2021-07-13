package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//construtores de rows e columns
	public Board(int rows, int columns) {
		//programação defensiva! aqui usamos o if pois não existe posição negativa no tabuleiro!
		if(rows < 1 || columns < 1) {
			//enviar uma messagem de error ao usuário
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];//Sendo instanciada.
	}
	
	
	//Gettes e setters dos rows e columns.
	public int getRows() {
		return rows;
	}

	//retirar o construtor setRows pois não pode alterar
	
	/*public void setRows(int rows) {
		this.rows = rows;
	}*/

	public int getColumns() {
		return columns;
	}

	/*public void setColumns(int columns) {
		this.columns = columns;
	}*/
	
	//Método para retornar para dá peça da coluna!
	
	public Piece piece(int row, int column) {
		//Programação Defensiva!
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board!!");
		}
		return pieces[row][column];
	}
	
	//fazer a sobrecarga do método acima!
	
	public Piece piece(Position position) {
		//Programação Defensiva!
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Criar um método placepiece 
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {//o teste do thereIsAPiece está abaixo!!
			throw new BoardException("There is already a piece on position!!");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Método para mover as peças!
	public Piece removePiece(Position position) {//"Retonando Piece e sse metodo se chama removePiece com argumento postion"
		if(!positionExists(position)) {
			throw new BoardException("Position not on thre board!");
		}
		if (piece(position) == null) {
			return null;
		}
		
		//retirar a peça do tabuleiro
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
		//Assim uma peça escolhida não pode ser escolhida novamente!
	}
	
	
	
	//uma funçao auxiliar da função abaixo
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//criar uma função para avalivar se existe ou não a posição
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//método thereIsAPiece
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board!!");
		}
		return piece(position) != null;//piece foi recebido no método Piece piece onde localiza as peças!
	}
	

}
