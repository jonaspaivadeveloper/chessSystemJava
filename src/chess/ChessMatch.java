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
	
	//Criar um m�todo para localizar as coordenadas
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//Criar um m�todo para iniciar uma partida!
	private void initialSetup() {
		/*board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); 
		board.placePiece(new King(board, Color.BLACK), new Position(2, 0)); 
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4)); 
		*/
		
		//novo jeito!
		/*placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));*/
		
		//Com as pe�as atualizadas!
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
