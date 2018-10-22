package imcxml;


public class IMC {
	
	
	public float calcula (Persona persona)
	{
		float imc = 0;
			
			imc = (persona.getPeso()/(persona.getAltura()*persona.getAltura()));
		
		return imc;
	}

}
