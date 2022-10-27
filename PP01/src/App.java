import java.io.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args){
		
		//Creación de Listas
		ListaSupermercados listaSuper     = new ListaSupermercados(100);
		ListaBodegas       listaBodegas   = new ListaBodegas(100);
		ListaProductos     listaProductos = new ListaProductos(200);
		ListaVentas 	   listaVentas    = new ListaVentas(100);
				
		leerSuper(listaSuper);
		leerBodegas(listaSuper, listaBodegas, listaProductos);				
		
		Scanner scanner = new Scanner(System.in); 
		int op = 0;
		
		while(op != 5) {
			System.out.println("Menu");
			System.out.println("---------------");
			System.out.println("1.Listar Supermercados");
			System.out.println("2.Listado de Bodega con el Supermercado Correspondiente");
			System.out.println("3.Listado de Productos");
			System.out.println("4.Listado de Productos Ordenados (FIFO)");
			System.out.println("5.Producos en Bodega");
			System.out.println("6.Ejecutar Simulacion de Venta");
			System.out.println("7.Listado de Ventas");
			System.out.println("Ingrese una opcion:");
			op = scanner.nextInt();
			
			switch(op) {
			
			case 1: 
					System.out.println("***** Lista de Supermercados *****");
					String markets = listaSuper.imprimir();
					System.out.println(markets);
				break;
			
			case 2:
					System.out.println("***** Listado de Bodegas con su Supermercado *****");
					String bodegas = listaBodegas.imprimir();
					System.out.println(bodegas);
				break;
				
			case 3:
					System.out.println("***** Listado de Productos (Sin Ordenar) *****");
					String productos = 	listaProductos.imprimir();
					System.out.println(productos);
				break;
				
			case 4:
					System.out.println("***** Listado de Productos (Ordenados) *****");
					listaProductos.ordenarListaProductos();
					String productosOrdenados = listaProductos.imprimir();
					System.out.println(productosOrdenados);
				break;
				
			case 5:
					obtenerProductos(listaSuper, listaBodegas, listaProductos);
				break;
			
			case 6: 
					System.out.println("***** Ejecutando Simulacion de Venta *****");
					simularVenta(listaSuper, listaBodegas, listaProductos, listaVentas);
				break;
				
			case 7: 
					System.out.println("***** Listado de Ventas *****");
					String venta = listaVentas.imprimir();
					System.out.println(venta);
				break;
			}
			
		}
		
	}//Fin Main
	
	//Lee el archivo de texto "Supermercados"
	public static void leerSuper(ListaSupermercados listaSuper) {
	
		try {
			
			Scanner read = new Scanner(new File("Supermercados.txt"));
			while(read.hasNextLine()) {
				
				String linea     = read.nextLine();
				String datos[]   = linea.split(",");
				String nombre    = datos[0];
				String rol       = datos[1];
				String ciudad    = datos[2];
				String direccion = datos[3];
				
				//Agregar el Supermercado a la Lista
				Supermercado s  = new Supermercado(nombre, rol, ciudad, direccion);
				listaSuper.agregarSuper(s);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Lee el archivo de texto "Bodegas"
	public static void leerBodegas(ListaSupermercados listaSuper, ListaBodegas listaBodegas, ListaProductos listaProductos) {
	
		try {
			Scanner read = new Scanner(new File("Bodegas.txt"));
			
			while(read.hasNextLine()) {
					
				String linea     = read.nextLine();
				String datos[]   = linea.split(",");
				String bodega    = datos[0];
				String rolSuper  = datos[1];
				String producto  = datos[2];
				int compra       = Integer.parseInt(datos[3]);
				int cantidad     = Integer.parseInt(datos[4]);
				int venta        = Integer.parseInt(datos[5]);
				int ingreso      = Integer.parseInt(datos[6]);
				int caducidad    = Integer.parseInt(datos[7]);
				
				//Buscar el supermercado y verificar que exista en el listado de supermercados
				Supermercado s = listaSuper.buscarSuper(rolSuper);
				Bodega b;
				Producto p;
				
				if(s != null) {
					
					//Buscar y/o Verificar que no se haya creado anteriormente la bodega
					b = listaBodegas.buscarBodega(bodega);
					
					if(b == null) { //Se crea la bodega y se agrega a la listaBodegas
						b = new Bodega(bodega, s);	
						listaBodegas.agregarBodega(b);
					}
					
					//Se crea el producto y se agrega a la listaProductos
					p = new Producto(producto, compra, venta, cantidad, ingreso, caducidad, b);
					listaProductos.agregarProducto(p);			
		
				}
				
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	//Obtener los productos de una bodega de un supermercado 
	public static void obtenerProductos(ListaSupermercados listaSuper, ListaBodegas listaBodegas, ListaProductos listaProductos) {
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Ingrese el Rol de un Supermercado: ");
		String rol = scanner.nextLine();
		
		Supermercado s = listaSuper.buscarSuper(rol);
		
		if(s != null) {
			
			Bodega b = listaBodegas.buscarBodega(s);
			
			String productos = listaProductos.imprimir(b);
			System.out.println("Supermercado: " + s.getNombre() + " Rol: " + s.getRol() + " Direccion: " + s.getDireccion());
			System.out.println("Bodega: " + b.getBodega());
			System.out.println("Listado de Productos: ");
			System.out.println(productos);
			
		}else {
			System.out.println("No existe un Supermercado para el Rol ingresado.");
		}
		
	}
	
	//Lee el archivo "SimulacionVenta" y ejecuta esa simulación
	public static void simularVenta(ListaSupermercados listaSuper, ListaBodegas listaBodegas, 
										ListaProductos listaProductos, ListaVentas listaVentas) {
		
		try {
			Scanner read = new Scanner(new File("SimulacionVenta.txt"));
			
			while(read.hasNextLine()) {
				
				String linea       = read.nextLine();
				String datos[]     = linea.split(",");
				String market      = datos[0];
				String direccion   = datos[1];
				String producto    = datos[2];
				int cantidadPedida = Integer.parseInt(datos[3]);
				int diaVenta       = Integer.parseInt(datos[4]);
				
				//Buscar el Super por nombre y direccion
				Supermercado s = listaSuper.buscarSuper(market, direccion);
				if(s != null) {
					
					//Buscar la Bodega del Super
					Bodega b = listaBodegas.buscarBodega(s);
										
					//Busca el producto en la bodega
					Producto p = listaProductos.buscarProductoBodega(b, producto);
					
					//Si el producto existe
					if(p != null) {
						
						while(cantidadPedida > 0) {
																		//Condiciones para vender un producto
							Producto px = listaProductos.buscarProducto(b, producto, cantidadPedida, diaVenta); 
							if(px != null) {
								
								//Saber cuanto stock tiene
								int cantProd = px.getCantidad();
								
								if(cantidadPedida - cantProd > 0) { //Faltan Productos en stock
									
									//Acumular la venta de lo anterior
									int sumaVenta = px.getVenta() * (cantidadPedida - cantProd);
									listaProductos.buscarProducto(b, producto, cantidadPedida, diaVenta).setCantidad(0);
									
									int cantPendiente = cantidadPedida - cantProd;
									
									while(cantPendiente > 0) {
										
										Producto py = listaProductos.buscarProducto(b, producto, cantidadPedida, diaVenta);
										if(py != null) {
											
											int cantPy = py.getCantidad();
											int stock = cantPy - cantPendiente;
											
											if(cantPendiente - cantPy >= 0) {//Quedan productos por buscar
												sumaVenta = sumaVenta + py.getVenta() * cantPy;
												listaProductos.buscarProducto(b, producto, cantidadPedida, diaVenta).setCantidad(0);
												
											}else {//No me quedan productos pendientes
												sumaVenta = sumaVenta + py.getVenta() * cantPendiente;
												listaProductos.buscarProducto(b, producto, cantidadPedida, diaVenta).setCantidad(stock);
												
											}
											
											Venta v = new Venta(s, p, cantidadPedida, sumaVenta);
											listaVentas.agregarVenta(v);
											cantPendiente = cantPendiente - cantPy;
											
										}else {
											cantidadPedida = 0; //Para quebrar el primer while
											break;
										}
										
									}
									
									
								}else {//No Faltan productos 
									//Se hace la venta
									int totalVenta = px.getVenta() * cantidadPedida;
									Venta v = new Venta(s, p, cantidadPedida, totalVenta);
									listaVentas.agregarVenta(v);
									//se setea el stock
									int stock = px.getCantidad() - cantidadPedida;
									listaProductos.buscarProducto(b, producto, cantidadPedida, diaVenta).setCantidad(stock);
									cantidadPedida = 0; //para salir del while
								}
								
								
							}else {
								break;
							}
							
						}//While
						
					}//Fin P null

				}//Fin S null
				
			}//Fin While Read
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}// Fin App
