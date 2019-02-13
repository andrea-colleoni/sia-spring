package springcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="v2")
public class ClasseA implements InterfacciaA {
	
	
	private InterfacciaC c;
	
	@Autowired
	public ClasseA(InterfacciaC c) {
		this.c = c;
	}
	
	public void metodoA() {
		c.metodoC();
	}
	
	/*
	public InterfacciaC getC() {
		return c;
	}

	public void setC(InterfacciaC c) {
		this.c = c;
	}
	*/

}
