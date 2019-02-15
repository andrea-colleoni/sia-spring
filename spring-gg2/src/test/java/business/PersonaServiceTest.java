package business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import model.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonaServiceTest {

	@Autowired
	private PersonaService ps;

	@Test
	public void testAll() {
		List<Persona> l = ps.all();
		assertNotNull(l);
	}

	@Test
	public void testByKey() {
		Persona p = new Persona();
		p.setCodiceFiscale("test");
		p.setNome("Test");
		ps.save(p);

		Persona db = ps.byKey("test");
		assertEquals(p, db);

		ps.delete(p);
	}

	@Test
	public void testSave() {
		try {
			Persona p = new Persona();
			p.setCodiceFiscale("test");
			p.setNome("Test");
			ps.save(p);
		} catch (Exception e) {
			fail("si è verificata un'eccezione");
		}
	}

	@Test
	public void testDelete() {
		Persona p = new Persona();
		p.setCodiceFiscale("test");
		p.setNome("Test");
		ps.save(p);
		try {
			ps.delete(p);
		} catch (Exception e) {
			fail("si è verificata un'eccezione");
		}
	}
	
	@Test
	public void testSearch() {
		List<Persona> l = ps.search("mar");
		assertTrue("valore inatteso",  (l.size() > 0));
	}

}
