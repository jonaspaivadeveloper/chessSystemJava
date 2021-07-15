package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	//o programa pede um consultor(importar),mas usaremos um construtor.
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	//Nesse caso queremos s� que a cor seja acessada e n�o modificada.
	public Color getColor() {
		return color;
	}
	
	//Essa opera��o ser� reaproveitada!
	//e tamb�m para detectar uma pe�a advers�ria
	protected boolean isThereOpponentPiece(Position position) {//o uso do protected � porque esse m�todo � usada nessa classe e sues subclasses!
		ChessPiece p = (ChessPiece)getBoard().piece(position);//criar uma vari�vel p
		return p != null && p.getColor() != color;
	}
}
