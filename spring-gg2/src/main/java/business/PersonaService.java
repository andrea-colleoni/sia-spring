package business;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Persona;

@Service
public class PersonaService extends AbstractService<Persona, String> {

	public List<Persona> search(String serchTerm) {
		return em.createQuery("select p from Persona p where lower(p.nome) LIKE lower(:term) OR lower(p.cognome) LIKE lower(:term)", Persona.class)
				.setParameter("term", "%" + serchTerm + "%")
				.getResultList();
	}

}
