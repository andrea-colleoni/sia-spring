package esercizio;

public class Bicicletta implements Veicolo {
	
	private int velocita;

	public void vai(int ore) {
		System.out.println("Ho percorso " + ore * getVelocita()  + " km.");
	}

	public int getVelocita() {
		return this.velocita;
	}

	public void setVelocita(int kmh) {
		this.velocita = kmh;
	}

}
