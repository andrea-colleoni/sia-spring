package designpatterns;

public class NuovoClientIoC {

	public static void main(String[] args) {
		
		ClasseA a = Contesto.getClasseA();
		
		a.metodoA();

	}

}
