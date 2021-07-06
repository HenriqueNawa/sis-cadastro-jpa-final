package digytal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import digytal.model.Curso;

public interface CursoRepository  extends CrudRepository<Curso, Integer> {
	List<Curso> findByNomeContaining(String nome);
	
	List<Curso> findByNome(String nome);
	
//	@Query("from tab_curso where nome = :nome and nivel = :nivel")
//    public Curso findByNomeAndNivel(@Param("nome")String nome,
//    @Param("nivel") Nivel nivel);

}
