package designpatterns;

public class FabbricaConcretaDiC extends FabbricaAstrattaDiC {

	@Override
	public ClasseC fabbricaC() {
		return new ClasseEstensione1C();
	}

}
