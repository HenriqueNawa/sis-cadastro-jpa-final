package digytal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import digytal.model.enums.Nivel;

@Entity
@Table(name = "tab_curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	private Integer cargaHoraria;
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
//	@ManyToOne(mapped by=)
//	@JoinColumn(name="FK_curso_aluno")
//	private Curso curso;
//	
//	
//	public Curso getCurso() {
//		return curso;
//	}
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public Integer getId() {
		return id;
	}
	
	
}
