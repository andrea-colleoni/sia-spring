package beanscopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Programma {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		// prelevo i bean dal context
		Classe1 c1 = ctx.getBean(Classe1.class);
		Classe2 c2 = ctx.getBean(Classe2.class);
		
		// imposto una proprietà
		c1.prop = "test1";
		c2.prop = "test1";
		
		
		// prelevo nuovamente i bean dal context
		c1 = ctx.getBean(Classe1.class);
		c2 = ctx.getBean(Classe2.class);
		
		// controllo se il valore delle proprietà si è conservato
		System.out.println(c1.prop);
		System.out.println(c2.prop);

	}

}
