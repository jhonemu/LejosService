package api.futbol.Services;

import java.util.HashSet;
import java.util.Set;


import javax.ws.rs.core.Application;


public class Aplication extends Application {

	public Set<Class<?>> getClasses(){
		 Set<Class<?>> classes = new HashSet<>();
		 classes.add(api.futbol.Services.LoginUsuario.class);
		 classes.add(api.futbol.Services.Conect.class);
		 classes.add(api.futbol.Services.InfJugador.class);
		 return classes;
	}
}
