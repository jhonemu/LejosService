package api.futbol.Services;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import api.futbol.JsonGestor.JsonUsuario;

import api.futbol.usuario.UsuarioAdministrador;
import api.futbol.usuario.UsuarioGeneral;


@Path("/LoginUs")

public class LoginUsuario {
	@GET
	@Path("/confirmar")
	@Produces(MediaType.TEXT_PLAIN)
	public String Confirmar(@QueryParam("username") String username, @QueryParam("password") String password) {
		
		if(Carga.listaUsuarios.containsKey(username)){
	
			if(Carga.listaUsuarios.get(username).getClave().equals(password)){
				if(Carga.listaUsuarios.get(username) instanceof UsuarioAdministrador){
					String s =Carga.listaUsuarios.get(username).getNombre();
					//listaUsuarios.clear();
					return s;
				}
				else{
					//listaUsuarios.clear();
					return  "Usuario General";
				}
			}
			else{
				//listaUsuarios.clear();
				return "Usuario no valido";
			}
		}
		else{
			//listaUsuarios.clear();
			return "Usuario no valido";
		}
	}

	@POST
	@Path("/registro")
	@Consumes(MediaType.TEXT_PLAIN)
	public String registro(@QueryParam("username") String username, @QueryParam("password") String password){
		
		if(Carga.listaUsuarios.containsKey(username)){
			//listaUsuarios.clear();
			return "El nombre de usuario ya esta en uso";
		}
		else{
			Carga.listaUsuarios.put(username, new UsuarioGeneral(username,password));
			new JsonUsuario().Escribe();
			//listaUsuarios.clear();
			return "Usuario registrado";
		}
	}
	
	@POST
	@Path("/radmin")
	@Consumes(MediaType.TEXT_PLAIN)
	public String RegistroAdmin(@QueryParam("username") String username,@QueryParam("password") String password){
		
		if(Carga.listaUsuarios.containsKey(username)){
			//listaUsuarios.clear();
			return "El nombre de usuario ya esta en uso";
		}
		else{
			Carga.listaUsuarios.put(username, new UsuarioAdministrador(username,password));
			new JsonUsuario().Escribe();
		//listaUsuarios.clear();
			return "Nuevo Administrador Registrado";
		}
	}
}
