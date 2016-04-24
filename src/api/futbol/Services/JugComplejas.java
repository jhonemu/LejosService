package api.futbol.Services;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.jugadasComplejas.JugadaCompleja;


@Path("/jcomplejas")
public class JugComplejas {
	
	public static ArrayList<JugadaCompleja> listaJugadasComplejas = new ArrayList<>();
	@GET
	@Path("/lista")
	@Produces(MediaType.TEXT_PLAIN)
	public String consultarjugadas(){
		
		new JsonJugadasComplejas().Lee();
		Integer i =new Integer(listaJugadasComplejas.size());
		for(int j = 0;j<i;j++){
			System.out.println(listaJugadasComplejas.get(j).getNombre());
		}
		return i.toString() ;
	}
	@POST
	@Path("/crea")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crear(@PathParam("jugada") String jugada){
		System.out.println(jugada);
	}
}				
