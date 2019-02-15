package business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.Persona;

@Service
public class PersonaService {
	
	@Autowired
	@Qualifier("db1")
	private EntityManager em1;
	
	public List<Persona> all() {
		return em1.createQuery("select p from Persona p", Persona.class).getResultList();
	}
	
	public Persona byKey(String codiceFiscale) {
		return em1.find(Persona.class, codiceFiscale);
	}
	
	public void save(Persona p) {
		Persona db = byKey(p.getCodiceFiscale());
		em1.getTransaction().begin();
		if (db == null) {
			em1.persist(p);
		} else {
			em1.merge(p);
		}
		em1.getTransaction().commit();
	}
	
	public void delete(Persona p) {
		Persona db = byKey(p.getCodiceFiscale());
		if (db != null) {
			em1.getTransaction().begin();
			em1.remove(db);
			em1.getTransaction().commit();
		}
	}
	
	public List<Persona> search(String serchTerm) {
		return em1.createQuery("select p from Persona p where lower(p.nome) LIKE lower(:term) OR lower(p.cognome) LIKE lower(:term)", Persona.class)
				.setParameter("term", "%" + serchTerm + "%")
				.getResultList();
	}

}
