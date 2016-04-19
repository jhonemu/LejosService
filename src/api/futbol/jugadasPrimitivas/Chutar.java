package api.futbol.jugadasPrimitivas;

public class Chutar extends JugadaPrimitiva {
	public int gradosChute;
	public Chutar(String nombre, int potencia,int gradosChute){
		super(nombre,potencia);
		this.gradosChute = gradosChute;
	}
	
	public int getGradosChute(){
		return gradosChute;
	}
	
}
