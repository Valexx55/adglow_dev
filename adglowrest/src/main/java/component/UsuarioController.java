package component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.LoginUsuario;
import dto.UsuarioDTO;
import entity.Usuario;

/**
 * EJEMPLO DE IMPLEMENTACÓN DE WEB SERVICE REST CON SPRING Y JPA, TRATANDO LA ENTIDAD USUARIO
 * GET --> LEE UN USUARIO Y LO DEVUELVE (json)
 * POST --> INSERTA EL USUARIO RECIBIDO EN EL CUERPO DE LA PETICIÓN (json)
 * PUT --> ACTUALIZA UN USUARIO O CREA UNO NUEVO 
 * DELETE --> BORRA UN USUARIO
 * 
 * Gestión de excepciones y datos devueltos
 * 
 * Hay cierto debate sobre qué debe devolverse en respuesta a la ejecución de un servicio WEB REST.
 * No hay realmente una "LEY" al respecto, aunque la lógica apunta a aprovechar la semántima del protocolo 
 * HTTP y sus códigos de estado (léase https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP)
 * 
 * 
 * 
 * @author vale
 *
 */
@RestController //realmente, esto equivale a Controller + ResponseBody
public class UsuarioController {
	
	@Autowired
	UsuarioServices usuario_service;
	
	@Autowired
    private ResourceBundleMessageSource mensajes;
	

	@RequestMapping(path = "/usuario/{idUsuario}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuario(@PathVariable Integer idUsuario) {
		
		ResponseEntity<Usuario> respuesta = null;
		Usuario usuario_leido = null;
		HttpStatus httpStatus =null;
			
		try {
		
			usuario_leido = usuario_service.leerUsuario(idUsuario);
			httpStatus =(null==usuario_leido) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
			respuesta = new ResponseEntity<Usuario> (usuario_leido, httpStatus);
			
			System.out.println("Respuesta " + respuesta);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return respuesta;
	}
	
	
	@CrossOrigin(origins = "http://www.hrsanroque.com")
	@RequestMapping(path = "/usuariodto/{idUsuario}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> getUsuariodto(@PathVariable Integer idUsuario) {
		
		ResponseEntity<UsuarioDTO> respuesta = null;
		UsuarioDTO usuario_leido = null;
		HttpStatus httpStatus =null;
		
		try {
		
			usuario_leido = usuario_service.leerUsuarioDTO(idUsuario);
			httpStatus =(null==usuario_leido) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
			respuesta = new ResponseEntity<UsuarioDTO> (usuario_leido, httpStatus);
			
			System.out.println("Respuesta " + respuesta);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
		return respuesta;
	}
	
	@RequestMapping(path = "/usuario", method=RequestMethod.POST)
	public ResponseEntity<Void> postUsuario(@RequestBody Usuario usuario_insertar) {
		
		System.out.println(usuario_insertar.toString());
		ResponseEntity<Void> respuesta = null;
		
		try
		{
			usuario_service.insertarUsuario(usuario_insertar);
			respuesta = new ResponseEntity<Void> (HttpStatus.CREATED);
			
		}catch (Exception e)
		{
			e.printStackTrace();
			if ((e instanceof SQLIntegrityConstraintViolationException) || (e instanceof DataIntegrityViolationException) || (e instanceof ConstraintViolationException))
			{
				respuesta = new ResponseEntity<Void> (HttpStatus.CONFLICT); //si está repetido el ID usuario que se pretende insertar (Excepción PK)
			} else throw e;//si no es un fallo de tipo violación clave primaria, progapo el error tal cual, para que el cliente pueda dar a conocer la causa (la base da datos está caida, lo que sea) : Otor tipo de error en definitiva
			
		}
		
		return respuesta;	
	}
	
	
	
	@RequestMapping(path = "/usuario", method=RequestMethod.PUT)
	public ResponseEntity<Void> putUsuario(@RequestBody Usuario usuario_actualizar) {
		ResponseEntity<Void> respuesta = null;
		
		try
		{
			usuario_service.actualizarUsuario( usuario_actualizar );//si existe se actualiza y si no se crea
			respuesta = new ResponseEntity<Void> (HttpStatus.CREATED);//si la instrucción anterior se ejecuto con éxito, la respuesta es HTTP 201 - CREATED
			
		}catch (Exception e)
		{
			e.printStackTrace();//registro el fallo 
			throw e;//y propago la excepción, para que le llegue al cliente
			
		}
		
		
		return respuesta;	
	}
	
	
	@RequestMapping(path = "/usuario/{idUsuario}",  method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUsuario(@PathVariable Integer idUsuario) {
		ResponseEntity<Void> respuesta = null;
		
		try
		{
			usuario_service.borrarUsuario(idUsuario);
			respuesta = new ResponseEntity<Void> (HttpStatus.OK);
		}catch (Exception e)
		{
			e.printStackTrace();
			if  (e instanceof IllegalArgumentException) {
				//si el usuario no existe, se quiere borrar un usuario que no existía, se lanza el NOT_FOUND
				respuesta = new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
				
			} else throw e; //si se produce otro tipo de error, se propaga
			
		}
	return respuesta;
		
	}
	
	@RequestMapping(path = "/login", method=RequestMethod.POST)
	public ResponseEntity<Void> loginUsuario(@Valid @RequestBody LoginUsuario login_usuario, BindingResult br) {
		
		System.out.println(login_usuario.toString());
		ResponseEntity<Void> respuesta = null;
		Usuario u = null;
		HttpStatus httpStatus = null;
		try
		{
			
			
			if (br.hasErrors())
			{
				String str_aux = mensajes.getMessage(br.getFieldError(), new Locale ("es")); //sorpresivamente, el método getFiledrror, devuelve el 
				System.out.println("Se encontraron errores en la entrada " +str_aux);
				httpStatus = HttpStatus.FORBIDDEN;
			} else {
				u = usuario_service.existeUsuario(login_usuario);
				httpStatus = (null!=u) ? HttpStatus.ACCEPTED : HttpStatus.FORBIDDEN;
			}
				respuesta = new ResponseEntity<Void> (httpStatus);
					
		}catch (Exception e)
		{
			e.printStackTrace();
			if ((e instanceof SQLIntegrityConstraintViolationException) || (e instanceof DataIntegrityViolationException) || (e instanceof ConstraintViolationException))
			{
				respuesta = new ResponseEntity<Void> (HttpStatus.CONFLICT); //si está repetido el ID usuario que se pretende insertar (Excepción PK)
			} else throw e;//si no es un fallo de tipo violación clave primaria, progapo el error tal cual, para que el cliente pueda caonocer la causa (la base da datos está caida, lo que sea) : Otor tipo de error en definitiva
			
		}
		
		return respuesta;	
	}
	

	@RequestMapping(path = "/usuariosrol/{roleid}", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> usuariosRol(@PathVariable Integer roleid ) {
		
		ResponseEntity<List<Usuario>> respuesta = null;
		List<Usuario> lu = null;
		HttpStatus httpStatus = null;
		
		try
		{
				lu = usuario_service.getUsuariosXRol(roleid);
				httpStatus =(null== lu) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
				respuesta = new ResponseEntity<List<Usuario>> (lu, httpStatus);
				
			
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		return respuesta;	
	}
	
	
	
	@RequestMapping(path = "/usuario/nombre/{nombre_usuario}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<Void> checkNombreDisponible(@PathVariable String nombre_usuario) {
		
		ResponseEntity<Void> respuesta = null;
		boolean disponible = false;
		HttpStatus httpStatus =null;
			
		try {
		
			disponible = usuario_service.nombreDisponible(nombre_usuario);
			httpStatus =(disponible) ? HttpStatus.OK : HttpStatus.CONFLICT;
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
