package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

//Pe�a Torre
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
	 
	 @Override
		public boolean[][] possibleMoves() {
			boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
			
			//Orienta��es para a torre
			Position p = new Position(0, 0);
			
			//above
			p.setValues(position.getRow() - 1, position.getColumn());
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espa�a vazio
				p.setRow(p.getRow() - 1);
			}
			//se tiver pe�a advers�ria
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			
			//left
			p.setValues(position.getRow(), position.getColumn() - 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espa�a vazio
				p.setColumn(p.getColumn() - 1);
			}
			//se tiver pe�a advers�ria
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//right
			p.setValues(position.getRow(), position.getColumn() + 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espa�a vazio
				p.setColumn(p.getColumn() + 1);
			}
			//se tiver pe�a advers�ria
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//down
			p.setValues(position.getRow() + 1, position.getColumn());
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espa�a vazio
				p.setRow(p.getRow() + 1);
			}
			//se tiver pe�a advers�ria
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			return mat;
	 }
	

}
