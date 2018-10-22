package component;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public abstract class GenericDAO<T extends Serializable> implements CRUD<T> {

	@PersistenceContext
	EntityManager entityManager;

	//private Class type;

	public GenericDAO() {
		
	}
	
	public abstract Class<T> getType ();

	@Override
	public boolean create(T entity) {
		
		entityManager.persist(entity);
		return false;
	}

	@Override
	public boolean delete(Object id) {
		T entity = read(id);
		entityManager.remove(entity);
		return false;
	}

	@Override
	public boolean update(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T read(Object id) {
		T entity = null;

		entity = (T) entityManager.find(getType(), id);

		return entity;
	}

}
