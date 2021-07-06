package digytal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import digytal.model.Aluno;

public interface AlunoDao extends CrudRepository<Aluno, Integer> {
	
}
