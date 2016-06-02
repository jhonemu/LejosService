package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Adelante extends JugadaPrimitiva{

	public Adelante(String nombre, int potencia) {
		super(nombre,potencia);
	}
	public  void Iniciar(int tipo){
		Motor.A.resetTachoCount();
		Motor.C.resetTachoCount();
		Motor.A.setSpeed(potencia);
		Motor.C.setSpeed(potencia);
		if(tipo ==1){
		Motor.A.forward();
		Motor.C.forward();}
		else if(tipo == 2){
				try {
					Motor.A.forward();
					Motor.C.forward();
					Thread.sleep(1000);
					Detener();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			
		}
	}
	public  void Detener(){
		
		Motor.A.stop();
		Motor.C.stop();
	}
}
