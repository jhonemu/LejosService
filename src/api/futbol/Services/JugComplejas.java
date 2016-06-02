package api.futbol.Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.futbol.JsonGestor.JsonJugadasComplejas;
import api.futbol.JsonGestor.JsonJugadores;
import api.futbol.jugadasComplejas.JugadaCompleja;
import api.futbol.jugadasComplejas.JugadaComplejaDefensiva;
import api.futbol.jugadasComplejas.JugadaComplejaOfensiva;
import api.futbol.jugadasComplejas.JugadaComplejaTiroLibre;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;
import lejos.nxt.Motor;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTCommandConnector;


@Path("/jcomplejas")
public class JugComplejas {
	@GET
	@Path("/agregar")
	@Produces(MediaType.TEXT_PLAIN)
	public String agregar(@QueryParam("nombrejugada")String nombrejugada,@QueryParam("nombrejug")String nombrejug){
		ArrayList<JugadaPrimitiva> list = new ArrayList<>();
		for(int i=0;i<Carga.listaJugadasComplejas.size();i++){
			if(nombrejugada.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
				
				list = Carga.listaJugadasComplejas.get(i).getJugada();
				if(nombrejug.equals("Trotar")){
					list.add(Primitivsjugadas.trotar);
					
				}else if(nombrejug.equals("Correr")){
					list.add(Primitivsjugadas.correr);
				}else if(nombrejug.equals("Girar a la izquierda")){
					list.add(Primitivsjugadas.izquierda);
				}else if(nombrejug.equals("Girar a la derecha")){
					list.add(Primitivsjugadas.derecha);
				}else if(nombrejug.equals("Chute")){
					list.add(Primitivsjugadas.chutar);
				}else if(nombrejug.equals("Patear")){
					list.add(Primitivsjugadas.patear);
				}else if(nombrejug.equals("Ir atras")){
					list.add(Primitivsjugadas.atras);
				}else if(nombrejug.equals("Correr atras")){
					list.add(Primitivsjugadas.ratras);
				}
				Carga.listaJugadasComplejas.get(i).setJugada(list);
			}
			
		}
		new JsonJugadasComplejas().Escribe();
		return "Jugada Editada";
	}
	@GET
	@Path("/quitar")
	@Produces(MediaType.TEXT_PLAIN)
	public String quitar(@QueryParam("nombrejugada")String nombrejugada,@QueryParam("nombrejug")String nombrejug){
		ArrayList<JugadaPrimitiva> list = new ArrayList<>();
		for(int i=0;i<Carga.listaJugadasComplejas.size();i++){
			if(nombrejugada.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
				
				list = Carga.listaJugadasComplejas.get(i).getJugada();
				for(int j =0 ;j<list.size();j++){
					if(list.get(j).getNombre().equals(nombrejug)){
						list.remove(j);
					}
				}
				Carga.listaJugadasComplejas.get(i).setJugada(list);
			}
			
		}
		new JsonJugadasComplejas().Escribe();
		return "Jugada Editada";
	}
	
	@GET
	@Path("ejecutar")
	@Produces(MediaType.TEXT_PLAIN)
	public String ejecutar(@QueryParam("nombre")String nombre,@QueryParam("nombrejug")String nombrejug){
		NXTCommandConnector.setNXTCommand(new NXTCommand(Conect.conn.getNXTComm()));
		for(int i = 0 ; i<Carga.listaJugadasComplejas.size();i++){
			if(nombre.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
				Carga.listaJugadasComplejas.get(i).ejecutar();
			}
		}
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(Partido.fich,true));
			bw.newLine();
			bw.write(nombrejug + "," + nombre);
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return Primitivsjugadas.pos.x.toString()+","+Primitivsjugadas.pos.y.toString();
	}
	@GET
	@Path("parar")
	@Produces(MediaType.TEXT_PLAIN)
	public String parar(){
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();
		return Primitivsjugadas.pos.x.toString()+","+Primitivsjugadas.pos.y.toString();
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarjugadas(){
		JSONObject obj = new JSONObject();
		JSONArray names = new JSONArray();
		
		for (int i = 0 ; i< Carga.listaJugadasComplejas.size();i++){
			JSONObject aux = new JSONObject();
			aux.put("Nombre jugada", Carga.listaJugadasComplejas.get(i).getNombre());
			names.add(aux);
		}
		obj.put("Jugadas", names);
		//listaJugadasComplejas.clear();
		return obj.toString();
		
	}
	
	@POST
	@Path("/crea")
	@Produces(MediaType.TEXT_PLAIN)
	public String crear(@QueryParam("tipo")String tipo,@QueryParam("nombre")String nombre,@QueryParam("fecha")String fecha,@QueryParam("autor")String autor,@QueryParam("jugada")String jugada,@QueryParam("jugada1")String jugada1,@QueryParam("jugada2")String jugada2,@QueryParam("jugada3")String jugada3,@QueryParam("jugada4")String jugada4,@QueryParam("jugada5")String jugada5,@QueryParam("jugada6")String jugada6,@QueryParam("jugada7")String jugada7,@QueryParam("jugada8")String jugada8,@QueryParam("jugada9")String jugada9,@QueryParam("explicacion")String explicacion){
		ArrayList<String> aux = new ArrayList<>();
		ArrayList<JugadaPrimitiva> list = new ArrayList<>();
		
		String estado = null;
		for (int i = 0;i<Carga.listaJugadasComplejas.size();i++){
			if(Carga.listaJugadasComplejas.get(i).getNombre().equals(nombre)){
				estado = "ya existe";
				break;
			}
			else{
				estado = "no existe";
			}
		}
		if(estado.equals("no existe")){
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
			
			Carga.listaJugadasComplejas.add(new JugadaComplejaOfensiva(nombre,fecha,(UsuarioAdministrador) Carga.listaUsuarios.get(autor),list,explicacion));
		}else if(tipo.equals("Jugada Defensiva")){
			
			Carga.listaJugadasComplejas.add(new JugadaComplejaDefensiva(nombre,fecha,(UsuarioAdministrador) Carga.listaUsuarios.get(autor),list,explicacion));
		}else if(tipo.equals("Jugada TiroLibre")){
			
			Carga.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nombre,fecha,(UsuarioAdministrador) Carga.listaUsuarios.get(autor),list,explicacion));
		}
		
	
		new JsonJugadasComplejas().Escribe();
		//LoginUsuario.listaUsuarios.clear();
		//listaJugadasComplejas.clear();
		return"Jugada creada con exito";}
		else{
			//listaJugadasComplejas.clear();
			return "La Jugada ya existe";
		}
	}
	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminar(@QueryParam("nombre")String jugada){
		
		for(int i = 0 ;i< Carga.listaJugadasComplejas.size();i++){
			if(Carga.listaJugadasComplejas.get(i).getNombre().equals(jugada)){
				if(Carga.listaJugadasComplejas.get(i).getUso() ==false){
				Carga.listaJugadasComplejas.remove(i);
				}else{
					return "La jugada se encuentra en uso y no puede ser eliminada";
				}
			}
		}
		for ( int i =0; i<Carga.listaJugadores.size();i++){
			
			ArrayList <JugadaCompleja>  lista = Carga.listaJugadores.get(i).getListaJugadas();
			for (int j = 0 ; j<lista.size();j++){
				if(lista.get(j).getNombre().equals(jugada)){
					lista.remove(j);
				}
			}
			Carga.listaJugadores.get(i).setListaJugadas(lista);
		}
		new JsonJugadasComplejas().Escribe();
		new JsonJugadores().Escribe();
		//listaJugadasComplejas.clear();
		return "jugada eliminada";
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/explicacion")
	@Produces(MediaType.APPLICATION_JSON)
	public String exp(@QueryParam("nombre")String nombre){
		JSONObject a = new JSONObject();
		for(int i = 0;i<Carga.listaJugadasComplejas.size();i++){
			
			if(nombre.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
				a.put("nombre",Carga.listaJugadasComplejas.get(i).getNombre());
				a.put("fecha", Carga.listaJugadasComplejas.get(i).getfechaCreacion());
				a.put("auto", Carga.listaJugadasComplejas.get(i).getAutor().getNombre());
				a.put("expli",Carga.listaJugadasComplejas.get(i).getExplicacion());
				
				break;
			}
		}
		return a.toString();
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/jugadas")
	@Produces(MediaType.APPLICATION_JSON)
	public String jugadas(@QueryParam("nombre")String nombre){
		JSONObject obj = new JSONObject();
		JSONArray lista = new JSONArray();
		for (int i=0;i<Carga.listaJugadasComplejas.size();i++){
			if(nombre.equals(Carga.listaJugadasComplejas.get(i).getNombre())){
				for(int j =0;j<Carga.listaJugadasComplejas.get(i).getJugada().size();j++){
					JSONObject aux = new JSONObject();
					aux.put("jugada", Carga.listaJugadasComplejas.get(i).getJugada().get(j).getNombre());
					lista.add(aux);
				}
			}
		}
		obj.put("jugada", lista);
		return obj.toString();
	}
}				
