package component;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import entity.Rol;


@Repository
public class RolDAO extends GenericDAO<Rol> implements RolDaoInterface {

	@Override
	public boolean existeRol(String nombre_rol) {
		boolean existe = false;
		List<Rol> lroles = null;
		
			Query consulta = entityManager.createQuery("FROM rol r WHERE r.nombre = :nombre_rol");
			consulta.setParameter("nombre_rol", nombre_rol);
			
			lroles = (List<Rol>)consulta.getResultList();
			existe = ((lroles != null)&&(lroles.size()>0));
			
			
			
		return existe;
	}

	@Override
	public Class getType() {
		
		return Rol.class;
	}

	


}
