
public class ListaBodegas {

	private Bodega listaBodegas[];
	private int cantBodegas;
	private int max;
	
	public ListaBodegas(int max) {
	
		listaBodegas = new Bodega[max];
		cantBodegas = 0;
		this.max = max;
	}
	
	public boolean agregarBodega(Bodega bodega) {
		if(cantBodegas < max) {
			listaBodegas[cantBodegas] = bodega;
			cantBodegas++;
			return true;
		}else {
			return false;
		}
	}
	
	//Busca una bodega por el nombre de la bodega
	public Bodega buscarBodega(String bodega) {
		int i;
		for(i=0; i<cantBodegas; i++) {
			if(listaBodegas[i].getBodega().equals(bodega)) {
				break;
			}
		}
		
		if(i == cantBodegas) {
			return null;
		}else {
			return listaBodegas[i];
		}
	}
	
	//Busca una bodega por el supermercado
	public Bodega buscarBodega(Supermercado supermercado) {
		
		int i;
		for(i = 0; i < cantBodegas; i++) {
			if(listaBodegas[i].getSuper().getRol().equals(supermercado.getRol())) {
				break;
			}
		}
		
		if(i == cantBodegas) {
			return null;
		}else {
			return listaBodegas[i];
		}
		
	}
	
	public int getCantSuper() {
		return cantBodegas;
	}
	
	public String imprimir() {
		String ls = "";
		
		for(int i = 0; i < cantBodegas; i++) {
			ls = ls + "\nBodega["+i+"]" + 
					  "\nNombre: " + listaBodegas[i].getBodega() + 
					  "\nSupermercado: " + listaBodegas[i].getSuper().getNombre() + 
					  "\nRol: " + listaBodegas[i].getSuper().getRol() + 
					  "\nDireccion: " + listaBodegas[i].getSuper().getDireccion() + 
					  "\nCiudad: " + listaBodegas[i].getSuper().getCiudad() + 
					  "\n***********";
		}
		
		return ls;
	}
	

	
}
