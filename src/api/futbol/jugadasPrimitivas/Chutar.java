package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Chutar extends JugadaPrimitiva {
	public int gradosChute;
	public Chutar(String nombre, int potencia,int gradosChute){
		super(nombre,potencia);
		this.gradosChute = gradosChute;
	}
	
	public int getGradosChute(){
		return gradosChute;
	}
	public void Iniciar(){
		Motor.B.setSpeed(potencia);
		Motor.B.rotateTo(gradosChute);
		Motor.B.rotateTo(gradosChute*-1);
	}
	
}
