package esercizio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	
	@Bean(name="auto")
	@Scope("prototype")
	public Veicolo auto() {
		Automobile au = new Automobile();
		au.setVelocita(120);
		return au;
	}
	
	@Bean(name="autocarro")
	@Scope("prototype")
	public Veicolo autocarro() {
		Autcarro au = new Autcarro();
		au.setVelocita(80);
		return au;
	}
	
	@Bean(name="bici")
	@Scope("prototype")
	public Veicolo bici() {
		Bicicletta b = new Bicicletta();
		b.setVelocita(12);
		return b;
	}
	
	@Bean(name="diesel")
	public Motore diesel() {
		return new Diesel();
	}
	
	@Bean(name="benzina")
	public Motore benzina() {
		return new Benzina();
	}

}
