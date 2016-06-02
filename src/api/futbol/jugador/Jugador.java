package api.futbol.jugador;

import java.util.ArrayList;

import api.futbol.jugadasComplejas.JugadaCompleja;

public abstract class Jugador {
	
	private String nombre;
	private final String posicion;
	private ArrayList<JugadaCompleja> listaJugadas;
	private boolean uso = false;
	public Jugador(String nombre, String posicion,ArrayList<JugadaCompleja> listaJugadas){
		 this.nombre = nombre;
		 this.posicion = posicion;
		 this.listaJugadas = listaJugadas;
		 this.uso =false;
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
	public void setListaJugadas(ArrayList<JugadaCompleja> lista){
		this.listaJugadas = lista;
		
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getPosicion(){
		return posicion;
	}
	public boolean getUso(){
		return uso;
	}
	public void setUso(boolean u){
		this.uso = u;
	}
	public abstract boolean jugarConLasManos();
}
