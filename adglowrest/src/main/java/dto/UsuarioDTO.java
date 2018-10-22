package dto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import entity.Usuario;
import entity.UsuarioRol;

public class UsuarioDTO {
	
	private Integer idusuario;
	private String nombre;
	private String pwd;
	//@JsonIgnore
	private Set<RolDTO> usuarioRols = new HashSet<RolDTO>(0);


	public UsuarioDTO ()
	{
		
	}
	
	
	
	public Integer getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public Set<RolDTO> getUsuarioRols() {
		return usuarioRols;
	}



	public void setUsuarioRols(Set<RolDTO> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}



	public UsuarioDTO (Usuario usuario)
	{
		this.nombre = usuario.getNombre();
		this.idusuario = usuario.getIdusuario();
		this.pwd =usuario.getPwd();
		this.usuarioRols = new HashSet<RolDTO>();
		
		Iterator<UsuarioRol> it = usuario.getUsuarioRols().iterator();
		UsuarioRol uraux =null;
		RolDTO rdtoaux =null;
		while (it.hasNext())
		{
			uraux = it.next();
			rdtoaux = new RolDTO();
			rdtoaux.setIdrol(uraux.getRol().getIdrol());
			rdtoaux.setNombre(uraux.getRol().getNombre());
			this.usuarioRols.add(rdtoaux);
			
		}
	
	}
}
