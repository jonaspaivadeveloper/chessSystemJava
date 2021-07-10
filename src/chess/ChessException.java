package chess;

public class ChessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//Criar o construtor que recebe a string
	public ChessException(String msg) {
		super(msg);
	}

}
