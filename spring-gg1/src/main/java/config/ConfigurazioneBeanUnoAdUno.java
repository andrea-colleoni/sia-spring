package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springcontext.ClasseA;
import springcontext.ClasseAV2;
import springcontext.Estensione2DellaClasseC;
import springcontext.InterfacciaA;
import springcontext.InterfacciaC;
import springcontext.Programma;

@Configuration
public class ConfigurazioneBeanUnoAdUno {
	
	@Bean(name= {"vecchio", "v1"})
	public InterfacciaA classeA1() {
//		ClasseA a = new ClasseA();
//		a.c = classeC(); // wiring manuale
		return new ClasseAV2();
	}
	
	@Bean(name= {"nuovo", "v2"})
	public InterfacciaA classeA2() {
		return new ClasseA(classeC());
	}
	
	@Bean
	public InterfacciaC classeC() {
		return new Estensione2DellaClasseC();
	}
	
	@Bean
	public Programma getProgramma() {
		return new Programma();
	}
	
}
