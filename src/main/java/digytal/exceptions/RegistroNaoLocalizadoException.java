package digytal.exceptions;

public class RegistroNaoLocalizadoException extends BusinessException {
	public RegistroNaoLocalizadoException(String entidade, Object id) {
		super("%s não localizado pelo Id %s ", entidade, id.toString());
	}
}
