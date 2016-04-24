package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Derecha extends JugadaPrimitiva{

	public Derecha(String nombre,int potencia){
		super(nombre,potencia);
	}
	
	public  void Iniciar(){
		Motor.A.resetTachoCount();
		Motor.C.resetTachoCount();
		Motor.A.setSpeed(potencia);
		Motor.C.setSpeed(potencia);
		Motor.A.backward();
		Motor.C.forward();
		
	}
	@SuppressWarnings("deprecation")
	public  void Detener(){
		Motor.A.stop();
		Motor.C.stop();
	
	}
}
