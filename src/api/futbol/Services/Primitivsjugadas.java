package api.futbol.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import api.futbol.jugadasPrimitivas.Adelante;
import api.futbol.jugadasPrimitivas.Atras;
import api.futbol.jugadasPrimitivas.Chutar;
import api.futbol.jugadasPrimitivas.Derecha;
import api.futbol.jugadasPrimitivas.Izquierda;
import lejos.nxt.Motor;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTCommandConnector;

@Path("/jprimitivas")
public class Primitivsjugadas {
	public static Adelante trotar = new Adelante("Trotar",360);
	public static Adelante correr = new Adelante("Correr",720);
	public static Izquierda izquierda = new Izquierda("Girar a la izquierda",720);
	public static Derecha derecha = new Derecha("Girar a la derecha",720);
	public static Chutar chutar = new Chutar("Chute",720,40);
	public static Chutar patear  = new Chutar("Patear",1440,40);
	public static Atras atras = new Atras("Ir atras",720);
	public static Atras ratras = new Atras("Correr atras",1440);
	
	@GET
	@Path("/jugada")
	@Produces(MediaType.TEXT_PLAIN)
	public String infjugada(@QueryParam("jugada")String jugada,@QueryParam("cont")String cont){
		NXTCommandConnector.setNXTCommand(new NXTCommand(Conect.conn.getNXTComm()));
		if(jugada.equals("Trote")){
			if(Integer.valueOf(cont)%2 == 0){
				trotar.Iniciar();
				System.out.println( Motor.A.getRotationCount());
				
			}
			else{
				trotar.Detener();
			}
		}
		else if(jugada.equals("Correr")){
			if(Integer.valueOf(cont)%2 == 0){
				correr.Iniciar();
			}
			else{
				correr.Detener();
			}
			
		}
		else if(jugada.equals("Izquierda")){
			
		}
		else if(jugada.equals("Derecha")){
			
		}
		else if(jugada.equals("Atras")){
			
		}
		else if(jugada.equals("Correr Atras")){
		
		}
		else if(jugada.equals("Chute")){
			
		}
		else if(jugada.equals("Patear")){
			
		}
		return "y";
	}
	
}
