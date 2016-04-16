package api.futbol.Services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class Aplication extends Application {
	//public static NXTConnector conn = new NXTConnector();
	public Set<Class<?>> getClasses(){
		 Set<Class<?>> classes = new HashSet<>();
		//classes.add(lejos.pc.comm.NXTConnector.class);
		 classes.add(api.futbol.Services.First.class);
		 classes.add(api.futbol.Services.LoginUsuario.class);
		 classes.add(api.futbol.Services.Conect.class);
		 classes.add(api.futbol.Services.InfJugador.class);
		 classes.add(api.futbol.Services.Primitivsjugadas.class);
		 classes.add(api.futbol.Services.JugComplejas.class);
		 return classes;
	}
}
