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
	
	@GET
	@Path("/consulta")
	@Produces(MediaType.TEXT_PLAIN)
	public String consultar(){
	
		return "holi";
	}

}
