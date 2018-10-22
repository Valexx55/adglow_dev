package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import dto.Persona;
import dto.IMCResultado;

@Aspect
public class AspectosIMC {
	
	
	@Pointcut("execution(* controller.IMCController.imc(..))")  
    public void controllerIMC(){
		
		
	}
	

    @Before("controllerIMC()")  
    public void antesDeImc (JoinPoint jp)
    {  
        System.out.println("Recibida petición de cálculo");
        Persona p = (Persona) jp.getArgs()[0];
        System.out.println(p);
    }
    
    
    @Pointcut("execution(* service.interfaces.IMCService.calcula(..))")  
    public void servicioIMC(){
		
		
	}
	
    @AfterReturning(pointcut="servicioIMC()", returning="resultado")
    public void postServicioIMC(Object resultado) 
    {
    	System.out.println("IMC calculado");
    	IMCResultado imc_res = (IMCResultado) resultado;
    	System.out.println(imc_res);
           
    }


}
