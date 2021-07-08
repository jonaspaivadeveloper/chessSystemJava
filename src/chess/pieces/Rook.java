package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

//Peça Torre
public class Rook extends ChessPiece {
	
	//Construtor automatizado pelo java
	public Rook(Board board, Color color) {
		super(board, color);
		
	}
	
	//Fazer toString dessa classe
	 @Override
	 public String toString() {
		 //Converter uma torre para uma string!!!!
		 return "R";
	 }
	
	

}
