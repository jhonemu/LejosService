package api.futbol.jugadasPrimitivas;

import lejos.nxt.Motor;

public class Izquierda extends JugadaPrimitiva {
	
	public Izquierda(String nombre,int potencia){
		super(nombre,potencia);
	}
	public  void Iniciar(int tipo){
		
		Motor.A.resetTachoCount();
		Motor.C.resetTachoCount();
		Motor.A.setSpeed(potencia);
		Motor.C.setSpeed(potencia);
		if (tipo ==1){
		Motor.A.forward();
		Motor.C.backward();
		}
		else if(tipo ==2){
			try {
				Motor.A.forward();
				Motor.C.backward();
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
