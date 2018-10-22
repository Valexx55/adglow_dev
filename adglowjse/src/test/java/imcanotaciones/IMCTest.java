package imcanotaciones;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:contextoanotaciones.xml"})
public class IMCTest {
	
	@Autowired
	Persona p;
	
	@Test
	public void imc_test ()
	{
		p.setAltura(1.74f);
		p.setPeso(54.7f);
		
		Assert.assertTrue(p.calculaImc()!=0);
	}

}
