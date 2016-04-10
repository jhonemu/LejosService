package api.futbol.JsonGestor;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import api.futbol.Services.InfJugador;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugador.Arquero;
import api.futbol.jugador.Delantero;

public class JsonJugadores {
	public void Escribe() {
		/*JSONObject object = new JSONObject();
		JSONArray arqueros =  new JSONArray();
		JSONArray delanteros = new JSONArray();
		
		int i = 0;
		while(InfJugador.listaJugadores.size()>0){
			JSONObject ob = new JSONObject();
			JSONObject p = new JSONObject();
			JSONArray jug = new JSONArray();
			ArrayList<JugadaCompleja> jugadasc = new ArrayList<>();
			if(InfJugador.listaJugadores.get(i) instanceof Arquero){
				try {
					ob.put("nombre", InfJugador.listaJugadores.get(i).getNombre());
					ob.put("pocision", InfJugador.listaJugadores.get(i).getPosicion());
					jugadasc = InfJugador.listaJugadores.get(i).getListaJugadas();
					for(int j = 0; j < jugadasc.size();j++){
						p.put("jugada", jugadasc.get(j).getNombre());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			else if(InfJugador.listaJugadores.get(i) instanceof Delantero){
				
			}
		}*/
	}
	
	public void Lee(){
		
	}
}
