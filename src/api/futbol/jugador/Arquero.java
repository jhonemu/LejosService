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
	public String getTiempoSinGoles(){
		Integer a = TiempoSinGoles;
		return a.toString();
	}
	public String getDorsal(){
		Byte a = dorsal;
		return a.toString();
	}
}
