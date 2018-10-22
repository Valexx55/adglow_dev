package imcxml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;//v4 junit.framework.Assert v3
import org.junit.BeforeClass;
//import static org.junit.Assert.*;
import org.junit.Test;

public class IMCTest {
	
	private static Persona p;
	
	@BeforeClass
	public static void initPersona ()
	{
		System.out.println("Iniciamos los test");
		p = new Persona();
		p.setAltura(1.87f);
		p.setPeso(80);
	}
	
	@AfterClass
	public static void finPersona ()
	{
		System.out.println("Finaliciamos los test");
		p =null;
	}
	
	@Test
	public void primerTest ()
	{
		System.out.println("primerTest()");
		Assert.assertEquals(1, 3-2);
	}
	
	@Test
	public void testIMCNormal ()
	{
		IMC imc =new IMC();
		float imc_num = imc.calcula(p);
		
		boolean imc_normal = (imc_num<25 && imc_num>=18);
		
		Assert.assertTrue(imc_normal);
	}
	
	
	@After
	public void interTest ()
	{
		System.out.println("interTest ()");
	}
	
	//probad con y sin
	@Test(expected=NullPointerException.class)
	public void testPersonaNull ()
	{
		System.out.println("testPersonaNull ()");
		IMC imc =new IMC();
		float imc_num = imc.calcula(null);
		
		Assert.assertEquals(0, imc_num, 0);//margen
	}
	

}
