package digytal.exceptions;

public class CursoDuplicado extends BusinessException{

	public CursoDuplicado(String curso) {
		super("%s já foi cadastrado", curso);
		// TODO Auto-generated constructor stub
	}

}
