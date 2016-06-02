package api.futbol.Services;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.futbol.jugador.Arquero;

@Path("/Partido")
public class Partido {
	public static File fich;
	public static String jugador1;
	public static String jugador2;
	@SuppressWarnings("unchecked")
	@GET
	@Path("/iniciar")
	@Produces(MediaType.APPLICATION_JSON)
	public String iniciar(@QueryParam("nombre1") String nombre1,@QueryParam("nombre2") String nombre2){
		fich = new File("C:\\Users\\Public\\Documents\\Buff.txt");
		JSONObject obj = new JSONObject();
		JSONArray jugadas1 = new JSONArray();
		JSONArray jugadas2 = new JSONArray();
		for(int i = 0; i< Carga.listaJugadores.size();i++){
				
			if(nombre1.equals(Carga.listaJugadores.get(i).getNombre())){
				Carga.listaJugadores.get(i).setUso(true);
				for (int j=0;j<Carga.listaJugadores.get(i).getListaJugadas().size();j++){
					Carga.listaJugadores.get(i).getListaJugadas().get(j).setUso(true);
					JSONObject aux = new JSONObject();
					aux.put("jugada",Carga.listaJugadores.get(i).getListaJugadas().get(j).getNombre());
					jugadas1.add(aux);
				}
				if(Carga.listaJugadores.get(i) instanceof Arquero){
					obj.put("Aerquero", jugadas1);
					jugador1 = nombre1;
				}else{
					obj.put("Delantero", jugadas1);
					jugador2 = nombre1;
				}
			}else if(nombre2.equals(Carga.listaJugadores.get(i).getNombre())){
				for (int j=0;j<Carga.listaJugadores.get(i).getListaJugadas().size();j++){
					JSONObject aux = new JSONObject();
					aux.put("jugada",Carga.listaJugadores.get(i).getListaJugadas().get(j).getNombre());
					jugadas2.add(aux);
				}
				if(Carga.listaJugadores.get(i) instanceof Arquero){
					obj.put("Aerquero", jugadas2);
					jugador1 = nombre2;
				}else{
					obj.put("Delantero", jugadas2);
					jugador2 = nombre2;
				}
			}
		}
		
		return obj.toString();
	}
	@GET
	@Path("/finalizar")
	@Produces(MediaType.TEXT_PLAIN)
	public String Finalizar(@QueryParam("nombre1") String nombre1,@QueryParam("nombre2") String nombre2){
		for(int i =0;i<Carga.listaJugadores.size();i++){
			if(nombre1.equals(Carga.listaJugadores.get(i).getNombre())){
				Carga.listaJugadores.get(i).setUso(false);
				for (int j = 0;j<Carga.listaJugadores.get(i).getListaJugadas().size();j++){
					Carga.listaJugadores.get(i).getListaJugadas().get(j).setUso(false);
				}
			}else if(nombre2.equals(Carga.listaJugadores.get(i).getNombre())){
				Carga.listaJugadores.get(i).setUso(false);
				for (int j = 0;j<Carga.listaJugadores.get(i).getListaJugadas().size();j++){
					Carga.listaJugadores.get(i).getListaJugadas().get(j).setUso(false);
				}
			}
		}
		Primitivsjugadas.pos.O=0;
		Primitivsjugadas.pos.x=0;
		Primitivsjugadas.pos.y=0;
		return "Partido finalizado";
	}
}
