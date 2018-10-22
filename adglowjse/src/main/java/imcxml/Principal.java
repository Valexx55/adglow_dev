package imcxml;


import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Ejemplo de configuración de Spring por XML
 * Dos objetos instanciados mediante IOC
 * 
 * @author vale
 *
 */
public class Principal {
	
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextoxml.xml");
		Persona p = (Persona) context.getBean("persona");
		IMC imc = (IMC) context.getBean("imcService");
		float imc_p = imc.calcula(p);
		System.out.println("La persona tiene un IMC de " + imc_p); 
		context.close();
	}

}
