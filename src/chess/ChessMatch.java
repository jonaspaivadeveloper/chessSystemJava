package chess;

import boardgame.Board;//para importa ctrt + shift + o =D
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

//Classe � o cora��o do projeto

public class ChessMatch {
	
	private Board board;
	
	//construtor padr�o
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//o m�todo vai criar uma mariz referente a classe ChessMatch
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];//Criando uma vari�vel temporaira com matriz criada!!
		for(int i = 0; i<board.getRows(); i++) {
			for(int j = 0; j< board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat; //retorna a matriz mat
	}
	
	//Criar um m�todo para iniciar uma partida!
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); 
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4)); 
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4)); 
		
	}
}
