package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	//construtor do board!
	public Piece(Board board) {
		this.board = board;
		position = null; //Uma pe�a rec�m criada! 
	}
	
	//Criada do get e n�o o set, pois � permetido a sua altera��o.
	protected Board getBoard() {
		return board;
	}

}
