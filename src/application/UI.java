package application;

import chess.ChessPiece;
//Aqui nessa classe construimos o design do tabuleiro
public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		//formar as linhas e colunas
		for (int i = 0; i < pieces.length; i++) {
			System.out.print(( 8 - i) + " ");
			for ( int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);;//vai chamar a peça
			}
			System.out.println();
		}
		System.out.println(" a b c d e f g h");
	}
	
	//imprimir uma peça
	private static void printPiece(ChessPiece piece) { //printPiece recebendo ChessPiece
		if (piece == null) {
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
