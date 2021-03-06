package api.futbol.usuario;

public class UsuarioGeneral implements Usuario {
	private String nombre;
	private String clave;
	
	public UsuarioGeneral(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
	}
	
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String getClave() {
		return clave;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

}