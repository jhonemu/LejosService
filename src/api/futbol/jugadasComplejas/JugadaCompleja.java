package api.futbol.jugadasComplejas;

import java.util.ArrayList;

import api.futbol.Services.Primitivsjugadas;
import api.futbol.jugadasPrimitivas.Adelante;
import api.futbol.jugadasPrimitivas.Atras;
import api.futbol.jugadasPrimitivas.Chutar;
import api.futbol.jugadasPrimitivas.Derecha;
import api.futbol.jugadasPrimitivas.Izquierda;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;



public abstract class JugadaCompleja {
	private String nombreJugada;
	private final String fechaCreacion;
	private final UsuarioAdministrador Autor; 
	private ArrayList<JugadaPrimitiva> Jugada;
	private String Explicacion;
	private boolean uso = false;
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
	public void setJugada(ArrayList<JugadaPrimitiva> list){
		this.Jugada = list;
	}
	public void ejecutar(){
		for ( int i = 0;i<this.Jugada.size();i++){
			if(this.Jugada.get(i) instanceof Adelante){
				((Adelante) this.Jugada.get(i)).Iniciar(2);
				Primitivsjugadas.pos.calcular(1);
			}
			else if(this.Jugada.get(i) instanceof Atras){
				((Atras) this.Jugada.get(i)).Iniciar(2);
				Primitivsjugadas.pos.calcular(2);
			}
			else if(this.Jugada.get(i) instanceof Chutar){
				((Chutar) this.Jugada.get(i)).Iniciar();
			}
			else if(this.Jugada.get(i) instanceof Izquierda){
				((Izquierda) this.Jugada.get(i)).Iniciar(2);
				Primitivsjugadas.pos.calcular(4);
			}
			else if(this.Jugada.get(i) instanceof Derecha){
				((Derecha) this.Jugada.get(i)).Iniciar(2);
				Primitivsjugadas.pos.calcular(3);
			}
		}
	}
	public boolean getUso(){
		return uso;
	}
	public void setUso(boolean u){
		this.uso = u;
	}
}
