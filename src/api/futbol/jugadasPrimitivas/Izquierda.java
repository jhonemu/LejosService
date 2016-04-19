package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Izquierda extends JugadaPrimitiva {
	
	public Izquierda(String nombre,int potencia){
		super(nombre,potencia);
	}
	public  void Iniciar(){
		Motor.A.setSpeed(potencia);
		Motor.C.setSpeed(potencia);
		Motor.A.forward();
		Motor.C.backward();
	}
	public  void Detener(){
		
		Motor.A.stop();
		Motor.C.stop();
	}
}
