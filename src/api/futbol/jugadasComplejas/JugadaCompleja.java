package api.futbol.jugadasComplejas;

import java.util.ArrayList;

import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;



public abstract class JugadaCompleja {
	private String nombreJugada;
	private final String fechaCreacion;
	private final UsuarioAdministrador Autor; 
	private ArrayList<JugadaPrimitiva> Jugada;
	private String Explicacion;
	
	public JugadaCompleja(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		this.nombreJugada=nombreJugada;
		this.fechaCreacion=fechaCreacion;
		this.Autor=Autor;
		this.Jugada=Jugada;
		this.Explicacion=Explicacion;
	}
	
	@Override
	public String toString(){
		return "Jugada "+ nombreJugada;
	}
	
	public boolean equals(JugadaCompleja j){

		if (!(j.Jugada.size() == this.Jugada.size())){
			return false;
		}
		return true;
	}
	public abstract String identificarJugada();
	
	public ArrayList<JugadaPrimitiva> getJugada(){
		return Jugada;
	}
	
	public String getExplicacion(){
		return Explicacion;
	}
	
	public UsuarioAdministrador getAutor(){
		return Autor;
	}
	
	public String getfechaCreacion(){
		return fechaCreacion;
	}
	
	public String getNombre(){
		return nombreJugada;
	}
	
}
