package esercizio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Automobile implements Veicolo {
	
	@Autowired
	@Qualifier("benzina")
	private Motore m;
	
	private int velocita;

	public void vai(int ore) {
		System.out.println("Ho percorso " + ore * getVelocita()  + " km consumando " + m.getCarburante());

	}

	public int getVelocita() {
		return this.velocita;
	}

	public void setVelocita(int kmh) {
		this.velocita = kmh;
	}

}
