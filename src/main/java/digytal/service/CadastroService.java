package digytal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digytal.exceptions.CampoObrigatorioException;
import digytal.exceptions.UsuarioCadastrado;
import digytal.exceptions.RegistroNaoLocalizadoException;
import digytal.model.Cadastro;
import digytal.repository.CadastroDao;
import digytal.repository.CadastroRepository;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repository;
	
	public void incluir(Cadastro cadastro) {
		//TRATAR CADA CENÁRIO COM AS RESPECTIVAS CONSIDERAÇÕES
	
		if(cadastro.getCpf() == null)
			throw new CampoObrigatorioException("CPF");
		
		repository.save(cadastro);
		
	}
	public Cadastro buscar(Integer id) throws RegistroNaoLocalizadoException {
		Optional<Cadastro> opt = repository.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
		 throw new RegistroNaoLocalizadoException("Cadastro", id);
	}
	
	public void buscarCpf (String cpf) throws UsuarioCadastrado{
		List<Cadastro> opt = repository.findByCpf(cpf);

		if (!opt.isEmpty()) {
			throw new UsuarioCadastrado("Usuário já cadastrado!");
			
		}
	
	}
	
	public void excluir(Integer id)  {
		
		repository.deleteById(id);
	}
	public Iterable<Cadastro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
