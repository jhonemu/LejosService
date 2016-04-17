package api.futbol.JsonGestor;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import api.futbol.Services.JugComplejas;
import api.futbol.Services.LoginUsuario;
import api.futbol.Services.Primitivsjugadas;
import api.futbol.jugadasComplejas.JugadaComplejaDefensiva;
import api.futbol.jugadasComplejas.JugadaComplejaOfensiva;
import api.futbol.jugadasComplejas.JugadaComplejaTiroLibre;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;

public class JsonJugadasComplejas {
	@SuppressWarnings("unchecked")
	public void Escribe(){
		JSONObject object = new JSONObject();
		JSONArray ofencivas = new JSONArray();
		JSONArray defencivas = new JSONArray();
		JSONArray tirolibre = new JSONArray();

		for (int i = 0;i<JugComplejas.listaJugadasComplejas.size();i++){
			JSONObject ob = new JSONObject();

			JSONArray aux = new JSONArray();
			ArrayList<JugadaPrimitiva> Jugadap = new ArrayList<>();
			ob.put("Nombre", JugComplejas.listaJugadasComplejas.get(i).getNombre());
			ob.put("Fecha", JugComplejas.listaJugadasComplejas.get(i).getfechaCreacion());
			ob.put("Autor", JugComplejas.listaJugadasComplejas.get(i).getAutor().getNombre());
			ob.put("Explicacion",JugComplejas.listaJugadasComplejas.get(i).getExplicacion());
			Jugadap = JugComplejas.listaJugadasComplejas.get(i).getJugada();
			for(int j = 0;j<Jugadap.size();j++){
				JSONObject at = new JSONObject();
				at.put("nombre", Jugadap.get(j).getNombre());
				aux.add(at);
			}
			ob.put("Jugadas Primitivas", aux);
			if(JugComplejas.listaJugadasComplejas.get(i) instanceof JugadaComplejaOfensiva){
				String ef = ((JugadaComplejaOfensiva) JugComplejas.listaJugadasComplejas.get(i)).getEfectividad();
				ob.put("Efectividad", ef);
				ofencivas.add(ob);
			}
			else if(JugComplejas.listaJugadasComplejas.get(i) instanceof JugadaComplejaDefensiva){
				ob.put("Complejidad", (((JugadaComplejaDefensiva) JugComplejas.listaJugadasComplejas.get(i)).getComplejidad()));
				defencivas.add(ob);
			}
			else if(JugComplejas.listaJugadasComplejas.get(i) instanceof JugadaComplejaTiroLibre){
				ob.put("Complejidad", (((JugadaComplejaTiroLibre) JugComplejas.listaJugadasComplejas.get(i)).getEfecto()));
				ob.put("Complejidad", (((JugadaComplejaTiroLibre) JugComplejas.listaJugadasComplejas.get(i)).getPotenciachute()));
				tirolibre.add(ob);
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
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void Lee(){
		JSONParser parser = new JSONParser();
			try {
				Object obj =parser.parse(new FileReader("C:\\Users\\Public\\Documents\\JsonJugadasComplejas.json"));
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray jof=(JSONArray) jsonObject.get("Jugadas Ofencivas");
				JSONArray jtl=(JSONArray) jsonObject.get("Jugadas Tiro Libre");
				JSONArray jdf=(JSONArray) jsonObject.get("Jugadas Defencivas");
				if(jof.size()>0){
					for(int i=0;i<jof.size();i++){
						String nombre;
						String fecha;
						String explicacion;
						UsuarioAdministrador us;
						JSONObject aux = (JSONObject) jof.get(i);
						JSONArray jpri = (JSONArray) aux.get("Jugadas Primitivas");
						nombre =(String) aux.get("Nombre");
						fecha = (String) aux.get("Fecha");
						new JsonUsuario().Lee();
						us = (UsuarioAdministrador) LoginUsuario.listaUsuarios.get(aux.get("Autor"));
						LoginUsuario.listaUsuarios.clear();
						explicacion = (String) aux.get("Explicacion");
						ArrayList<JugadaPrimitiva> list = new ArrayList<>();
						
						for(int j=0;j<jpri.size();j++){
							JSONObject aux2 = (JSONObject) jpri.get(j);
							if(Primitivsjugadas.atras.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.atras);
							}
							else if(Primitivsjugadas.chutar.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.chutar);
							}
							else if(Primitivsjugadas.correr.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.correr);
							}
							else if(Primitivsjugadas.derecha.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.derecha);
							}
							else if(Primitivsjugadas.izquierda.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.izquierda);
							}
							else if(Primitivsjugadas.patear.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.patear);
							}
							else if(Primitivsjugadas.ratras.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.ratras);
							}
							else if(Primitivsjugadas.trotar.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.trotar);
							}
						}
						JugComplejas.listaJugadasComplejas.add(new JugadaComplejaOfensiva(nombre,fecha,us,list,explicacion));
					}
				}
				if(jdf.size()>0){
					for(int i=0;i<jdf.size();i++){
						String nombre;
						String fecha;
						String explicacion;
						UsuarioAdministrador us;
						JSONObject aux = (JSONObject) jdf.get(i);
						JSONArray jpri = (JSONArray) aux.get("Jugadas Primitivas");
						nombre =(String) aux.get("Nombre");
						fecha = (String) aux.get("Fecha");
						new JsonUsuario().Lee();
						us = (UsuarioAdministrador) LoginUsuario.listaUsuarios.get(aux.get("Autor"));
						LoginUsuario.listaUsuarios.clear();
						explicacion = (String) aux.get("Explicacion");
						ArrayList<JugadaPrimitiva> list = new ArrayList<>();
						
						for(int j=0;j<jpri.size();j++){
							JSONObject aux2 = (JSONObject) jpri.get(j);
							if(Primitivsjugadas.atras.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.atras);
							}
							else if(Primitivsjugadas.chutar.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.chutar);
							}
							else if(Primitivsjugadas.correr.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.correr);
							}
							else if(Primitivsjugadas.derecha.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.derecha);
							}
							else if(Primitivsjugadas.izquierda.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.izquierda);
							}
							else if(Primitivsjugadas.patear.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.patear);
							}
							else if(Primitivsjugadas.ratras.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.ratras);
							}
							else if(Primitivsjugadas.trotar.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.trotar);
							}
						}
						JugComplejas.listaJugadasComplejas.add(new JugadaComplejaDefensiva(nombre,fecha,us,list,explicacion));
					}
				}
				if(jtl.size()>0){
					for(int i=0;i<jtl.size();i++){
						String nombre;
						String fecha;
						String explicacion;
						UsuarioAdministrador us;
						JSONObject aux = (JSONObject) jtl.get(i);
						JSONArray jpri = (JSONArray) aux.get("Jugadas Primitivas");
						nombre =(String) aux.get("Nombre");
						fecha = (String) aux.get("Fecha");
						new JsonUsuario().Lee();
						us = (UsuarioAdministrador) LoginUsuario.listaUsuarios.get(aux.get("Autor"));
						LoginUsuario.listaUsuarios.clear();
						explicacion = (String) aux.get("Explicacion");
						ArrayList<JugadaPrimitiva> list = new ArrayList<>();
						
						for(int j=0;j<jpri.size();j++){
							JSONObject aux2 = (JSONObject) jpri.get(j);
							if(Primitivsjugadas.atras.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.atras);
							}
							else if(Primitivsjugadas.chutar.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.chutar);
							}
							else if(Primitivsjugadas.correr.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.correr);
							}
							else if(Primitivsjugadas.derecha.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.derecha);
							}
							else if(Primitivsjugadas.izquierda.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.izquierda);
							}
							else if(Primitivsjugadas.patear.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.patear);
							}
							else if(Primitivsjugadas.ratras.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.ratras);
							}
							else if(Primitivsjugadas.trotar.getNombre().equals(aux2.get("nombre"))){
								list.add(Primitivsjugadas.trotar);
							}
						}
						JugComplejas.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nombre,fecha,us,list,explicacion));
					}
				}
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
	}
}
