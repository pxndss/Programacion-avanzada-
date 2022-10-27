
public class ListaPasajeros {

	private Pasajero listaPasajeros[];
	private int cantPasajeros;
	private int max;
	
	ListaPasajeros(int max){
		
		listaPasajeros = new Pasajero[max];
		cantPasajeros = 0;
		this.max = max;
	}
	
	public boolean agregarPasajero(Pasajero pasajero) {
		
		if(cantPasajeros < max) {
			listaPasajeros[cantPasajeros] = pasajero;
			cantPasajeros++;
			return true;
		}else {
			
			return false;
		}
		
	}
	
	public Pasajero buscarPasajero(String rut) {
	
		int i;
		for(i=0; i<cantPasajeros; i++) {
			if(listaPasajeros[i].getRut().equals(rut)) {
				break;
			}
		}
		
		if(i == cantPasajeros) {
			return null;
		}else {
			return listaPasajeros[i];
		}
	
	}
		
	public boolean eliminarPasajero(String rut) {
		
		int i;
		for(i=0; i<cantPasajeros; i++) {
			if(listaPasajeros[i].getRut().equals(rut)) {
				break;
			}
		}
		
		if(i == cantPasajeros) {
			return false;
			
		}else {
			
			for(int j=i; j<cantPasajeros-1; j++) {
				listaPasajeros[j] = listaPasajeros[j+1];
			}
			cantPasajeros--;
			return true;
		}

	}
	
	public String imprimir() {
		String lp = "";
		for(int i=0; i<cantPasajeros; i++) {
			
			lp = lp + "\nPasajero["+i+"] "+ 
					  "\nNombre: "    + listaPasajeros[i].getNombre() + 
					  "\nRut: "       + listaPasajeros[i].getRut() + 
					  "\nEmail: "     + listaPasajeros[i].getEmail() +
					  "\nFrecuente: " + listaPasajeros[i].getFrecuente() +
					  "\n*********";
		}
		
		return lp;
	}
	
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	
	public void topTen() {
		
		Pasajero listaOrdenada[] = new Pasajero[max];
		
		//Guardar todos los "frecuentes"
		int k = 0;
		for(int i = 0; i < cantPasajeros; i++) {
			if(listaPasajeros[i].getFrecuente()) {
				listaOrdenada[k] = listaPasajeros[i];
				k++;
			}
		}
		
				
		for(int i = 0; i < k; i++) {
			for(int j = i+1; j < k; j++) {
				
				if(listaOrdenada[i].getCantViajes()<=listaOrdenada[j].getCantViajes()) {
					Pasajero temporal = listaOrdenada[i];
					listaOrdenada[i] = listaOrdenada[j];
					listaOrdenada[j] = temporal;
				}
				
			}
		}
		
		for(int i = 0; i < k; i++) {
			System.out.println(i+1 + "." + listaOrdenada[i].getNombre() + " " + 
									       listaOrdenada[i].getRut() + 
									       " Cantidad de Viajes: " + listaOrdenada[i].getCantViajes());
		}
		
	}
	
}
