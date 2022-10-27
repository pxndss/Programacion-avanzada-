
public class ListaVuelos {

	private Vuelo listaVuelos[];
	private int cantVuelos;
	private int max;
	
	public ListaVuelos(int max) {
		
		listaVuelos = new Vuelo[max];
		cantVuelos = 0;
		this.max = max;	
	}
	
	public boolean agregarVuelo(Vuelo vuelo) {
		
		if(cantVuelos < max) {
			listaVuelos[cantVuelos] = vuelo;
			cantVuelos++;
			return true;
		}else {
			
			return false;
		}
		
	}
	
	public Vuelo buscarVuelo(String codigo) {
	
		int i;
		for(i=0; i<cantVuelos; i++) {
			if(listaVuelos[i].getCodigo().equals(codigo)) {
				break;
			}
		}
		
		if(i == cantVuelos) {
			return null;
		}else {
			return listaVuelos[i];
		}
	
	}
	
	public boolean eliminarVuelo(String codigo) {
		
		int i;
		for(i=0; i<cantVuelos; i++) {
			if(listaVuelos[i].getCodigo().equals(codigo)) {
				break;
			}
		}
		
		if(i == cantVuelos) {
			return false;
			
		}else {
			
			for(int j=i; j<cantVuelos-1; j++) {
				listaVuelos[j] = listaVuelos[j+1];
			}
			cantVuelos--;
			return true;
		}

	}
	
	public int getCantVuelos() {
		return cantVuelos;
	}
	
	public Vuelo getVuelo(int i) {
		return listaVuelos[i];
	}
	
	
}
