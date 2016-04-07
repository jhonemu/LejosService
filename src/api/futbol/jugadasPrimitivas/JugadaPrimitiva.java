package api.futbol.jugadasPrimitivas;

public abstract class JugadaPrimitiva {
	protected String nombre;
	protected int potencia;
	
	public JugadaPrimitiva(String nombre,int potencia){
		this.nombre = nombre;
		this.potencia = potencia;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public int getPotencia(){
		return potencia;
	}
	public void setPotencia(int potencia){
		this.potencia = potencia;
	}
}
