package business;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Indirizzo;

@Service
public class IndirizzoService extends AbstractService<Indirizzo, Integer> {

	@Override
	public List<Indirizzo> search(String serchTerm) {
		return null;
	}

}
