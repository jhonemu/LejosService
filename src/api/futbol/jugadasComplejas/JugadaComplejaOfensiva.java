package api.futbol.jugadasComplejas;

import java.util.ArrayList;

import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;



public class JugadaComplejaOfensiva extends JugadaCompleja {
	
	private int efectividad;
	private String descripcion;
	
	public JugadaComplejaOfensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.efectividad= super.getJugada().size();		
		this.descripcion= "La jugada " + nombreJugada + " es una " + getEfectividad()+  ", fue creada por " + Autor.getNombre() + ", en la fecha " + fechaCreacion;
	}	
	@Override
	public String identificarJugada() {
		return "Jugada Ofensiva";
	}
	private String getEfectividad(){
		if (efectividad ==1){
		return "jugada poco efectiva, numero de jugadas " + efectividad;
		}
		else if(efectividad==  2){
			return "jugada medianamente efectiva, numero de jugadas " + efectividad ;
		}
		else if (efectividad >= 3){
			return "jugada efectiva, numero de jugadas " + efectividad;
		}
		else{
			return "no existe jugada";
		}
	}
	public String getDescripcion(){
		return descripcion;
	}
	public int getNumEfectividad(){
		return efectividad;
	}
}
