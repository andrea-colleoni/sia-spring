package designpatterns;

public abstract class FabbricaAstrattaDiC {
	
	public abstract ClasseC fabbricaC();
	
	public static FabbricaAstrattaDiC ottieniFactory() {
		return new FabbricaConcretaDiC();
	}

}
