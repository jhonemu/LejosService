package api.futbol.Services;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.JsonGestor.JsonJugadores;
import api.futbol.JsonGestor.JsonUsuario;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugador.Jugador;
import api.futbol.usuario.Usuario;

@Path("/carga")
public class Carga {
	public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
	public static Hashtable<String, Usuario> listaUsuarios = new Hashtable<>();
	public static ArrayList<JugadaCompleja> listaJugadasComplejas = new ArrayList<>();
	@GET
	@Path("/datos")
	public String cargar(){
		new JsonUsuario().Lee();
		new JsonJugadasComplejas().Lee();
		new JsonJugadores().Lee();
		return "Bases de datos cargadas exitosamente";
	}
	
	@GET
	@Path("/numero")
	@Produces(MediaType.TEXT_PLAIN)
	public String consulta(){
		Integer a = listaUsuarios.size();
		Integer b = listaJugadasComplejas.size();
	    Integer c = listaJugadores.size();
		return "usuarios: "+ a.toString()+ " jugadas: " + b.toString() + " jugadores: " + c.toString();
	}

}
