package beanscopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	
	@Bean
	@Scope("prototype")
	public Classe1 classe1() {
		Classe1 c = new Classe1();
		c.prop = "default";
		return c;
	}
	
	@Bean
	@Scope("singleton") // il default
	public Classe2 classe2() {
		return new Classe2();
	}

}
