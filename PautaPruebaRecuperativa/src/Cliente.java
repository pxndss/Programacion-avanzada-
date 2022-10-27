
public class Cliente {
	private String codigo;
	private String nombre;
	private String apellido;
	private String telefono;
	private ListaReservas listaReservas;

	public Cliente(String codigo, String nombre, String apellido, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.listaReservas = new ListaReservas(100);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ListaReservas getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ListaReservas listaReservas) {
		this.listaReservas = listaReservas;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ "]";
	}

}
