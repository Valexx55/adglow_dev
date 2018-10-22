package imcdf;


public class Persona {
	
	private float peso;
	private float altura;
	
	
	private IMC imc;	
	
	
	
	public Persona ()
	{
	}
	
	
	public Persona (IMC imc)
	{
		this.imc = imc;
	}
	
	
	public IMC getImc() {
		return imc;
	}
	public void setImc(IMC imc) {
		this.imc = imc;
	}
	
	public float calculaImc ()
	{
		return imc.calcula(this);
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
	
	

}
