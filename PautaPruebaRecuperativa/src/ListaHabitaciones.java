
public class ListaHabitaciones {
	private int cant, max;
	private Habitacion[] listaHabitaciones;

	public ListaHabitaciones(int max) {
		this.max = max;
		this.cant = 0;
		this.listaHabitaciones = new Habitacion[max];
	}

	public int getCant() {
		return cant;
	}

	public int getMax() {
		return max;
	}

	public Habitacion getHabitacion(int i) {
		return listaHabitaciones[i];
	}

	public boolean ingresarHabitacion(Habitacion h) {
		if (cant >= max) {
			return false;
		} else {
			this.listaHabitaciones[cant] = h;
			cant++;
			return true;
		}
	}

	public Habitacion buscarHabitacion(int numero) {
		for (int i = 0; i < cant; i++) {
			if (this.listaHabitaciones[i].getNumeroHabitacion() == numero) {
				return this.listaHabitaciones[i];
			}
		}

		return null;
	}
}
