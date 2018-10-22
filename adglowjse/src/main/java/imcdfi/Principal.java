package imcdfi;


import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Ejemplo de configuración de Spring por XML
 * Dos objetos instanciados mediante IOC
 * 
 * Añadimos la definició de una interfaz
 * 
 * Añadimos una Dependecia FUNCIONAL
 * El servicio de IMC pasa a ser un atributo de Persona
 * 
 * Usamos la Inyección de dependecias en sus dos 
 * variantes: mediante el constrcutor, mediante el set
 * 
 * NOTA: ojear el contextodf.xml para jugar con ambos tipos de inyección
 * 
 * @author vale
 *
 */
public class Principal {
	
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextodfi.xml");
		Persona p = (Persona) context.getBean("persona");
		float imc_p = p.calculaImc();
		System.out.println("La persona tiene un IMC de " + imc_p); 
		context.close();
	}

}
