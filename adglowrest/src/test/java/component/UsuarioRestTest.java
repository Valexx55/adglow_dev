package component;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import entity.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioRestTest {
 
 
    @Mock
    private UsuarioRepository usuario_repository;
 
    @InjectMocks
    private UsuarioServices usuario_service;
 
    @Test
    public void leerUsuarioTest() {
 
       
        //preparación
        Usuario u = new Usuario("Alex", "pwdAlex");
        when(usuario_repository.read(anyInt())).thenReturn(u);
        
        Usuario u_leido = usuario_service.leerUsuario(35);
 
        // Validation  
        assertNotNull(u_leido);
        assertEquals(u.getNombre(), u_leido.getNombre());
       
    }
    
    @Test
    public void actualizarUsuarioTest() {
 
       
        
        Usuario u = new Usuario("Alex", "pwdAlex");
          
        usuario_service.actualizarUsuario(u);
 
        verify(usuario_repository, times(1)).update(u);
    }
}