package digytal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.exceptions.RegistroNaoLocalizadoException;
import digytal.model.Aluno;
import digytal.model.Cadastro;
import digytal.model.Curso;
import digytal.repository.AlunoDao;
import digytal.service.CadastroService;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
//	@Autowired
//	private CadastroService service;

	@Autowired
	private AlunoDao repository;
	
	@Autowired
	private CadastroService service;
	
	
	@PostMapping("/{id}")
	public ResponseEntity adicionar (@PathVariable("id")Integer id, @RequestBody Aluno aluno) {
		try {
			service.buscar(id);
			repository.save(aluno); //retornando null id_cadastro
			return new ResponseEntity(aluno, HttpStatus.OK);
		}catch (RegistroNaoLocalizadoException e) {
			return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body(e.getMessage());
		}
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> buscar(@PathVariable("id") Integer id){
		Optional<Aluno> opt = repository.findById(id);
		if(opt.isPresent())
			return new ResponseEntity<Aluno>(opt.get(), HttpStatus.OK);
		else
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}




