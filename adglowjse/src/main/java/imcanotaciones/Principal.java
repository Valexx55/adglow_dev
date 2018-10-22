package imcanotaciones;


import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Ejemplo de configuración de Spring por Anotaciones
 * @Component, @Autowired y @Service
 * 
 * Ojear el contextoanotaciones.xml
 * Le digo a Spring en qué paquete debe buscar los componentes
 * 
 * <context:component-scan	base-package="imcanotaciones"/>
 * 
 * @author vale
 *
 */
public class Principal {
	
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextoanotaciones.xml");
		Persona p = (Persona) context.getBean("persona");
		float imc_p = p.calculaImc();
		System.out.println("La persona tiene un IMC de " + imc_p); 
		context.close();
	}

}
