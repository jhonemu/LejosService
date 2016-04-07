package api.futbol.jugadasPrimitivas;

public abstract class JugadaPrimitiva {
	private String nombre;
	private int potencia;
	
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
}
