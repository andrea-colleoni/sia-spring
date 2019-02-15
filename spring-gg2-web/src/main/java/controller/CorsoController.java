package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Corso;

@Controller
public class CorsoController extends AbstractRestController<Corso, String> {
	
	private static final String RESOURCES = "/corsi";
	private static final String PATH_KEY = "codCorso";

	@Override
	@RequestMapping(value = RESOURCES, method = RequestMethod.GET)
	public @ResponseBody List<Corso> all(@RequestParam(name = "term", required = false) String searchTerm) {
		return super.all(searchTerm);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.GET)
	public @ResponseBody Corso byKey(@PathVariable(PATH_KEY) String key) {
		return super.byKey(key);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.PUT)
	public @ResponseBody Boolean insertOrUpdate(@PathVariable("codCorso") String key, @RequestBody Corso t) {
		return super.insertOrUpdate(key, t);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.POST)
	public @ResponseBody Boolean insert(@PathVariable(PATH_KEY) String key, @RequestBody Corso t) {
		return super.insert(key, t);
	}

	@Override
	@RequestMapping(value = RESOURCES + "/{" + PATH_KEY + "}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean delete(@PathVariable(PATH_KEY) String key) {
		return super.delete(key);
	}

}
