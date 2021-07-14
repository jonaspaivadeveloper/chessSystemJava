package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	//o programa pede um consultor(importar),mas usaremos um construtor.
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	//Nesse caso queremos só que a cor seja acessada e não modificada.
	public Color getColor() {
		return color;
	}
	
	
	
	

}
