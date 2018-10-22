package dto;

public class Persona {
	
	private float peso;
	private float altura;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Persona ()
	{
	}
	

	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NOMBRE " + nombre +  " ALTURA " + altura + " PESO " + peso;
	}
	
}
