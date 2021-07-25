package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPiece> captured =  new ArrayList<>();//Lista de chesspiece chamada captured e iniciada como new ...
		
		
		
		//Vamos fazer uma função para imprimir as peças
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				//UI.printBoard(chessMatch.getPieces()); //onde printBoard é um método//MUDAMOS
				UI.printMatch(chessMatch, captured);// depois criada a lista chesspiece colocamos aqui o captured!
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
				
				//inserir o comando das peças capturadas
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine();
					chessMatch.replacePromotedPiece(type);
				}
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
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}//fim do Program