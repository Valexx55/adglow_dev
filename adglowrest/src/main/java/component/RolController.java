package component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import entity.Rol;

/*
 * 
 * 
 * @author vale
 *
 */
@RestController 
public class RolController {
	
	@Autowired
	RolService rol_service;
	
	

	@RequestMapping(path = "/rol/{idRol}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<Rol> getRolInfo(@PathVariable Integer idRol) {
		
		ResponseEntity<Rol> respuesta = null;
		Rol rol_leido = null;
		HttpStatus httpStatus =null;
		
		try {
			
			
			rol_leido = rol_service.leerRol(idRol);
			httpStatus = (null!=rol_leido) ? HttpStatus.OK : HttpStatus.NO_CONTENT; 
			respuesta = new ResponseEntity<Rol> (rol_leido, httpStatus);
			
			System.out.println("Respuesta " + respuesta);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return respuesta;
	}
	
	
	@RequestMapping(path = "/rol/existe/{nombre}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<Void> existeRolXNombre(@PathVariable String nombre) {
		
		ResponseEntity<Void> respuesta = null;
		HttpStatus httpStatus =null;
		boolean existe_rol =false;
		
		try {
			
			
			existe_rol = rol_service.existeRol(nombre);
			httpStatus = (existe_rol) ? HttpStatus.OK : HttpStatus.NO_CONTENT; 
			respuesta = new ResponseEntity<Void> (httpStatus);
			
			System.out.println("Respuesta " + respuesta);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return respuesta;
	}
	
	
	
	
	

}
