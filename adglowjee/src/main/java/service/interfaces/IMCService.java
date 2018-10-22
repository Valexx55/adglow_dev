package service.interfaces;

import java.util.List;

import dto.IMCResultado;
import dto.Persona;

public interface IMCService {

	IMCResultado calcula (Persona p);
	List<IMCResultado> obtenerListaIMCs ();
}
