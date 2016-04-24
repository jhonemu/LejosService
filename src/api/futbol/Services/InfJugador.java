package api.futbol.Services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api.futbol.JsonGestor.JsonJugadores;

import api.futbol.jugador.Jugador;

@Path("/jugador")
public class InfJugador {
	public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
	@GET
	@Path("/consulta")
	@Produces(MediaType.TEXT_PLAIN)
	public String consultar(){
	
			
		 	new JsonJugadores().Lee();
		Integer a = listaJugadores.size();
		for(int i = 0 ;i<listaJugadores.size();i++){
			System.out.println( listaJugadores.get(i).getNombre());
			System.out.println(listaJugadores.get(i).getPosicion());
			System.out.println(listaJugadores.get(i).getListaJugadas());
			
		}
		return a.toString();
	}

}
