package api.futbol.Services;

import javax.ws.rs.Path;

import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.JsonGestor.JsonJugadores;
import api.futbol.JsonGestor.JsonUsuario;

@Path("/")
public class Inicial {
	static{new JsonUsuario().Lee();
	new JsonJugadasComplejas().Lee();
	new JsonJugadores().Lee();}
}
