package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		//Board board = new Board(8, 8); s� para teste!!
		
		//imprimir o tabuleiro
		ChessMatch chessMatch = new ChessMatch();
		
		//Vamos fazer uma fun��o para imprimir as pe�as
		UI.printBoard(chessMatch.getPieces()); //onde printBoard � um m�todo

	}

}//fim do Program
