package boardgame; 

public abstract class Piece {
	
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
	
	//Definir as operações possiveis! com métod astract
	public abstract boolean [][] possibleMove();
	
	//Se é possível mover a peça
	public boolean possibleMove(Position position) {
		return possibleMove()[position.getRow()][position.getColumn()];
	//aqui observamos que existe um método abstract e dentro há um metdo concreto!	
	}
	
	//Método para detectificar se a peça pode se mover
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMove();//Uma variável auxiliar chamada mat!
		for(int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
