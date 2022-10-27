
public class ListaProductos {

	private Producto listaProductos[];
	private int cantProd;
	private int max;
	
	public ListaProductos(int max) {
	
		listaProductos = new Producto[max];
		cantProd = 0;
		this.max = max;
	}
	
	public boolean agregarProducto(Producto producto) {
		if(cantProd < max) {
			listaProductos[cantProd] = producto;
			cantProd++;
			return true;
		}else {
			return false;
		}
	}
		
	public int getCantProd() {
		return cantProd;
	}
	
	public String imprimir() {
		String lp = "";
		
		for(int i = 0; i < cantProd; i++) {
			lp = lp + "\nProducto["+i+"]" + 
					  "\nProducto: " + listaProductos[i].getProducto() + 
					  "\nValor Compra: " + listaProductos[i].getCompra() + 
					  "\nCantidad de Productos: " + listaProductos[i].getCantidad()+ 
					  "\nValor Venta: " + listaProductos[i].getVenta() +
					  "\nDia que Ingreso: " + listaProductos[i].getIngreso() +
					  "\nDia de Caducidad: " + listaProductos[i].getCaducidad() +
					  "\n***********";
		}
		
		return lp;
	}
	
	public String imprimir(Bodega bodega) {
		String lp = "";
		
		for(int i = 0; i < cantProd; i++) {
			
			//Obtener los productos de la bodega recibida por parametro
			if(	listaProductos[i].getBodega().getBodega().equals( bodega.getBodega() ) ) {
								 //Producto   //Bodega            //Parametro Bodega
				
				lp = lp +  "\nProducto: " + listaProductos[i].getProducto() + 
						  "\nValor Compra: " + listaProductos[i].getCompra() + 
						  "\nCantidad de Productos: " + listaProductos[i].getCantidad()+ 
						  "\nValor Venta: " + listaProductos[i].getVenta() +
						  "\nFecha Ingreso: " + listaProductos[i].getIngreso() +
						  "\nFecha Caducidad: " + listaProductos[i].getCaducidad() +
						  "\n***********";
			}
		}
		return lp;
	}
	
	public void ordenarListaProductos() {
		
		for(int i = 0; i < cantProd; i++) {
			for(int j = i+1; j < cantProd; j++) {
				
				if(listaProductos[i].getIngreso() > listaProductos[j].getIngreso()) {
					Producto temporal = listaProductos[i];
					listaProductos[i] = listaProductos[j];
					listaProductos[j] = temporal;
				}
			}
		}
	}
		
	//Busca un producto de una Bodega
	public Producto buscarProductoBodega(Bodega bodega, String producto) {
		int i;
		for(i = 0; i < cantProd; i++) {
			
			if( listaProductos[i].getBodega().getBodega().equals( bodega.getBodega()) //Existe la Bodega
					&& listaProductos[i].getProducto().equals(producto)) { 			  //Existe el Producto
						
				break;
			}
		}
		
		if(i == cantProd) {
			return null;
		}else {
			return listaProductos[i];
		}		
	}
	
	//Busca el producto y verifica las condiciones para la venta, si las condiciones se cumplen se retorna el producto, sino, no.
	public Producto buscarProducto(Bodega bodega, String producto, int cantidad, int diaVenta) {
		int i;
		for(i = 0; i < cantProd; i++) {
			
			if( listaProductos[i].getBodega().getBodega().equals( bodega.getBodega()) //Existe la Bodega
					&& listaProductos[i].getProducto().equals(producto) 			  //Existe el Producto
						&&listaProductos[i].getIngreso() <= diaVenta				  //El producto fue almacenado antes de la venta
							&& listaProductos[i].getCaducidad() > diaVenta 			  //El Producto no está caducado
								&& listaProductos[i].getCantidad() > 0 ) {			  //Hay Stock del producto
				break;
			}
		}
		
		if(i == cantProd) {
			return null;
		}else {
			return listaProductos[i];
		}		
	}
	
	
	
	
}

