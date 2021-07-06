package digytal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import digytal.model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Integer> {
	
	    public List<Cadastro> findByCpf(String cpf);
	
}
