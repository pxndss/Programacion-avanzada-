
public class Habitacion {
	private int numeroHabitacion;
	private int valorDia;
	private String tipo;

	public Habitacion(int numeroHabitacion, int valorDia, String tipo) {
		this.numeroHabitacion = numeroHabitacion;
		this.valorDia = valorDia;
		this.tipo = tipo;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getValorDia() {
		return valorDia;
	}

	public void setValorDia(int valorDia) {
		this.valorDia = valorDia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Habitacion [numeroHabitacion=" + numeroHabitacion + ", valorDia=" + valorDia + ", tipo=" + tipo + "]";
	}

}
