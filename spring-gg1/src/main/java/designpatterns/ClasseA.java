package designpatterns;

public class ClasseA {
	
	public ClasseC c2;

	public static void main(String[] args) {
		
		ClasseB b = new ClasseB();
		b.metodo();
		
		ClasseC c = new ClasseEstensione2C();
		c.metodoAstratto();
		
		ClasseC c1 = FabbricaAstrattaDiC.ottieniFactory().fabbricaC();
		c1.metodoAstratto();
		
	}
	
	public void metodoA() {
		c2.metodoAstratto();
	}

}
