package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import business.PersonaService;
import model.Persona;

@Controller
public class PersonaController {

	// costruisco un controller in stile REST
	// https://it.wikipedia.org/wiki/Representational_State_Transfer

	@Autowired
	private PersonaService ps;

	@RequestMapping(value = "/persone", method = RequestMethod.GET)
	public @ResponseBody List<Persona> all(@RequestParam(name = "term", required = false) String serachTerm) {
		if (serachTerm == null) {
			return ps.all();
		} else {
			return ps.search(serachTerm);
		}
	}

	@RequestMapping(value = "/persone/{codFisc}", method = RequestMethod.GET)
	public @ResponseBody Persona byKey(@PathVariable("codFisc") String codiceFiscale) {
		return ps.byKey(codiceFiscale);
	}

	@RequestMapping(value = "/persone/{codFisc}", method = RequestMethod.PUT)
	public @ResponseBody Boolean insertOrUpdate(@PathVariable("codFisc") String codiceFiscale, @RequestBody Persona p) {
		try {
			Persona db = ps.byKey(codiceFiscale);
			if (db != null && !p.getCodiceFiscale().equals(codiceFiscale)) { // cambia il cod fisc, quindi elimino il
																				// vecchio
				ps.delete(db, codiceFiscale);
			}
			ps.save(p, codiceFiscale);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = "/persone/{codFisc}", method = RequestMethod.POST)
	public @ResponseBody Boolean insert(@PathVariable("codFisc") String codiceFiscale, @RequestBody Persona p) {
		try {
			Persona db = ps.byKey(codiceFiscale);
			if (db != null) {
				return false;
			}
			ps.save(p, codiceFiscale);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = "/persone/{codFisc}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean delete(@PathVariable("codFisc") String codiceFiscale) {
		try {
			Persona db = ps.byKey(codiceFiscale);
			if (db != null) {
				ps.delete(db, codiceFiscale);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
