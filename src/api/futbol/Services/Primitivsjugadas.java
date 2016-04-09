package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import api.futbol.jugadasPrimitivas.Adelante;
import api.futbol.jugadasPrimitivas.Atras;
import api.futbol.jugadasPrimitivas.Chutar;
import api.futbol.jugadasPrimitivas.Derecha;
import api.futbol.jugadasPrimitivas.Izquierda;

@Path("/jprimitivas")
public class Primitivsjugadas {
	public static Adelante trotar = new Adelante("Trotar",7200);
	public static Adelante correr = new Adelante("Correr",1440);
	public static Izquierda izquierda = new Izquierda("Girar a la izquierda",720);
	public static Derecha derecha = new Derecha("Girar a la derecha",720);
	//public static Chutar chutar = new Chutar("Chute",720);
	//public static Chutar patear  = new Chutar("Patear",1440);
	public static Atras atras = new Atras("Ir atras",720);
	public static Atras ratras = new Atras("Correr atras",1440);
	
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
		else if(jugada.equals("Correr")){
			try{
				jug.put(correr.getNombre(), correr.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(jugada.equals("Izquierda")){
			try{
				jug.put(izquierda.getNombre(), izquierda.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(jugada.equals("Derecha")){
			try{
				jug.put(derecha.getNombre(), derecha.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(jugada.equals("Atras")){
			try{
				jug.put(atras.getNombre(), atras.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(jugada.equals("Correr Atras")){
			try{
				jug.put(ratras.getNombre(), ratras.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(jugada.equals("Chute")){
			/*try{
				jug.put(chutar.getNombre(), chutar.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}*/
		}
		else if(jugada.equals("Patear")){
			/*try{
				jug.put(patear.getNombre(), patear.getPotencia());
			} catch (JSONException e) {
				e.printStackTrace();
			}*/
		}
		return jug.toString();
	}
	
}
