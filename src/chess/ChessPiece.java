package chess;

import boardgame.Board;

import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	//o programa pede um consultor(importar),mas usaremos um construtor.
	private int moveCount;//atributo é im intiero
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	//Nesse caso queremos só que a cor seja acessada e não modificada.
	public Color getColor() {
		return color;
	}
	
	//getter do moveCount
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	//Essa operação será reaproveitada!
	//e também para detectar uma peça adversária
	protected boolean isThereOpponentPiece(Position position) {//o uso do protected é porque esse método é usada nessa classe e sues subclasses!
		ChessPiece p = (ChessPiece)getBoard().piece(position);//criar uma variável p
		return p != null && p.getColor() != color;
	}
}
