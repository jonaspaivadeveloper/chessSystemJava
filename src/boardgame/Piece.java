package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	//construtor do board!
	public Piece(Board board) {
		this.board = board;
		position = null; //Uma peça recém criada! 
	}
	
	//Criada do get e não o set, pois é permetido a sua alteração.
	protected Board getBoard() {
		return board;
	}

}
