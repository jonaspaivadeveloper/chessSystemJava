package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		//Board board = new Board(8, 8); só para teste!!
		
		//imprimir o tabuleiro
		ChessMatch chessMatch = new ChessMatch();
		
		//Vamos fazer uma função para imprimir as peças
		UI.printBoard(chessMatch.getPieces()); //onde printBoard é um método

	}

}//fim do Program
