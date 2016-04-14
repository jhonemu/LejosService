package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Adelante extends JugadaPrimitiva{

	public Adelante(String nombre, int potencia) {
		super(nombre,potencia);
	}
	public  void Iniciar(){
		Motor.A.setSpeed(potencia);
		Motor.A.forward();
		Motor.C.forward();
	}
	public  void Detener(){
		
		Motor.A.stop();
		Motor.C.stop();
	}
}
