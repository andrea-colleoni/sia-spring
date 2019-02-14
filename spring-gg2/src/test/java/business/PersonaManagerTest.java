package business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import model.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonaManagerTest {
	
	@Autowired
	private PersonaManager pm;
	
	@Autowired
	@Qualifier("db1")
	private EntityManager em1;
	
	@Autowired
	@Qualifier("db2")
	private EntityManager em2;

	@Test
	public void test_01_ElencoPersoneDb1() {
		List<Persona> elenco = pm.elencoPersoneDb1();
		assertNotNull("elenco persone nullo!", elenco);
	}

	@Test
	public void test_02_CopiaPersone() {
		int numPersone1 = em1.createQuery("select count(p) from Persona p", Long.class).getFirstResult();
		int numPersoneInizio2 = em2.createQuery("select count(p) from Persona p", Long.class).getFirstResult();
		pm.copiaPersone();
		int numPersoneFine2 = em2.createQuery("select count(p) from Persona p", Long.class).getFirstResult();
		assertEquals("numero di persone errato", numPersoneFine2, numPersoneInizio2 + numPersone1);
	}

}
