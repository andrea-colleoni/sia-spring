package esercizio.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import esercizio.Config;
import esercizio.Veicolo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class, TestConfig.class })
public class VeicoliTest {
	
	// private static AbstractApplicationContext ctx;
	
	@Autowired
	@Qualifier("auto")
	private Veicolo v1;
	
	@Autowired
	@Qualifier("bici")
	private Veicolo v2;
	
	@Autowired
	@Qualifier("autocarro")
	private Veicolo v3;
	
	@Autowired
	@Qualifier("autodacorsa")
	private Veicolo v4;
	
	/*
	@Before
	public void primaDiOgniTest() {
		
	}
	
	@BeforeClass
	public static void soloUnaVOltaPrimaDelPrimoTest() {
		ctx = new AnnotationConfigApplicationContext(Config.class);
	}
	
	@After
	public void allaFIneDiOgniTest() {
		
	}
	
	@AfterClass
	public static void soloUnaVOltaDopoLUltimoTest() {
		ctx.close();
	}
	*/
	
	@Test
	public void test1() {
		/*
		Veicolo v1 = ctx.getBean("auto",Veicolo.class);
		Veicolo v2 = ctx.getBean("bici",Veicolo.class);
		Veicolo v3 = ctx.getBean("autocarro",Veicolo.class);
		*/		
		v1.vai(3);
		v2.vai(3);
		v3.vai(3);
		v4.vai(3);
	}
	
	@Test
	public void test2() {
		v1.vai(5);
		v2.vai(5);
		v3.vai(5);
	}
	
	@Test
	public void test3() {
		v1.vai(7);
		v2.vai(7);
		v3.vai(7);
	}

}
