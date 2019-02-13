package esercizio.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import esercizio.Automobile;
import esercizio.Veicolo;

@Configuration
public class TestConfig {
	
	@Bean(name="autodacorsa")
	@Scope("prototype")
	public Veicolo auto() {
		Automobile au = new Automobile();
		au.setVelocita(310);
		return au;
	}

}
