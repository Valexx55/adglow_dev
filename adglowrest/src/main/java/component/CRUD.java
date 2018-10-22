package component;

public interface CRUD<E> {
	
		boolean create(E entity);

		boolean delete(Object id);

		E read(Object id);
		
		boolean update (E entity);


}
