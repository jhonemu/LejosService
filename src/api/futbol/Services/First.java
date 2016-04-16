package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.JsonGestor.JsonUsuario;

@Path("first")
public class First {
	
	@GET
	@Path("ejc")
	public void ejecutar(){
		new JsonUsuario().Lee();
		new JsonJugadasComplejas().Lee();
	}
}
