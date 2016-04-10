package api.futbol.jugadasComplejas;

import java.util.ArrayList;

import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;



public class JugadaComplejaDefensiva extends JugadaCompleja {
	
	private int complejidad;
	private String descripcion;

	 
	public JugadaComplejaDefensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.complejidad=super.getJugada().size();	
		this.descripcion = "La jugada " + nombreJugada + " es una " + getComplejidad()+ ", fue creada por " + Autor.getNombre() + ", en la fecha " + fechaCreacion;
		}
	@Override
	public String identificarJugada() {
		return "Jugada Defensiva";
	}
	
	public String getComplejidad(){
		if(complejidad == 0){
			return "yape";
		}
	else if (complejidad ==1){
		return "jugada poco defensiva, numero de jugadas " + complejidad;
		}
		else if(complejidad ==  2){
			return "jugada medianamente defensiva, numero de jugadas " + complejidad ;
		}
		else if (complejidad >= 3){
			return "jugada muy defensiva, numero de jugadas " + complejidad;
		}
		else{
			return "no existe jugada";
		}
	}
	public String getDescripcion(){
		return descripcion;
	}
	public int getnumcomplejidad(){
		return complejidad;
	}
}
