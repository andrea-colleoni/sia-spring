package springcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.ConfigurazioneComponentScan;

@Component
public class Programma {
	
	@Autowired
	//@Qualifier("v1")
	private InterfacciaA a;
	
	public static void main(String[] args) {
		// ClasseA a = new ClasseA(); // NO!

		// cerco e avvio il context
		// ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurazioneBeanUnoAdUno.class);
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurazioneComponentScan.class);
		// ApplicationContext context = new ClassPathXmlApplicationContext("contesto.xml");
		// ClasseA a = context.getBean(ClasseA.class);
		// ClasseA a = new ClasseA();
		context.getBean(Programma.class).run();
		
	}
	
	public void run() {
		a.metodoA();
	}

	public InterfacciaA getA() {
		return a;
	}

	public void setA(InterfacciaA a) {
		this.a = a;
	}

}
