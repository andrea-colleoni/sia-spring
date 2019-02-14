package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Corso {
	
	@Id
	private String codiceCorso;
	private String descrizione;
	
	@ManyToMany
	private List<Persona> iscritti;
	
	public void addIscritto(Persona p) {
		if (this.iscritti == null)
			this.iscritti = new ArrayList<>();
		this.iscritti.add(p);
		// p.addIscrizione(this);
	}
	
	// TODO: aggiungere anche remove

	public String getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Persona> getIscritti() {
		return iscritti;
	}

	public void setIscritti(List<Persona> iscritti) {
		this.iscritti = iscritti;
	}

}
