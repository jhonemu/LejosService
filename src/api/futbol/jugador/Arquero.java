package api.futbol.jugador;

import java.util.ArrayList;

import api.futbol.jugadasComplejas.JugadaCompleja;



public class Arquero extends Jugador {
	
	public int TiempoSinGoles;
	public byte dorsal;
	public Arquero(String nombre, String posicion, int TiempoSinGoles,byte dorsal, ArrayList <JugadaCompleja> listaJugadas){
		super(nombre,posicion,listaJugadas);
		this.TiempoSinGoles = TiempoSinGoles;
		this.dorsal = dorsal;
	}
	@Override
	public boolean jugarConLasManos() {
		return true;
	}
	
	@Override
	public String toString(){
		return super.toString()+" con el dorsal "+ dorsal+ " Tiempo Sin Goles "+TiempoSinGoles;
	}
	
	public void registrarTiempoGol(int tiempo){
		this.TiempoSinGoles = tiempo;
	}
	public int getTiempoSinGoles(){
		return TiempoSinGoles;
	}
	public byte getDorsal(){
		return dorsal;
	}
}
