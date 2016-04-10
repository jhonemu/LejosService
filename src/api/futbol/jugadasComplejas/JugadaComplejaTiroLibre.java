package api.futbol.jugadasComplejas;

import java.util.ArrayList;

import api.futbol.jugadasPrimitivas.Chutar;
import api.futbol.jugadasPrimitivas.JugadaPrimitiva;
import api.futbol.usuario.UsuarioAdministrador;



public class JugadaComplejaTiroLibre extends JugadaCompleja {
	
	private int potenciachute;
	private int efecto;
	private String descripcion;
	
	
	public JugadaComplejaTiroLibre(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> jugada,String Explicacion){
		super(nombreJugada,fechaCreacion,Autor,jugada,Explicacion);
		JugadaPrimitiva y = super.getJugada().get(super.getJugada().size()-1);
		if(y instanceof Chutar){
			this.potenciachute=y.getPotencia();
			this.efecto=((Chutar) y).getGradosChute();
			this.descripcion = "La jugada " + nombreJugada +" es un "+ getPotenciachute() +", con un " +getEfecto()+ ", fue creada por " + Autor.getNombre() + ", en la fecha " + fechaCreacion;
		}
		else{
			throw new ClassCastException();
		}
	}
	@Override
 	public String identificarJugada() {
		return "Jugada Tiro Libre";
	}
	public String getPotenciachute(){
		if(potenciachute>0 && potenciachute <=1){
			return "chute suave";
		}

		else{
			return"chute fuerte";
		}
	}
	public String getEfecto(){
		if(efecto>=18 && efecto<25){
			return "chute directo";
		}
		else if (efecto>=25 && efecto<35){
			return "tiro medio hacia arriba";
		}
		else if(efecto>=35){
			return "tiro vaselina";
		}
		else{
			return "tiro sin efecto";
		}
	}
	public String getDescripcion(){
		return descripcion;
	}
	public int getNumPotencia(){
		return potenciachute;
	}
	public int getNumEfecto(){
		return efecto;
	}
}
