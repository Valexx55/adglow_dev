package component;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import entity.Usuario;

@Repository
public class UsuarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Usuario read (int id_usuario)
	{
		Usuario region = null;
		
			region = entityManager.find(Usuario.class, id_usuario);
		
		return region;
	}
	
	public void update (Usuario usuario)
	{
		
		entityManager.merge(usuario);
		
	}
	
	public void create (Usuario usuario)
	{
		entityManager.persist(usuario);
	}
	
	public void delete (Integer id_usuario)
	{
		Usuario usuario = null;
		
			usuario = read(id_usuario);
			entityManager.remove(usuario);//si intetamos borrar con null, dará una excepción de tipo IllegalArgumentException
	}	
	
	

}
