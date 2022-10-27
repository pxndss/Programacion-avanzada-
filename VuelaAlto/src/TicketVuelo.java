import java.util.Date;

public class TicketVuelo {

	private String codigo;
	private Date fecha;
	private int valor;
	private Pasajero pasajero;
	private Vuelo vuelo;
	
	public TicketVuelo(String codigo, Date fecha, int valor, Pasajero pasajero, Vuelo vuelo) {
		
		this.codigo = codigo;
		this.fecha = fecha;
		this.valor = valor;
		this.pasajero = pasajero;
		this.vuelo = vuelo;
	}

	// gets y sets
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getValor() {
		return valor;
	}
	
	//etc. :D
	
}
