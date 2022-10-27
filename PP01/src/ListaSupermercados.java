
public class ListaSupermercados {

	private Supermercado listaSuper[];
	private int cantSuper;
	private int max;
	
	public ListaSupermercados(int max) {
	
		listaSuper = new Supermercado[max];
		cantSuper = 0;
		this.max = max;
	}
	
	public boolean agregarSuper(Supermercado supermercado) {
		if(cantSuper < max) {
			listaSuper[cantSuper] = supermercado;
			cantSuper++;
			return true;
		}else {
			return false;
		}
	}
	
	public Supermercado buscarSuper(String rol) {
		int i;
		for(i=0; i<cantSuper; i++) {
			if(listaSuper[i].getRol().equals(rol)) {
				break;
			}
		}
		
		if(i == cantSuper) {
			return null;
		}else {
			return listaSuper[i];
		}
	}
	
	public Supermercado buscarSuper(String nombre, String direccion) {
		int i;
		for(i=0; i<cantSuper; i++) {
			if(listaSuper[i].getNombre().equals(nombre) && listaSuper[i].getDireccion().equals(direccion)) {
				break;
			}
		}
		
		if(i == cantSuper) {
			return null;
		}else {
			return listaSuper[i];
		}
	}
	
	
	public int getCantSuper() {
		return cantSuper;
	}
	
	public String imprimir() {
		String ls = "";
		
		for(int i = 0; i < cantSuper; i++) {
			ls = ls + "\nSupermercado["+i+"]" + 
					  "\nNombre: " + listaSuper[i].getNombre() + 
					  "\nRol: " + listaSuper[i].getRol() + 
					  "\nDireccion: " + listaSuper[i].getDireccion() + 
					  "\nCiudad: " + listaSuper[i].getCiudad() + 
					  "\n***********";
		}
		
		return ls;
	}
	
}
