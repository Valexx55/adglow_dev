package entity;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UsuariosIdGen implements IdentifierGenerator{

	private final static int SEQ_INI_USUARIOS =106;
	private int anterior;
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		int siguiente =0;	
		
			siguiente = anterior + SEQ_INI_USUARIOS;
			anterior = anterior + 1;
			
		return siguiente;
	}

   
}
