
public class ListaVentas {

	private Venta listaVentas[];
	private int cantVentas;
	private int max;
	
	public ListaVentas(int max) {
		
		listaVentas = new Venta[max];
		cantVentas = 0;
		this.max = max;
		
	}
	
	public boolean agregarVenta(Venta venta) {
		if(cantVentas < max) {
			listaVentas[cantVentas] = venta;
			cantVentas++;
			return true;
		}else {
			return false;
		}
	}
	
	public String imprimir() {
		String ls = "";
		
		for(int i = 0; i < cantVentas; i++) {
			ls = ls + "\nVenta["+i+"]" + 
					  "\nSupermercado: " + listaVentas[i].getSupermercado().getNombre() + " Direccion: " + listaVentas[i].getSupermercado().getDireccion() +
					  "\nProducto: " + listaVentas[i].getProducto().getProducto() +
					  "\nCantidad: " + listaVentas[i].getCantidadVendida() +
					  "\nTotal Venta: " + listaVentas[i].getTotalVenta() +
					  "\n***********";
		}
		
		return ls;
	}
}
