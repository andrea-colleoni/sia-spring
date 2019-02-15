package controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.AbstractService;

public class AbstractRestController<T, PK extends Serializable> {
	
	@Autowired
	private AbstractService<T, PK> ps;

	public List<T> all(String searchTerm) {
		if (searchTerm == null) {
			return ps.all();
		} else {
			return ps.search(searchTerm);
		}
	}

	public T byKey(PK key) {
		return ps.byKey(key);
	}

	public Boolean insertOrUpdate(PK key, T t) {
		try {
			T db = ps.byKey(key);
			if (db != null && t.hashCode() != key.hashCode()) { 
				ps.delete(db, key);
			}
			ps.save(t, key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean insert(PK key, T t) {
		try {
			T db = ps.byKey(key);
			if (db != null) {
				return false;
			}
			ps.save(t, key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean delete(PK key) {
		try {
			T db = ps.byKey(key);
			if (db != null) {
				ps.delete(db, key);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
