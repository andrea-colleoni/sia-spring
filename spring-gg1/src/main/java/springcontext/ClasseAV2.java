package springcontext;

import org.springframework.stereotype.Component;

@Component(value="v1")
public class ClasseAV2 implements InterfacciaA {

	public void metodoA() {
		
		System.out.println("questa � la nuova versione del programma che non ha pi� bisognidi C");

	}

}
