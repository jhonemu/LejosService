package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTConnector;

@Path("/conect")
public class Conect {
	public static NXTConnector conn = new NXTConnector();
	@GET
	@Path("/robot")
	@Produces(MediaType.TEXT_PLAIN)
	public String conectar(){
		if(conn.connectTo("NXT_5",NXTComm.LCP)){
			return "Conexion Exitosa";
	}
		else{
			return "Conexion fallida";
		}
		/*JSONObject cuerpo = new JSONObject();
		JSONObject especifico = new JSONObject();
		JSONObject general = new JSONObject();
		JSONArray arr = new JSONArray();
		especifico.put("Nombre","NXT_5");
		especifico.put("Protocolo", 2);
		general.put("Nombre", "null");
		general.put("Protocolo", 2);
		arr.put(especifico);
		arr.put(general);
		cuerpo.put("Conexion", arr);*/
		
	
	}

}
