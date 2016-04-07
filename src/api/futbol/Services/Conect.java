package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/conect")
public class Conect {
	
	@GET
	@Path("/robot")
	@Produces(MediaType.APPLICATION_JSON)
	public String conectar() throws JSONException{
		JSONObject cuerpo = new JSONObject();
		JSONObject especifico = new JSONObject();
		JSONObject general = new JSONObject();
		JSONArray arr = new JSONArray();
		especifico.put("Nombre","NXT_5");
		especifico.put("Protocolo", 2);
		general.put("Nombre", "null");
		general.put("Protocolo", 2);
		arr.put(especifico);
		arr.put(general);
		cuerpo.put("Conexion", arr);
		return cuerpo.toString();
	}

}
