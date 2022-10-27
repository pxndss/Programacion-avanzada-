
public class Supermercado {

	private String nombre;
	private String rol;
	private String ciudad;
	private String direccion;
	
	public Supermercado(String nombre, String rol, String ciudad, String direccion) {
		this.nombre = nombre;
		this.rol = rol;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getRol() {
		return rol;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	
	
}
