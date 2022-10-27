
public class Pasajero {

	private String rut;
	private String nombre;
	private String email;
	private boolean frecuente;
	private int cantViajes;
	
	//Constructor
	public Pasajero(String rut, String nombre, String email, boolean frecuente) {
		
		this.rut = rut;
		this.nombre = nombre;
		this.email = email;
		this.frecuente = frecuente;
		cantViajes = 0;
	}
	
	//Metodos Set y Get
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFrecuente(boolean frecuente) {
		this.frecuente = frecuente;
	}
	
	public boolean getFrecuente() {
		return frecuente;
	}
	
	public void sumarViaje() {
		cantViajes++;
	}
	
	public int getCantViajes() {
		return cantViajes;
	}
	
	
}
