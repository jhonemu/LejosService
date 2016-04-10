package api.futbol.JsonGestor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import api.futbol.Services.JugComplejas;
import api.futbol.Services.LoginUsuario;
import api.futbol.jugadasComplejas.JugadaComplejaDefensiva;
import api.futbol.jugadasComplejas.JugadaComplejaOfensiva;
import api.futbol.jugadasComplejas.JugadaComplejaTiroLibre;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;

public class JsonJugadasComplejas {
	public void Escribe(){
		JSONObject object = new JSONObject();
		JSONArray ofencivas = new JSONArray();
		JSONArray defencivas = new JSONArray();
		JSONArray tirolibre = new JSONArray();
		
		for (int i = 0;i<JugComplejas.listaJugadasComplejas.size();i++){
			JSONObject ob = new JSONObject();
			
			JSONArray aux = new JSONArray();
			ArrayList<JugadaPrimitiva> Jugadap = new ArrayList<>();
			try {
				ob.put("Nombre", JugComplejas.listaJugadasComplejas.get(i).getNombre());
				ob.put("Fecha", JugComplejas.listaJugadasComplejas.get(i).getfechaCreacion());
				ob.put("Autor", JugComplejas.listaJugadasComplejas.get(i).getAutor().getNombre());
				ob.put("Explicacion",JugComplejas.listaJugadasComplejas.get(i).getExplicacion());
				Jugadap = JugComplejas.listaJugadasComplejas.get(i).getJugada();
				for(int j = 0;j<Jugadap.size();j++){
					JSONObject at = new JSONObject();
					at.put("nombre", Jugadap.get(i).getNombre());
					aux.put(at);
				}
				ob.put("Jugadas Primitivas", aux);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(JugComplejas.listaJugadasComplejas.get(i) instanceof JugadaComplejaOfensiva){
				String ef = ((JugadaComplejaOfensiva) JugComplejas.listaJugadasComplejas.get(i)).getEfectividad();
				try {
					ob.put("Efectividad", ef);
					ofencivas.put(ob);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			else if(JugComplejas.listaJugadasComplejas.get(i) instanceof JugadaComplejaDefensiva){
				try {
					ob.put("Complejidad", (((JugadaComplejaDefensiva) JugComplejas.listaJugadasComplejas.get(i)).getComplejidad()));
					defencivas.put(ob);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			else if(JugComplejas.listaJugadasComplejas.get(i) instanceof JugadaComplejaTiroLibre){
				try {
					ob.put("Complejidad", (((JugadaComplejaTiroLibre) JugComplejas.listaJugadasComplejas.get(i)).getEfecto()));
					ob.put("Complejidad", (((JugadaComplejaTiroLibre) JugComplejas.listaJugadasComplejas.get(i)).getPotenciachute()));
					tirolibre.put(ob);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			object.put("Jugadas Ofencivas" , ofencivas);
			object.put("Jugadas Defencivas", defencivas);
			object.put("Jugadas Tiro Libre", tirolibre);
			FileWriter fil = new FileWriter("C:\\Users\\Public\\Documents\\JsonJugadasComplejas.json");
			fil.write(object.toString());
			fil.flush();
			fil.close();
		} catch (JSONException | IOException e) {
			
			e.printStackTrace();
		}
	}
	public void Lee(){
		
		JsonFactory jfactory = new JsonFactory();
		try {
			JsonParser jParser = jfactory.createJsonParser(new File("C:\\Users\\Public\\Documents\\JsonJugadasComplejas.json"));
			jParser.nextToken();
			while(jParser.getText() != null){
				if(jParser.getText().equals("Jugadas Ofencivas")){
					jParser.nextToken();
					jParser.nextToken();
					String nombre = null;
					String fech = null;
					UsuarioAdministrador autor = null;
					String explicacion = null;
					ArrayList<JugadaPrimitiva> list;
					String efectividad;
					int i = 0;
					while(jParser.nextToken() != JsonToken.START_ARRAY){
						if(jParser.nextToken()!=JsonToken.START_ARRAY){
							if(i == 0){
								nombre = jParser.getText();
								i++;
							}else if (i==1){
								fech = jParser.getText();
										i++;
							}else if(i==2){
								new JsonUsuario().Lee();
								autor = (UsuarioAdministrador) LoginUsuario.listaUsuarios.get(jParser.getText());
								 
								 i++;
							}else if(i ==3){
								explicacion = jParser.getText();
								i++;
							}
						}
						else{
							break;
						}
					}
					System.out.println(jParser.getText());
				}
				else if(jParser.getText().equals("Jugadas Defencivas")){
					
				}
				
				else if(jParser.getText().equals("Jugadas Tiro Libre")){
	
				}

				jParser.nextToken();
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
