package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTConnectionManager;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;

@Path("/conect")
public class Conect {
	public static NXTConnector conn = new NXTConnector();
	@SuppressWarnings("unchecked")
	@GET
	@Path("/robot")
	@Produces(MediaType.APPLICATION_JSON)
	public String conectar(){
		/**/
		JSONObject obj = new JSONObject();
		JSONArray lista = new JSONArray();
		NXTConnectionManager man= new NXTConnectionManager();
		NXTInfo[] search = man.search();
		for(NXTInfo info:search){
			JSONObject aux = new JSONObject();
			aux.put("nombre", info.name);
			lista.add(aux);
		}
		obj.put("robots", lista);
		return obj.toString();
	}
	@GET
	@Path("/conexion")
	@Produces(MediaType.TEXT_PLAIN)
	public String conexion(@QueryParam("nombre")String nombre){
		if(conn.connectTo(nombre,NXTComm.LCP)){
			
			return "Conexion Exitosa";
		}
		else{
			return "Conexion fallida";
		}
	}

}
