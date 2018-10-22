package imcdfi;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IMCTest {
	
	private static IMCI imci;
	private static Persona p;
	
	@BeforeClass
	public static void initTest ()
	{
		imci = new IMCImpl();
		p =new Persona(imci);//inyecto manualmente
	}
	
	@Test
	public void imc_test ()
	{
		p.setAltura(1.74f);
		p.setPeso(54.7f);
		
		Assert.assertTrue(p.calculaImc()!=0);
	}

}
