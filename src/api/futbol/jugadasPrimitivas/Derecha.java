package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Derecha extends JugadaPrimitiva{

	public Derecha(String nombre,int potencia){
		super(nombre,potencia);
	}
	public  void Iniciar(){
		Motor.A.setSpeed(potencia);
		Motor.C.setSpeed(potencia);
		Motor.A.backward();
		Motor.C.forward();
	}
	public  void Detener(){
		Motor.A.stop();
		Motor.C.stop();
	}
}
