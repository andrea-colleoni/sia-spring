package controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { TestConfig.class })
public class PrimoControllerTest {
	
	@Autowired
	private PrimoController primoController;

	@Test
	public void testPersoneJSON() {
		List<Persona> lista = primoController.personeJSON();
		assertNotNull("elenco persone nullo", lista);
	}

}
