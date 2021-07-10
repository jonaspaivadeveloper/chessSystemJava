package boardgame;

public class BoardException extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;
	
	//construtor que recebe a messagem
	public BoardException(String msg) {
		super(msg);//aqui o super pega a msg para enviar para construtor RuntimeException!
	}

}
