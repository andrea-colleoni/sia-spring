package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Indirizzo;

@Controller
public class IndirizzoController extends AbstractRestController<Indirizzo, Integer> {
	
	private static final String RESOURCES = "/indirizzi";
	private static final String PATH_KEY = "codIndirizzo";

	@Override
	@RequestMapping(value = RESOURCES, method = RequestMethod.GET)
	public @ResponseBody List<Indirizzo> all(@RequestParam(name = "term", required = false) String searchTerm) {
		return super.all(searchTerm);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.GET)
	public @ResponseBody Indirizzo byKey(@PathVariable(PATH_KEY) Integer key) {
		return super.byKey(key);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.PUT)
	public @ResponseBody Boolean insertOrUpdate(@PathVariable(PATH_KEY) Integer key, @RequestBody Indirizzo t) {
		return super.insertOrUpdate(key, t);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.POST)
	public @ResponseBody Boolean insert(@PathVariable(PATH_KEY) Integer key, @RequestBody Indirizzo t) {
		return super.insert(key, t);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean delete(@PathVariable(PATH_KEY) Integer key) {
		return super.delete(key);
	}



}
