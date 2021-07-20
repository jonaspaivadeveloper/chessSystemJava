package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

//Peça Bispo
public class Bishop extends ChessPiece {
	
	//Construtor automatizado pelo java
	public Bishop(Board board, Color color) {
		super(board, color);
		
	}
	
	//Fazer toString dessa classe
	 @Override
	 public String toString() {
		 //Converter uma bispo para uma string!!!!
		 return "B";
	 }
	 
	 @Override
		public boolean[][] possibleMoves() {
			boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
			
			//Orientações para a torre
			Position p = new Position(0, 0);
			
			//nw
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espaça vazio
				p.setValues(p.getRow() - 1, p.getColumn() - 1);
			}
			//se tiver peça adversária
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
				
			//ne
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espaça vazio
				p.setValues(p.getRow() - 1, p.getColumn() + 1);
			}
			//se tiver peça adversária
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//se
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espaça vazio
				p.setValues(p.getRow() + 1, p.getColumn() + 1);
			}
			//se tiver peça adversária
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//sw
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;//preenchendo o espaça vazio
				p.setValues(p.getRow() + 1,p.getColumn() - 1);
			}
			//se tiver peça adversária
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			return mat;
	 }
	
}
