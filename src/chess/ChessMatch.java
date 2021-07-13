package chess;

import boardgame.Board;//para importa ctrt + shift + o =D
import boardgame.Piece;
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
	
	//M�todo para orientar as pe�as depois do primeiro movimento
	public ChessPiece performChessMove(ChessPosition sourcePosition , ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);//essa � valida��o do source
		Piece capturedPiece = makeMove(source, target);//makeMove � uma opera��o
		return (ChessPiece)capturedPiece;
	}
	
	//criar uma opera��o makeMove()!
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece( p, target);
		return capturedPiece;
	}
	
	
	//implementar a validateSourcePosition!
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position!! ");
						
		}
		
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
