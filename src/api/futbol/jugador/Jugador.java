package api.futbol.jugador;

import java.util.ArrayList;

import api.futbol.jugadasComplejas.JugadaCompleja;
public abstract class Jugador {
	private String nombre;
	private final String posicion;
	private ArrayList<JugadaCompleja> listaJugadas;
	public Jugador(String nombre, String posicion,ArrayList<JugadaCompleja> listaJugadas){
		 this.nombre = nombre;
		 this.posicion = posicion;
		 this.listaJugadas = listaJugadas;
	}
	
	@Override
	public String toString(){
		return "El futbolista " + nombre + " Juega de " + posicion;
	}
	
	public boolean equals(Jugador f){
		return this.equals(f);
	}
	
	public ArrayList<JugadaCompleja> getListaJugadas(){
		return listaJugadas;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getPosicion(){
		return posicion;
	}
	public abstract boolean jugarConLasManos();
}
