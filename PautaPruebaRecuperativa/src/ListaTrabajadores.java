
public class ListaTrabajadores {
	private int cant, max;
	private Trabajador[] listaTrabajadores;

	public ListaTrabajadores(int max) {
		this.max = max;
		this.cant = 0;
		this.listaTrabajadores = new Trabajador[max];
	}

	public int getCant() {
		return cant;
	}

	public int getMax() {
		return max;
	}

	public Trabajador getTrabajador(int i) {
		return listaTrabajadores[i];
	}

	public boolean ingresarTrabajador(Trabajador t) {
		if (cant >= max) {
			return false;
		} else {
			this.listaTrabajadores[cant] = t;
			cant++;
			return true;
		}
	}

	public Trabajador buscarTrabajador(String codigo) {
		for (int i = 0; i < cant; i++) {
			if (this.listaTrabajadores[i].getCodigo().equalsIgnoreCase(codigo)) {
				return this.listaTrabajadores[i];
			}
		}

		return null;
	}
}
