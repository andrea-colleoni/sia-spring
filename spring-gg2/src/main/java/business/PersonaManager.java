package business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.Persona;

@Service
public class PersonaManager {

	public String pubblica;
	String membroDefault;
	private String privato;

	@Autowired
	@Qualifier("db1")
	private EntityManager em1;
	
	@Autowired
	@Qualifier("db2")
	private EntityManager em2;

	public List<Persona> elencoPersoneDb1() {
		return em1.createQuery("select p from Persona p", Persona.class).getResultList();
	}
	
	public void copiaPersone() {
		List<Persona> origine = elencoPersoneDb1();
		em2.getTransaction().begin();
		origine.stream().forEach(p -> {
			em1.detach(p);
			em2.persist(p);
		});
		em2.getTransaction().commit();
	}

}
