package api.futbol.Services;

import lejos.nxt.Motor;

public class Posicion {
	Integer x =  0;
	Integer y =  0;
	Integer O =  0;
	public String calcular(int tipo){
		//adelante
		if(tipo == 1){
			if(O==0){
				x = (int) (x +(( Motor.A.getTachoCount()*6*Math.PI)/360));
			 
			}
			else{
				double distancia =  ((Motor.A.getTachoCount()*6*Math.PI)/360);
				x = (int) (x + distancia*Math.cos(Math.toRadians(O)));
				y = (int) (y + distancia*Math.sin(Math.toRadians(O)));
			}
			return x.toString()+","+y.toString();
		}
		//atras
		else if(tipo == 2){
			if(O ==0){
				x =  (int) (x +(( Motor.A.getTachoCount()*6*Math.PI)/360));
			}
			else{
				double distancia =  ((Motor.A.getTachoCount()*6*Math.PI)/360);
				x = (int) (x + distancia*Math.cos(Math.toRadians(O)));
				y = (int) (y + distancia*Math.sin(Math.toRadians(O)));
			}
			return x.toString()+","+y.toString();
		}
		//derecha
		else if(tipo ==3){
			O = O + ((Motor.C.getTachoCount()-Motor.A.getTachoCount())/4);
			return O.toString();
		}
		//isquierda
		else if(tipo == 4){
			O = O -((Motor.A.getTachoCount()-Motor.C.getTachoCount())/4);
			return O.toString();
		}
		return "holi";
	}
}
