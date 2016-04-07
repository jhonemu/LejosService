package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import api.futbol.jugadasPrimitivas.Adelante;
import api.futbol.jugadasPrimitivas.Derecha;
import api.futbol.jugadasPrimitivas.Izquierda;

@Path("/jprimitivas")
public class Primitivsjugadas {
	public static Adelante trotar = new Adelante("Trotar",720);
	public static Adelante correr = new Adelante("Correr",1440);
	public static Izquierda izquierda = new Izquierda("Girar a la izquierda",720);
	public static Derecha derecha = new Derecha("Girar a la derecha",720);
	
	
	@GET
	@Path("/jugada")
	@Produces(MediaType.APPLICATION_JSON)
	public String infjugada(@QueryParam("jugada")String jugada){
		JSONObject jug = new JSONObject();
		if(jugada.equals("Trote")){
			try{
				jug.put(trotar.getNombre(), trotar.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jug.toString();
	}
	
}
