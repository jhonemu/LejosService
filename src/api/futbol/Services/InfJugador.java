package api.futbol.Services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.JsonGestor.JsonJugadores;
import api.futbol.jugador.Arquero;
import api.futbol.jugador.Delantero;
import api.futbol.jugador.Jugador;

@Path("/jugador")
public class InfJugador {
	public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
	@GET
	@Path("/consulta")
	@Produces(MediaType.TEXT_PLAIN)
	public String consultar(){
	
		
		return "holi";
	}

}
