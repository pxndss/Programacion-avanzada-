
public class ListaAeropuertos {

	private Aeropuerto listaAeropuertos[];
	private int cantAeropuertos;
	private int max;
	
	public ListaAeropuertos(int max) {
		listaAeropuertos = new Aeropuerto[max];
		cantAeropuertos = 0;
		this.max = max;
	}
	
	public Aeropuerto buscarAeropuerto(String nombre) {
		
		int i;
		for(i=0; i<cantAeropuertos; i++) {
			if(listaAeropuertos[i].getNombre().equals(nombre)) {
				break;
			}
		}
		
		if(i == cantAeropuertos) {
			return null;
		}else {
			return listaAeropuertos[i];
		}
	
	}
	
	public boolean agregarAeropuerto(Aeropuerto aeropuerto) {
		
		if(cantAeropuertos < max) {
			listaAeropuertos[cantAeropuertos] = aeropuerto;
			cantAeropuertos++;
			return true;
		}else {
			
			return false;
		}
		
	}
	
	public boolean eliminarAeropuerto(String nombre) {
		
		int i;
		for(i=0; i<cantAeropuertos; i++) {
			if(listaAeropuertos[i].getNombre().equals(nombre)) {
				break;
			}
		}
		
		if(i == cantAeropuertos) {
			return false;
			
		}else {
			
			for(int j=i; j<cantAeropuertos-1; j++) {
				listaAeropuertos[j] = listaAeropuertos[j+1];
			}
			cantAeropuertos--;
			return true;
		}

	}
	
	public int getCantidadAeropuertos() {
		return cantAeropuertos;
	}
	
	public Aeropuerto getListaAeropuertos(int i) {
		
		return listaAeropuertos[i];
	}
	
}
