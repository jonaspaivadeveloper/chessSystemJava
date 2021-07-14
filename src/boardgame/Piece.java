package boardgame; 

public abstract class Piece {
	
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
	
	//Definir as opera��es possiveis! com m�tod astract
	public abstract boolean [][] possibleMove();
	
	//Se � poss�vel mover a pe�a
	public boolean possibleMove(Position position) {
		return possibleMove()[position.getRow()][position.getColumn()];
	//aqui observamos que existe um m�todo abstract e dentro h� um metdo concreto!	
	}
	
	//M�todo para detectificar se a pe�a pode se mover
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMove();//Uma vari�vel auxiliar chamada mat!
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
