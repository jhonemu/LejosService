package api.futbol.JsonGestor;


import api.futbol.Services.LoginUsuario;
import api.futbol.usuario.Usuario;
import api.futbol.usuario.UsuarioAdministrador;
import api.futbol.usuario.UsuarioGeneral;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;


import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonUsuario {
	public void Escribe(){
		Usuario usuario;
		JSONObject Object = new JSONObject();
		JSONArray general = new JSONArray();
		JSONArray administradores = new JSONArray();
		Enumeration<Usuario> usuarios = LoginUsuario.listaUsuarios.elements();
		while(usuarios.hasMoreElements()){
			JSONObject Ob = new JSONObject();
			usuario = usuarios.nextElement();
			if(usuario instanceof UsuarioGeneral){
				usuario = (UsuarioGeneral)usuario;
				try {
					Ob.put(usuario.getNombre(),usuario.getClave());
					general.put(Ob);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			else if(usuario instanceof UsuarioAdministrador){
				usuario = (UsuarioAdministrador)usuario;
				try {
					Ob.put(usuario.getNombre(),usuario.getClave());
					administradores.put(Ob);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			Object.put("Usuarios Administradores", administradores);
			Object.put("Usuarios Generales", general);
			
		
			FileWriter fil = new FileWriter("C:\\Users\\Public\\Documents\\JsonUs.json");
			fil.write(Object.toString());
			fil.flush();
			fil.close();
		} catch (JSONException | IOException  e) {
			e.printStackTrace();
		}

	}


	public void Lee(){
		JsonFactory jfactory = new JsonFactory();
		try {
			JsonParser jParser = jfactory.createJsonParser(new File("C:\\Users\\Public\\Documents\\JsonUs.json"));
			jParser.nextToken();
			while(jParser.getText() != null){
				if(jParser.getText().equals("Usuarios Administradores")){
					int i=0;
					String usuario = null;
					String clave;
					while(jParser.nextToken() != JsonToken.END_ARRAY){

						if(!jParser.getText().equals("{") && !jParser.getText().equals("}") &&!jParser.getText().equals("}")&&!jParser.getText().equals("[")){
							if(i%2 ==0){
								usuario = jParser.getText();
								i++;
							}
							else{
								clave = jParser.getText();
								i++;
								LoginUsuario.listaUsuarios.put(usuario, new UsuarioAdministrador(usuario,clave));
							}
						}
					}

				}
				else if(jParser.getText().equals("Usuarios Generales")){
					int i=0;
					String usuario = null;
					String clave;
					while(jParser.nextToken() != JsonToken.END_ARRAY){
						if(!jParser.getText().equals("{") && !jParser.getText().equals("}") &&!jParser.getText().equals("}")&&!jParser.getText().equals("[")){
							if(i%2 ==0){
								usuario = jParser.getText();
								i++;
							}
							else{
								clave = jParser.getText();
								i++;
								LoginUsuario.listaUsuarios.put(usuario, new UsuarioGeneral(usuario,clave));
							}
						}
					}
				}
				jParser.nextToken();

			}


		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}}