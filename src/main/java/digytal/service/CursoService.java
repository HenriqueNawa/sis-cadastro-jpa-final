package digytal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digytal.exceptions.CursoDuplicado;
import digytal.model.Curso;
import digytal.model.enums.Nivel;
import digytal.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	
	//add feature com nome e nivel do curso
	public void buscarCurso (String nome) throws CursoDuplicado{
		List<Curso> opt = repository.findByNome(nome);
//		List<Curso> opt = repository.findByNomeAndNivel(nome, nivel)
		if (!opt.isEmpty()) {
			throw new CursoDuplicado(nome);
			
		}
	
	}

}
