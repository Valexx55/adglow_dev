package component;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.LoginUsuario;
import dto.UsuarioDTO;
import entity.Usuario;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuario_repository;
	
	
	@Autowired
	UsuarioDaoInterface usuarioDAO;
	
	@Transactional
	public UsuarioDTO leerUsuarioDTO  (int id_usuario)
	{
		UsuarioDTO usuario_leido_dto = null;
		Usuario usuario_leido = null;
		
			usuario_leido = usuario_repository.read(id_usuario);
			usuario_leido_dto =new UsuarioDTO(usuario_leido);
			
		return usuario_leido_dto;
	}
	
	
	@Transactional
	public Usuario leerUsuario (int id_usuario)
	{
		Usuario usuario_leido = null;
		
			usuario_leido = usuario_repository.read(id_usuario);
			
		return usuario_leido;
	}
	
	@Transactional
	public void actualizarUsuario (Usuario usuario_actualizar)
	{
		usuario_repository.update(usuario_actualizar);
	}
	
	@Transactional
	public void insertarUsuario (Usuario usuario_insertar)
	{
		usuario_repository.create(usuario_insertar);
		
	}
	
	@Transactional
	public void borrarUsuario (Integer id_usuario)
	{
		usuario_repository.delete(id_usuario);
	}
	
	@Transactional
	public Usuario existeUsuario(LoginUsuario login_usuario) {
		Usuario usuario = null;
		
			usuario = new Usuario(); 
			usuario.setNombre(login_usuario.getNombre());
			usuario.setPwd(login_usuario.getPwd());
			
		return usuarioDAO.existeUsuario(usuario);
	}
	
	@Transactional
	public List<Usuario> getUsuariosXRol (Integer rol_id)
	{
		List<Usuario> lu =null;
		
			lu = usuarioDAO.obtenerUsuariosPorRol(rol_id);
	
		return lu;
	}
	
	@Transactional
	public boolean nombreDisponible (String nombre)
	{
		boolean nd =false;
		
			nd = usuarioDAO.nickNameDisponible(nombre);
	
		return nd;
	}
	

}
