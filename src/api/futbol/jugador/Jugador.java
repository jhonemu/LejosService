package api.futbol.jugador;

public class Jugador {
	private String nombre;
	private final String posicion;
	private final byte dorsal;
	public Jugador(String nombre, String posicion, byte dorsal){
		 this.nombre = nombre;
		 this.posicion = posicion;
		 this.dorsal = dorsal;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getPosicion(){
		return posicion;
	}
	
	public byte getDorsal(){
		return dorsal;
	}
}
