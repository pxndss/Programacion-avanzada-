
public class ListaClientes {
	private int cant, max;
	private Cliente[] listaClientes;

	public ListaClientes(int max) {
		this.max = max;
		this.cant = 0;
		this.listaClientes = new Cliente[max];
	}

	public int getCant() {
		return cant;
	}

	public int getMax() {
		return max;
	}

	public Cliente getCliente(int i) {
		return listaClientes[i];
	}

	public boolean ingresarCliente(Cliente c) {
		if (cant >= max) {
			return false;
		} else {
			this.listaClientes[cant] = c;
			cant++;
			return true;
		}
	}

	public Cliente buscarCliente(String codigo) {
		for (int i = 0; i < cant; i++) {
			if (this.listaClientes[i].getCodigo().equalsIgnoreCase(codigo)) {
				return this.listaClientes[i];
			}
		}

		return null;
	}
}
