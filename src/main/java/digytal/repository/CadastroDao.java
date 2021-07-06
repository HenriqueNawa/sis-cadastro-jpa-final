package digytal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import digytal.model.Cadastro;

//so existe como exemplo de entity manager
@Repository
public class CadastroDao {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Cadastro cadastro) {
		em.persist(cadastro);
		//em.merge(cadastro);
		//em.remove(cadastro);
	}
	public Cadastro  buscar(Integer id) {
		return em.find(Cadastro.class, id);
	}
	public List<Cadastro> listAll(String nome){
		Query query = em.createQuery("SELECT e FROM Cadastro e WHERE e.nome = :abc");
		query.setParameter("abc", nome);
		return query.getResultList();
	}
	public List<Cadastro> listAll(){
		Query query = em.createQuery("SELECT e FROM Cadastro e"); //JPQL
		return query.getResultList();
	}
	
	public List<Cadastro> listCpf(String cpf){
		Query query = em.createQuery("SELECT e FROM Cadastro e WHERE e.cpf = :abc"); //JPQL
		query.setParameter("abc", cpf);
		return query.getResultList();
	}
	
	public Cadastro  buscarCpf(String cpf) {
		return em.find(Cadastro.class, cpf);
	}
	
}
