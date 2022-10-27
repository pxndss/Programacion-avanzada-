
public class ListaReservas {
	private int cant, max;
	private Reserva[] listaReservas;

	public ListaReservas(int max) {
		this.max = max;
		this.cant = 0;
		this.listaReservas = new Reserva[max];
	}

	public int getCant() {
		return cant;
	}

	public int getMax() {
		return max;
	}

	public Reserva getReserva(int i) {
		return listaReservas[i];
	}

	public boolean ingresarReserva(Reserva r) {
		if (cant >= max) {
			return false;
		} else {
			this.listaReservas[cant] = r;
			cant++;
			return true;
		}
	}

	public Reserva buscarReserva(int codigo) {
		for (int i = 0; i < cant; i++) {
			if (this.listaReservas[i].getCodigo() == codigo) {
				return this.listaReservas[i];
			}
		}

		return null;
	}

	public Boolean eliminar(int codigo) {
		int i;
		for (i = 0; i < cant; i++) {
			if (this.listaReservas[i].getCodigo() == codigo) {
				break;
			}
		}

		if (i == cant) {
			return false;
		} else {
			for (int j = i; j < cant; j++) {
				this.listaReservas[j] = listaReservas[j + 1];
			}
			cant--;
			return true;
		}
	}

	public void setReserva(Reserva reserva, int pos) {
		this.listaReservas[pos] = reserva;
	}

	public ListaReservas getListaOrdenada(ListaReservas listaReservas) {
		ListaReservas lr = listaReservas;
		for (int i = 0; i < lr.getCant() - 1; i++) {
			for (int j = 0; j < lr.getCant() - i - 1; j++) {
				Reserva r1 = lr.getReserva(j);
				Reserva r2 = lr.getReserva(j + 1);

				int fechaReserva1 = r1.getDiasFechaInicio();
				int fechaReserva2 = r2.getDiasFechaInicio();

				if (fechaReserva2 < fechaReserva1) {
					Reserva aux = r2;
					lr.setReserva(r1, j + 1);
					lr.setReserva(aux, j);
				}
			}
		}

		return lr;
	}
}
