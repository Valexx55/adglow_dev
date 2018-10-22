package dto;

import java.util.HashSet;
import java.util.Set;

import entity.UsuarioRol;

public class RolDTO {
	
	private Integer idrol;
	private String nombre;
	//private Set<UsuarioRolDTO> usuarioRols = new HashSet<UsuarioRolDTO>(0);
	public Integer getIdrol() {
		return idrol;
	}
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public RolDTO(Integer idrol, String nombre) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
	}

	public RolDTO ()
	{
		
	}

}
