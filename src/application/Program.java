package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Board board = new Board(8, 8); só para teste!!
		
		//imprimir o tabuleiro
		ChessMatch chessMatch = new ChessMatch();
		
		//Vamos fazer uma função para imprimir as peças
		while(true) {
			UI.printBoard(chessMatch.getPieces()); //onde printBoard é um método
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
		

	}

}//fim do Program
