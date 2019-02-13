package designpatterns;

public class Contesto {

	public static ClasseC getClasseC() {
		return new ClasseEstensione2C();
	}

	public static ClasseA getClasseA() {
		ClasseA a = new ClasseA();
		a.c2 = getClasseC();  // dependency injection <= wiring
		return a;
	}

}
