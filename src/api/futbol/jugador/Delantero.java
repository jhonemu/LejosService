package api.futbol.jugador;

import java.util.ArrayList;

import api.futbol.jugadasComplejas.JugadaCompleja;


public class Delantero extends Jugador {
	public short golesMarcados;
	public byte dorsal;
	
	public Delantero(String nombre, String posicion, short golesMarcados, byte dorsal, ArrayList <JugadaCompleja> listaJugadas){
		super(nombre,posicion,listaJugadas);
		this.golesMarcados = golesMarcados;
		this.dorsal = dorsal;
	}
	@Override
	public String toString(){
		return super.toString() + " con el dorsal " + dorsal + " ha marcado " + golesMarcados + " goles";
	}
	public boolean jugarConLasManos(){
		return false;
	}
	public void registrarGol(){
		this.golesMarcados++;
	}
	public byte getDorsal(){
		return dorsal;
	}
	public short getGolesMarcados(){
		return golesMarcados;
	}
}
