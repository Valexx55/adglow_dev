package component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.Rol;


@Service
public class RolService {
	
	@Autowired
	private RolDAO rol_repository;
	

	
	@Transactional
	public Rol leerRol (int id_rol)
	{
		Rol rol_leido = null;
		
			rol_leido = rol_repository.read(id_rol);
			
		return rol_leido;
	}
	
	@Transactional
	public boolean existeRol (String nombre_rol)
	{
		boolean existe_rol = false	;
		
			existe_rol = rol_repository.existeRol(nombre_rol);
			
		return existe_rol;
	}
	
}
