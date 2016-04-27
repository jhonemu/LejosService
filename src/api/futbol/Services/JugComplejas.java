package api.futbol.Services;

import java.util.ArrayList;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.JsonGestor.JsonUsuario;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugadasComplejas.JugadaComplejaDefensiva;
import api.futbol.jugadasComplejas.JugadaComplejaOfensiva;
import api.futbol.jugadasComplejas.JugadaComplejaTiroLibre;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;


@Path("/jcomplejas")
public class JugComplejas {
	
	public static ArrayList<JugadaCompleja> listaJugadasComplejas = new ArrayList<>();
	@SuppressWarnings("unchecked")
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarjugadas(){
		JSONObject obj = new JSONObject();
		JSONArray names = new JSONArray();
		new JsonJugadasComplejas().Lee();
		for (int i = 0 ; i< listaJugadasComplejas.size();i++){
			JSONObject aux = new JSONObject();
			aux.put("Nombre jugada", listaJugadasComplejas.get(i).getNombre());
			names.add(aux);
		}
		obj.put("Jugadas", names);
		return obj.toJSONString();
		
	}
	
	@POST
	@Path("/crea")
	@Produces(MediaType.TEXT_PLAIN)
	public String crear(@QueryParam("tipo")String tipo,@QueryParam("nombre")String nombre,@QueryParam("fecha")String fecha,@QueryParam("autor")String autor,@QueryParam("jugada")String jugada,@QueryParam("jugada1")String jugada1,@QueryParam("jugada2")String jugada2,@QueryParam("jugada3")String jugada3,@QueryParam("jugada4")String jugada4,@QueryParam("jugada5")String jugada5,@QueryParam("jugada6")String jugada6,@QueryParam("jugada7")String jugada7,@QueryParam("jugada8")String jugada8,@QueryParam("jugada9")String jugada9,@QueryParam("explicacion")String explicacion){
		ArrayList<String> aux = new ArrayList<>();
		ArrayList<JugadaPrimitiva> list = new ArrayList<>();
		
		System.out.println(LoginUsuario.listaUsuarios);
		aux.add(jugada);
		aux.add(jugada1);
		aux.add(jugada2);
		aux.add(jugada3);
		aux.add(jugada4);
		aux.add(jugada5);
		aux.add(jugada6);
		aux.add(jugada7);
		aux.add(jugada8);
		aux.add(jugada9);
		for(int i = 0 ;i<aux.size();i++){
			
				if(aux.get(i).equals(Primitivsjugadas.atras.getNombre())){
					list.add(Primitivsjugadas.atras);
				}else if(aux.get(i).equals(Primitivsjugadas.chutar.getNombre())){
					list.add(Primitivsjugadas.chutar);
				}else if(aux.get(i).equals(Primitivsjugadas.correr.getNombre())){
					list.add(Primitivsjugadas.correr);
				}else if(aux.get(i).equals(Primitivsjugadas.derecha.getNombre())){
					list.add(Primitivsjugadas.derecha);
				}else if(aux.get(i).equals(Primitivsjugadas.izquierda.getNombre())){
					list.add(Primitivsjugadas.izquierda);
				}else if(aux.get(i).equals(Primitivsjugadas.patear.getNombre())){
					list.add(Primitivsjugadas.patear);
				}else if(aux.get(i).equals(Primitivsjugadas.ratras.getNombre())){
					list.add(Primitivsjugadas.ratras);
				}else if(aux.get(i).equals(Primitivsjugadas.trotar.getNombre())){
					list.add(Primitivsjugadas.trotar);
				}
			
		}
		
		if(tipo.equals("Jugada Ofensiva")){
			new JsonUsuario().Lee();
			listaJugadasComplejas.add(new JugadaComplejaOfensiva(nombre,fecha,(UsuarioAdministrador) LoginUsuario.listaUsuarios.get(autor),list,explicacion));
		}else if(tipo.equals("Jugada Defensiva")){
			new JsonUsuario().Lee();
			listaJugadasComplejas.add(new JugadaComplejaDefensiva(nombre,fecha,(UsuarioAdministrador) LoginUsuario.listaUsuarios.get(autor),list,explicacion));
		}else if(tipo.equals("Jugada TiroLibre")){
			new JsonUsuario().Lee();
			listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nombre,fecha,(UsuarioAdministrador) LoginUsuario.listaUsuarios.get(autor),list,explicacion));
		}
		new JsonJugadasComplejas().Lee();
		new JsonJugadasComplejas().Escribe();
		LoginUsuario.listaUsuarios.clear();
		listaJugadasComplejas.clear();
		return"Jugada creada con exito";
	}
}				
