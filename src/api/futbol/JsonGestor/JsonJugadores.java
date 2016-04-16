package api.futbol.JsonGestor;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.futbol.Services.InfJugador;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugador.Arquero;
import api.futbol.jugador.Delantero;

public class JsonJugadores {
	@SuppressWarnings("unchecked")
	public void Escribe() {
		JSONObject object = new JSONObject();
		JSONArray arqueros =  new JSONArray();
		JSONArray delanteros = new JSONArray();
	
		for(int i = 0;i<InfJugador.listaJugadores.size();i++){
			JSONObject ob = new JSONObject();
			JSONArray aux = new JSONArray();
			ArrayList<JugadaCompleja> JugadaC = new ArrayList<>();
			
				ob.put("Nombre", InfJugador.listaJugadores.get(i).getNombre());
				ob.put("Posicion",InfJugador.listaJugadores.get(i).getPosicion());
				JugadaC = InfJugador.listaJugadores.get(i).getListaJugadas();
				for(int j = 0 ; j<JugadaC.size();j++){
					JSONObject at = new JSONObject();
					at.put("Jugada", JugadaC.get(j).getNombre());
					aux.add(at);
				}
				ob.put("Jugadas Complejas",aux);
				if(InfJugador.listaJugadores.get(i) instanceof Arquero){
					ob.put("Tiempo Sin gol",((Arquero) InfJugador.listaJugadores.get(i)).getTiempoSinGoles());
					ob.put("Dorsal",((Arquero) InfJugador.listaJugadores.get(i)).getDorsal());
					arqueros.add(ob);
				}
				else if(InfJugador.listaJugadores.get(i) instanceof Delantero){
					ob.put("Goles Marcados", (((Delantero) InfJugador.listaJugadores.get(i)).getGolesMarcados()));
					ob.put("Dorsal", (((Delantero) InfJugador.listaJugadores.get(i)).getDorsal()));
					delanteros.add(ob);
				}
			
		}
		try {
			object.put("Arqueros", arqueros);
			object.put("Delanteros", delanteros);
			FileWriter fil = new FileWriter("C:\\Users\\Public\\Documents\\JsonJugadores.json");
			fil.write(object.toString());
			fil.flush();
			fil.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void Lee(){
		JSONParser parser = new JSONParser();
		try {
			Object obj =parser.parse(new FileReader("C:\\Users\\Public\\Documents\\JsonJugadores.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray arqueros=(JSONArray) jsonObject.get("Arqueros");
			JSONArray delanteros=(JSONArray) jsonObject.get("Delanteros");
			if(arqueros.size()>0){
				for(int i = 0;i<arqueros.size();i++){
					
				}
			}
			if(delanteros.size()>0){
				for(int i = 0;i<arqueros.size();i++){
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
