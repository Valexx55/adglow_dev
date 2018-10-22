package imcanotaciones;

import org.springframework.stereotype.Service;

@Service
public class IMCImpl implements IMCI {
	
	
	public float calcula (Persona persona)
	{
		float imc = 0;
			
			imc = (persona.getPeso()/(persona.getAltura()*persona.getAltura()));
		
		return imc;
	}

}
