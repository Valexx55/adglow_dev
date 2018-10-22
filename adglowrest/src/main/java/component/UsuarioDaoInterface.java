package component;

import java.util.List;

import entity.Usuario;

public interface UsuarioDaoInterface {
	
	Usuario existeUsuario (Usuario entity_usuario);
	List<Usuario> obtenerUsuariosPorRol (Integer rol_id);
	boolean nickNameDisponible (String nick);
	
	

}
