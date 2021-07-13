package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	//construtores de rows e columns
	public Board(int rows, int columns) {
		//programa��o defensiva! aqui usamos o if pois n�o existe posi��o negativa no tabuleiro!
		if(rows < 1 || columns < 1) {
			//enviar uma messagem de error ao usu�rio
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

	//retirar o construtor setRows pois n�o pode alterar
	
	/*public void setRows(int rows) {
		this.rows = rows;
	}*/

	public int getColumns() {
		return columns;
	}

	/*public void setColumns(int columns) {
		this.columns = columns;
	}*/
	
	//M�todo para retornar para d� pe�a da coluna!
	
	public Piece piece(int row, int column) {
		//Programa��o Defensiva!
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board!!");
		}
		return pieces[row][column];
	}
	
	//fazer a sobrecarga do m�todo acima!
	
	public Piece piece(Position position) {
		//Programa��o Defensiva!
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Criar um m�todo placepiece 
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {//o teste do thereIsAPiece est� abaixo!!
			throw new BoardException("There is already a piece on position!!");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//M�todo para mover as pe�as!
	public Piece removePiece(Position position) {//"Retonando Piece e sse metodo se chama removePiece com argumento postion"
		if(!positionExists(position)) {
			throw new BoardException("Position not on thre board!");
		}
		if (piece(position) == null) {
			return null;
		}
		
		//retirar a pe�a do tabuleiro
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
		//Assim uma pe�a escolhida n�o pode ser escolhida novamente!
	}
	
	
	
	//uma fun�ao auxiliar da fun��o abaixo
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//criar uma fun��o para avalivar se existe ou n�o a posi��o
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//m�todo thereIsAPiece
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board!!");
		}
		return piece(position) != null;//piece foi recebido no m�todo Piece piece onde localiza as pe�as!
	}
	

}
