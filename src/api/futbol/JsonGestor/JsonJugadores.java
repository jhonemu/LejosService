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

import api.futbol.Services.Carga;
import api.futbol.Services.InfJugador;
import api.futbol.Services.JugComplejas;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugador.Arquero;
import api.futbol.jugador.Delantero;

public class JsonJugadores {
	@SuppressWarnings("unchecked")
	public void Escribe() {
		JSONObject object = new JSONObject();
		JSONArray arqueros =  new JSONArray();
		JSONArray delanteros = new JSONArray();
	
		for(int i = 0;i<Carga.listaJugadores.size();i++){
			JSONObject ob = new JSONObject();
			JSONArray aux = new JSONArray();
			ArrayList<JugadaCompleja> JugadaC = new ArrayList<>();
			
				ob.put("Nombre", Carga.listaJugadores.get(i).getNombre());
				ob.put("Posicion",Carga.listaJugadores.get(i).getPosicion());
				JugadaC = Carga.listaJugadores.get(i).getListaJugadas();
				for(int j = 0 ; j<JugadaC.size();j++){
					JSONObject at = new JSONObject();
					at.put("Jugada", JugadaC.get(j).getNombre());
					aux.add(at);
				}
				ob.put("Jugadas Complejas",aux);
				if(Carga.listaJugadores.get(i) instanceof Arquero){
					ob.put("Tiempo Sin gol",((Arquero) Carga.listaJugadores.get(i)).getTiempoSinGoles());
					ob.put("Dorsal",((Arquero) Carga.listaJugadores.get(i)).getDorsal());
					arqueros.add(ob);
				}
				else if(Carga.listaJugadores.get(i) instanceof Delantero){
					ob.put("Goles Marcados", (((Delantero) Carga.listaJugadores.get(i)).getGolesMarcados()));
					ob.put("Dorsal", (((Delantero) Carga.listaJugadores.get(i)).getDorsal()));
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
					String nombre;
					String posicion;
					String tiemposingol;
					String dorsal;
					ArrayList<JugadaCompleja> list = new ArrayList<>();
					JSONObject aux = (JSONObject) arqueros.get(i);
					nombre = (String) aux.get("Nombre");
					posicion = (String) aux.get("Posicion");
					tiemposingol = (String) aux.get("Tiempo Sin gol");
					dorsal = (String) aux.get("Dorsal");
					JSONArray jcom = (JSONArray) aux.get("Jugadas Complejas");
					//new JsonJugadasComplejas().Lee();
					for(int j=0;j<jcom.size();j++){
						JSONObject aux2 = (JSONObject) jcom.get(j);
						for(int k =0;k<Carga.listaJugadasComplejas.size();k++){
							if(Carga.listaJugadasComplejas.get(k).getNombre().equals(aux2.get("Jugada"))){
								list.add(Carga.listaJugadasComplejas.get(k));
							}
						}
					}
					//Carga.listaJugadasComplejas.clear();
					Carga.listaJugadores.add(new Arquero(nombre,posicion,Integer.valueOf(tiemposingol),Byte.valueOf(dorsal),list));
				}
			}
			if(delanteros.size()>0){
				for(int i = 0;i<delanteros.size();i++){
					String nombre;
					String posicion;
					String golesmarcados;
					String dorsal;
					ArrayList<JugadaCompleja> list = new ArrayList<>();
					JSONObject aux = (JSONObject) delanteros.get(i);
					nombre = (String) aux.get("Nombre");
					posicion = (String) aux.get("Posicion");
					golesmarcados = (String) aux.get("Goles Marcados");
					dorsal = (String) aux.get("Dorsal");
					JSONArray jcom = (JSONArray) aux.get("Jugadas Complejas");
					//new JsonJugadasComplejas().Lee();
					for(int j=0;j<jcom.size();j++){
						JSONObject aux2 = (JSONObject) jcom.get(j);
						for(int k =0;k<Carga.listaJugadasComplejas.size();k++){
							if(Carga.listaJugadasComplejas.get(k).getNombre().equals(aux2.get("Jugada"))){
								list.add(Carga.listaJugadasComplejas.get(k));
							}
						}
					}
					//JugComplejas.listaJugadasComplejas.clear();
					Carga.listaJugadores.add(new Delantero(nombre,posicion,Short.valueOf(golesmarcados),Byte.valueOf(dorsal),list));
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
