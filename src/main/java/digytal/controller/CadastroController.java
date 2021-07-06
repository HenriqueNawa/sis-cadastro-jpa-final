package digytal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.exceptions.UsuarioCadastrado;
import digytal.exceptions.RegistroNaoLocalizadoException;
import digytal.model.Cadastro;
import digytal.model.Curso;
import digytal.service.CadastroService;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
	@Autowired
	private CadastroService service;
	
//	@PostMapping()
//	public void incluir(@RequestBody Cadastro cadastro){
//		service.incluir(cadastro);
//	}
	
	@PostMapping()
	public ResponseEntity incluir (@RequestBody Cadastro cadastro) {
		try {

			service.buscarCpf(cadastro.getCpf()); //Verifica se o usuário já existe pelo cpf

			service.incluir(cadastro);
			return new ResponseEntity(cadastro, HttpStatus.OK);
		} catch (UsuarioCadastrado e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity find(@PathVariable("id") Integer id){
		try {
			Cadastro cadastro = service.buscar(id);
			return new ResponseEntity(cadastro, HttpStatus.OK); //ResponseEntity representa a resposta HTTP: Body, Headers e Status Code
		}catch (RegistroNaoLocalizadoException e) {
			return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body(e.getMessage());
		}
	}
	@GetMapping(value = "handler/{id}")
	public Cadastro handlerFind(@PathVariable("id") Integer id){
		Cadastro cadastro = service.buscar(id);
		return cadastro;
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		try {
			Cadastro cadastro = service.buscar(id);
			service.excluir(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (RegistroNaoLocalizadoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
//	@GetMapping(value="/")
//	public Iterable<Cadastro> listar(){
//		return service.findAll();
//	}
	
}
