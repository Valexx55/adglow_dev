package imcdfi;


public class Persona {
	
	private float peso;
	private float altura;
	
	
	private IMCI imc;	
	
	
	
	public Persona ()
	{
	}
	
	public Persona (IMCI imc)
	{
		this.imc = imc;
	}
	
	public IMCI getImc() {
		return imc;
	}
	public void setImc(IMCI imc) {
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
