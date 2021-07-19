package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override 
	public String toString() {
		return "K";
	}
	
	//Vamos elaborar um m�todo auxiliar para ajudar as possiveis posi��es
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);//Pegar a pe�a da posi��o
		//verificar se posi��o n�o � nula e n�o � pe�a advers�ria
		return p == null || p.getColor() != getColor();	
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//poss�veis movimentos do rei 
		Position p = new Position(0, 0);
		
		//above
		p.setValues(position.getRow() - 1, position.getColumn());//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//above
		p.setValues(position.getRow() + 1, position.getColumn());//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn() - 1);//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn() + 1);//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//nw
		p.setValues(position.getRow() - 1, position.getColumn() - 1);//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//ne
		p.setValues(position.getRow() - 1, position.getColumn() + 1);//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//sw
		p.setValues(position.getRow() + 1, position.getColumn() - 1);//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		//se
		p.setValues(position.getRow() + 1, position.getColumn() + 1);//defeinir a posi��o pelo setValues
		//testar
		if(getBoard().positionExists(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;		
		}
		
		
		
		return mat;
	}

}
