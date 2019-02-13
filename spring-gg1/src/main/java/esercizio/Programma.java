package esercizio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Programma {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		Veicolo v1 = ctx.getBean("auto",Veicolo.class);
		Veicolo v2 = ctx.getBean("bici",Veicolo.class);
		Veicolo v3 = ctx.getBean("autocarro",Veicolo.class);
		
		v1.vai(3);
		v2.vai(3);
		v3.vai(3);
		
		ctx.close();
	}

}
