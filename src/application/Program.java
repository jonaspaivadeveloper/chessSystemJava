package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
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
			try {
				UI.clearScreen();
				//UI.printBoard(chessMatch.getPieces()); //onde printBoard é um método//MUDAMOS
				UI.printMatch(chessMatch);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				//Depois que usuário iniciou a posisão de origem da peça
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);	
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}		
	}
}//fim do Program
