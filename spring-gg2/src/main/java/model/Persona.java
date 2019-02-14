package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
//@Table(name = "persone")
@NamedQueries(value = { 
		@NamedQuery(name = "persona.all", query = "select p from Persona p"),
		@NamedQuery(name = "persona.searchByName", query = "select p from Persona p where p.nome = :name ")
})
public class Persona {

	@Id
	//@Column(name = "codfisc")
	private String codiceFiscale;
	@Column(nullable = false)
	@Basic(fetch=FetchType.LAZY)
	private String nome;
	// @Lob @Basic(fetch=FetchType.EAGER)
	private String cognome;
	
	@OneToMany(mappedBy="persona",cascade= {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private List<Indirizzo> indirizzi;
	
	@ManyToMany(mappedBy="iscritti", cascade= {CascadeType.ALL})
	private List<Corso> iscrizioni;
	
	/**
	 * Questo metodo aggiunge anche ....
	 * @param c
	 */
	public void addIscrizione(Corso c) {
		if (this.iscrizioni == null)
			this.iscrizioni = new ArrayList<Corso>();
		this.iscrizioni.add(c);
		c.addIscritto(this);
	}
	
	public void addIndirizzo(Indirizzo i) {
		if (this.indirizzi == null)
			this.indirizzi = new ArrayList<Indirizzo>();
		indirizzi.add(i);
		i.setPersona(this);
	}
	
	public void removeIndirizzo(Indirizzo i) {
		if(this.indirizzi != null && this.indirizzi.contains(i))
			indirizzi.remove(i);
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Indirizzo> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(List<Indirizzo> indirizzi) {
		this.indirizzi = indirizzi;
	}

}
