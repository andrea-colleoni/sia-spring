package business;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Corso;

@Service
public class CorsoService extends AbstractService<Corso, String> {

	@Override
	public List<Corso> search(String serchTerm) {
		return null;
	}

}
