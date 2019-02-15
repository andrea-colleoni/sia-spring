package business;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractService<T, PK extends Serializable> {
	
	@Autowired
	@Qualifier("db1")
	protected EntityManager em;
	
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractService() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
             .getActualTypeArguments()[0];
    }

	public List<T> all() {
		return em.createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass).getResultList();
	}
	
	public T byKey(PK key) {
		return em.find(entityClass, key);
	}
	
	public void save(T t, PK key) {
		T db = byKey(key);
		em.getTransaction().begin();
		if (db == null) {
			em.persist(t);
		} else {
			em.merge(t);
		}
		em.getTransaction().commit();
	}
	
	public void delete(T t, PK key) {
		T db = byKey(key);
		if (db != null) {
			em.getTransaction().begin();
			em.remove(db);
			em.getTransaction().commit();
		}
	}
	
	public abstract List<T> search(String serchTerm);

}
