
public class Vuelo {

	private String codigo;
	private Aeropuerto origen;
	private Aeropuerto destino;
	private String salida;
	private String llegada;
	private ListaPasajeros listaPasajeros;
	
	public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, String salida, String llegada) {
	
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.salida = salida;
		this.llegada = llegada;
	}
	
	//gets y sets
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setListaPasajeros(ListaPasajeros listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}
	
	public ListaPasajeros getListaPasajeros() {
		return listaPasajeros;
	}
	
	//etc. xd
	
	
}
