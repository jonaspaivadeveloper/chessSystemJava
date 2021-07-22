package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	//Criar uma dependência
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override 
	public String toString() {
		return "K";
	}
	
	//Vamos elaborar um método auxiliar para ajudar as possiveis posições
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);//Pegar a peça da posição
		//verificar se posição não é nula e não é peça adversária
		return p == null || p.getColor() != getColor();	
	}
	
	//Criar um método auxiliar para testar a situação do rook
	private boolean testRookCastling(Position position) {
		ChessPiece p =  (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//possíveis movimentos do rei 
		Position p = new Position(0, 0);
		
		//above
		p.setValues(position.getRow() - 1, position.getColumn());//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//above
		p.setValues(position.getRow() + 1, position.getColumn());//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn() - 1);//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn() + 1);//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//nw
		p.setValues(position.getRow() - 1, position.getColumn() - 1);//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//ne
		p.setValues(position.getRow() - 1, position.getColumn() + 1);//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//sw
		p.setValues(position.getRow() + 1, position.getColumn() - 1);//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//se
		p.setValues(position.getRow() + 1, position.getColumn() + 1);//defeinir a posição pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//Special move castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//specialmove castling kingside rook
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			//specialmove castling queenside rook
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}		
		}
		
		
		
		return mat;
	}

}
