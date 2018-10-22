package component;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import entity.Usuario;


@Repository
public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioDaoInterface {

	
	@Override
	public Class<Usuario> getType() {
		
		return Usuario.class;
	}
	
	@Override
	public Usuario existeUsuario(Usuario entity_usuario) 
	{
		Usuario usuario_dev = null;
		List<Usuario> lusuarios = null;
		
			Query consulta = entityManager.createQuery("FROM usuario u WHERE u.nombre = :nickName and u.pwd = :clave");
			consulta.setParameter("nickName", entity_usuario.getNombre());
			consulta.setParameter("clave", entity_usuario.getPwd());
			
			lusuarios = (List<Usuario>)consulta.getResultList();
			if ((lusuarios != null)&&(lusuarios.size()>0))
			{
				usuario_dev = (Usuario) lusuarios.get(0);
			}
			
			
		return usuario_dev;
	}

	@Override
	public List<Usuario> obtenerUsuariosPorRol(Integer rol_id) {
		List<Usuario> l_usuarios = null;
		
			Query q = entityManager.createNamedQuery("Usuario.roles");
			q.setParameter("rol", rol_id);
			l_usuarios = (List<Usuario>)q.getResultList();
			
		return l_usuarios;
	}
	


	@Override
	public boolean nickNameDisponible(String nick) {
		boolean bdev = false;
		List<Usuario> lusuarios = null;
		
			Query consulta = entityManager.createQuery("SELECT u FROM usuario u WHERE u.nombre = :nick");
			consulta.setParameter("nick", nick);
			
			lusuarios = (List<Usuario>)consulta.getResultList();
			bdev = ((lusuarios == null)||(lusuarios.size()==0));
			
		
		return bdev;
	}
	


}
