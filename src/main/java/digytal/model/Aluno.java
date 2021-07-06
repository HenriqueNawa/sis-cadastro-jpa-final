package digytal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import digytal.model.enums.Nivel;

@Entity
@Table(name = "tab_aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 3)
	private Nivel nivel;
	
	@OneToOne(cascade =  {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_cadastro", foreignKey = @ForeignKey(name = "fk_aluno_cadastro"))
	private Cadastro cadastro;

//	@ManyToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//	@JoinColumn(name = "aluno_curso", foreignKey = @ForeignKey(name = "fk_aluno_curso"))
//	private Curso curso;
	
	//List<Cadastro> // isso é muito pesado
	
	private String cursos;
	
	
	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

	public Integer getId() {
		return id;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

//	public Curso getCurso() {
//		return curso;
//	}
//
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
}
