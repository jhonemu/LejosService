package api.futbol.Services;



import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.futbol.JsonGestor.JsonJugadores;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.jugador.Arquero;
import api.futbol.jugador.Delantero;

@Path("/jugador")
public class InfJugador {
	@GET
	@Path("/agregar")
	@Produces(MediaType.TEXT_PLAIN)
	public String agregar(@QueryParam("nombrejugador")String nombrejugador,@QueryParam("nombrejugada")String nombrejugada){
		ArrayList<JugadaCompleja> list = new ArrayList<>();
		for(int i = 0; i<Carga.listaJugadores.size();i++){
			if (nombrejugador.equals(Carga.listaJugadores.get(i).getNombre())){
				list = Carga.listaJugadores.get(i).getListaJugadas();
				for (int j = 0 ; j<Carga.listaJugadasComplejas.size();j++){
					if(nombrejugada.equals(Carga.listaJugadasComplejas.get(j).getNombre())){
						list.add(Carga.listaJugadasComplejas.get(j));
					}
				}
				Carga.listaJugadores.get(i).setListaJugadas(list);
			}
		}
		new JsonJugadores().Escribe();
		return "Jugador editado";
	}
	@GET
	@Path("/quitar")
	@Produces(MediaType.TEXT_PLAIN)
	public String quitar(@QueryParam("nombrejugador")String nombrejugador,@QueryParam("nombrejugada")String nombrejugada){
		ArrayList<JugadaCompleja> list = new ArrayList<>();
		for(int i = 0; i<Carga.listaJugadores.size();i++){
			if (nombrejugador.equals(Carga.listaJugadores.get(i).getNombre())){
				list = Carga.listaJugadores.get(i).getListaJugadas();
				for (int j = 0 ; j < list.size();j++){
					if(nombrejugada.equals(list.get(j).getNombre())){
						list.remove(j);
					}
				}
				Carga.listaJugadores.get(i).setListaJugadas(list);
			}
		}
		new JsonJugadores().Escribe();
		return "Jugada removida de este jugador";
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultar(){
		JSONObject jugadores = new JSONObject();
		JSONArray lista = new JSONArray();
		for (int i = 0 ;i<Carga.listaJugadores.size();i++){
			JSONObject aux = new JSONObject();
			aux.put("nombre", Carga.listaJugadores.get(i).getNombre());
			lista.add(aux);
		}
		jugadores.put("jugadores", lista);
		return jugadores.toString();
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	public String informacion(@QueryParam("nombre")String nombre){
		JSONObject a = new JSONObject();
		for(int i = 0;i<Carga.listaJugadores.size();i++){
			if(nombre.equals(Carga.listaJugadores.get(i).getNombre())){
				a.put("nombre",Carga.listaJugadores.get(i).getNombre());
				a.put("posicion",Carga.listaJugadores.get(i).getPosicion());
				if(Carga.listaJugadores.get(i).getPosicion().equals("Arquero")){
					a.put("tiempo sin gol",( ((Arquero) Carga.listaJugadores.get(i)).getTiempoSinGoles()));
					a.put("dorsal",((Arquero) Carga.listaJugadores.get(i)).getDorsal());
				}else{
					a.put("goles marcados",( ((Delantero) Carga.listaJugadores.get(i)).golesMarcados));
					a.put("dorsal",((Delantero) Carga.listaJugadores.get(i)).getDorsal());
				}
				break;
			}
		}
		return a.toString();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/arqueros")
	@Produces(MediaType.APPLICATION_JSON)
	public String Arqueros(){
		JSONObject arqueros = new JSONObject();
		JSONArray lista = new JSONArray();
		for (int i = 0 ;i<Carga.listaJugadores.size();i++){
			if(Carga.listaJugadores.get(i) instanceof Arquero){
				JSONObject aux = new JSONObject();
				aux.put("nombre", Carga.listaJugadores.get(i).getNombre());
				lista.add(aux);
			}
		}
		arqueros.put("arqueros", lista);
		return arqueros.toString();
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/delanteros")
	@Produces(MediaType.APPLICATION_JSON)
	public String Delanteros(){
		JSONObject delanteros = new JSONObject();
		JSONArray lista = new JSONArray();
		for (int i = 0 ;i<Carga.listaJugadores.size();i++){
			if(Carga.listaJugadores.get(i) instanceof Delantero){
				JSONObject aux = new JSONObject();
				aux.put("nombre", Carga.listaJugadores.get(i).getNombre());
				lista.add(aux);
			}
		}
		delanteros.put("arqueros", lista);
		return delanteros.toString();
	}
	@POST
	@Path("/crea")
	@Produces(MediaType.TEXT_PLAIN)
	public String crear(@QueryParam("nombre")String nombre,@QueryParam("posicion")String posicion,@QueryParam("dorsal")String dorsal,@QueryParam("jugada1")String jugada1,@QueryParam("jugada2")String jugada2,@QueryParam("jugada3")String jugada3){
		String estado = "no existe";
		ArrayList<JugadaCompleja> list = new ArrayList<>();
		for (int i = 0;i<Carga.listaJugadores.size();i++){
			if(nombre.equals(Carga.listaJugadores.get(i).getNombre())){
				estado = "existe";
			}
		}
		if(estado.equals("existe")){
			return "El jugador ya existe";
		}
		else{
			for(int i = 0; i<Carga.listaJugadasComplejas.size();i++){
				if(jugada1.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
					list.add(Carga.listaJugadasComplejas.get(i));
				}else if(jugada2.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
					list.add(Carga.listaJugadasComplejas.get(i));
				}else if(jugada3.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
					list.add(Carga.listaJugadasComplejas.get(i));
				}
			}
			if(posicion.equals("Arquero")){
				Carga.listaJugadores.add(new Arquero(nombre,"Arquero",0,Byte.valueOf(dorsal),list));
				new JsonJugadores().Escribe();
				
			}else if(posicion.equals("Delantero")){
				Carga.listaJugadores.add(new Delantero(nombre,"Delantero",(short)0,Byte.valueOf(dorsal),list));
				new JsonJugadores().Escribe();
			}
		return "Jugador creado exitosamente";
		}
		
	}
	@DELETE
	@Path("eliminar")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminar(@QueryParam("nombre")String nombre){
		
		for(int i = 0 ; i<Carga.listaJugadores.size();i++){
			if(Carga.listaJugadores.get(i).getNombre().equals(nombre)){
			  if(Carga.listaJugadores.get(i).getUso() == false){
				Carga.listaJugadores.remove(i);
			  }
			  else{
				  return "El jugador se encuentra en uso y no puede ser eliminado";
			  }
			}
		}
		new JsonJugadores().Escribe();
		return "Jugador eliminado";
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/jugadas")
	@Produces(MediaType.APPLICATION_JSON)
	public String Jugadas(@QueryParam("nombre")String nombre){
		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();
		ArrayList<JugadaCompleja> lista = new ArrayList<>();
		for (int i=0;i<Carga.listaJugadores.size();i++){
			if(Carga.listaJugadores.get(i).getNombre().equals(nombre)){
				lista = Carga.listaJugadores.get(i).getListaJugadas();
			}
		}
		for(int i=0 ;i<lista.size();i++){
			JSONObject aux = new JSONObject();
			aux.put("Jugada", lista.get(i).getNombre());
			list.add(aux);
		}
		obj.put("jugadas", list);
		return obj.toString();
	}

}
