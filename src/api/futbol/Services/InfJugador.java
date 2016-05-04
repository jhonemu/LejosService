package api.futbol.Services;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Path("/jugador")
public class InfJugador {
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultar(){
		JSONObject jugadores = new JSONObject();
		JSONArray lista = new JSONArray();
		for (int i = 0 ;i<Carga.listaJugadores.size();i++){
			JSONObject aux = new JSONObject();
			aux.put("nombre", Carga.listaJugadores.get(i).getNombre());
			lista.add(aux);
		}
		jugadores.put("jugadores", lista);
		return jugadores.toString();
	}

}
