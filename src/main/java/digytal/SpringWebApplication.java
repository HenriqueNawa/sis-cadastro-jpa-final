package digytal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import digytal.model.Curso;
import digytal.model.enums.Nivel;
import digytal.repository.CursoRepository;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
	@Bean
    public CommandLineRunner run(CursoRepository repository) throws Exception {
        return args -> {
        	Curso curso = new Curso();
        	curso.setCargaHoraria(120);
        	curso.setNivel(Nivel.AV);
        	curso.setNome("JAVA COM ENFANSE EM SPRINGBOOT");
        	//repository.save(curso);
        	ObjectMapper mapper = new ObjectMapper();
        	String json = mapper.writeValueAsString(curso);
        	//System.out.println(json);
        };
    }
	
}
