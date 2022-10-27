import java.util.Date;
import java.util.Scanner;

public class AppVuelaAlto {

	public static void main(String[] args) {
	
		//Declaracion de Listas 
		ListaAeropuertos listaAeropuertos = new ListaAeropuertos(100);
		ListaPasajeros   listaPasajeros   = new ListaPasajeros(100);
		ListaTickets     listaTickets     = new ListaTickets(100);
		ListaVuelos      listaVuelos      = new ListaVuelos(100);
		c:\Users\Savka\Downloads\VuelaAlto\VuelaAlto\src\AppVuelaAlto.java
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**** Sistema de Vuelos 'Vuela Alto' ****");
		
		System.out.println("**** Crear Aeropuertos ****");
		crearAeropuertos(listaAeropuertos);
		
		System.out.println("**** Crear Vuelo ****");
		crearVuelo(listaAeropuertos, listaVuelos);
			
		System.out.println("**** Desplegando Menu ****");
		int op = 0;
		
		while(op != 6) {
			System.out.println("**** Menu de Opciones****");
			System.out.println("1. Vender Ticket");
			System.out.println("2. Listado de Pasajeros de un Vuelo");
			System.out.println("3. Total Ventas");
			System.out.println("4. Vuelos Disponibles");
			System.out.println("5. Top 10 Pasajeros Frecuentes");
			System.out.println("6. Salir");
			
			op = scanner.nextInt();
			
			switch(op) {
			
				case 1:  
					System.out.println("**** Venta Ticket ****");
					ventaTicket(listaPasajeros, listaTickets, listaVuelos);
					break;
				
				case 2: 
					System.out.println("**** Imprimir Pasajeros de un Vuelo ****");
					imprimirListadoPasajerosVuelo(listaVuelos);
					break;
				
				case 3:
					System.out.println("**** Total Ventas ****");
					System.out.println("Total Ventas: "+ listaTickets.getTotalVenta());
					break;
				
				case 4: 
					System.out.println("**** Vuelos Disponibles ****");
					break;
				
				case 5: 
					System.out.println("**** Top 10 ****");
					listaPasajeros.topTen();
					break;
				
				
			}	
			System.out.println(" ");
		}
		
		System.out.println("Saliendo del Sistema......");
	}
	
	public static void crearAeropuertos(ListaAeropuertos la) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de Aeropuertos:");
		int cantidad = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < cantidad; i++) {
			
			System.out.println("Ingrese los Datos para el Aeropuerto " + (i+1) + ":");
			System.out.println("Nombre del Aeropuerto: ");
			String nombre = scanner.nextLine();
			System.out.println("Ciudad: ");
			String ciudad = scanner.nextLine();
			
			Aeropuerto a = new Aeropuerto(nombre, ciudad);
			la.agregarAeropuerto(a);
		}
		
		System.out.println("Aeropuertos Creados!\n");
		
	}
	
	public static void crearVuelo(ListaAeropuertos la, ListaVuelos lv) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Imprimiendo Aeropuertos:");
		
		for(int i = 0; i < la.getCantidadAeropuertos(); i++ ) {
			System.out.println((i+1) + "." + la.getListaAeropuertos(i).getNombre() + " - " + la.getListaAeropuertos(i).getCiudad());
		}
		
		System.out.println("Cuantos vuelos desea crear:");
		int cantVuelos = scanner.nextInt();
		scanner.nextLine();
		for( int i = 0; i < cantVuelos; i++) {
			
			System.out.println("Vuelo " + (i+1));
			System.out.println("Ingrese el nombre del Aeropuerto de origen: ");
			String origen = scanner.nextLine();
			System.out.println("Ingrese el nombre del Aeropuerto de destino: ");
			String destino = scanner.nextLine();
			System.out.println("Ingrese el codigo del vuelo: ");
			String codigo = scanner.nextLine();
			System.out.println("Hola de Salida: ");
			String salida = scanner.nextLine();
			System.out.println("Hola de Llegada: ");
			String llegada = scanner.nextLine();
			
			//Creación del vuelo
			//Nota: Se debería validar que el aeropuerto ingresado exista antes de crear el objeto

			Aeropuerto aOrigen = la.buscarAeropuerto(origen);
			Aeropuerto aDestino = la.buscarAeropuerto(destino);
			
			Vuelo vuelo = new Vuelo(codigo, aOrigen, aDestino, salida, llegada); 
			lv.agregarVuelo(vuelo);
		}
		
		System.out.println("Vuelo(s) Creado(s)!\n");
	}
	
	public static void ventaTicket(ListaPasajeros lp, ListaTickets lt, ListaVuelos lv) {
		
		Scanner scanner = new Scanner(System.in);
		Vuelo v;
		
		System.out.println("Listado de Vuelos:");
		
		for(int i = 0; i < lv.getCantVuelos(); i++) {
			System.out.println((i+1) + ". Codigo de Vuelo: " + lv.getVuelo(i).getCodigo());
		}
		
		System.out.println("Ingrese el Codigo del Vuelo para Venta:");
		String codigo = scanner.nextLine();
		
		v = lv.buscarVuelo(codigo); 	 
		
		while(v == null) { //validar que el codigo del vuelo exista
			System.out.println("** Codigo de Vuelo erroneo **");
			System.out.println("Ingrese el Codigo del Vuelo para Venta:");
			codigo = scanner.nextLine();
			v = lv.buscarVuelo(codigo);
		}
		
		System.out.println("Vuelo Encontrado!");
		System.out.println("Ingrese Rut del Pasajero:");
		String rut = scanner.nextLine();
		
		//Buscar si el Pasajero existe:
		Pasajero p;
		
		if(lp.buscarPasajero(rut) != null) {//El pasajero existe
			p = lp.buscarPasajero(rut);
			System.out.println("Pasajero Encontrado. Registro del Pasajero:");
			
			System.out.println("Nombre: " + lp.buscarPasajero(rut).getNombre() + " Correo: " + lp.buscarPasajero(rut).getEmail() );
			lp.buscarPasajero(rut).sumarViaje(); //aumentamos el contador de Viajes
			
			if(lp.buscarPasajero(rut).getCantViajes() >= 2) { //Esta condición no está especificada en el problema 
															  //Pero si tiene 2 o más viajes será un viajero frecuente
				lp.buscarPasajero(rut).setFrecuente(true);
			}
			
		}else {
			
			System.out.println("Pasajero No Encontrado. Registro del Pasajero:");
			System.out.println("Ingrese Nombre del Pasajero:");
			String nombre = scanner.nextLine();
			System.out.println("Ingrese Email del Pasajero:");
			String email = scanner.nextLine();
			p = new Pasajero(rut, nombre, email, false);
			lp.agregarPasajero(p);
			lp.buscarPasajero(rut).sumarViaje();
		}
		
		//Ticket
		System.out.println("Datos del Ticket:");
		System.out.println("Ingrese codigo del Ticket:");
		String codTicket = scanner.nextLine();
		System.out.println("Ingrese Valor del Ticket:");
		int valor = Integer.parseInt(scanner.nextLine());
		Date fecha = new Date();
		TicketVuelo tv = new TicketVuelo(codTicket, fecha, valor, p, v);
		lt.agregarTicket(tv);
		
		v.setListaPasajeros(lp);
		System.out.println("Ticket Vendido!.");
		
		//String imprimir = v.getListaPasajeros().imprimir();
		//System.out.println(imprimir);

	}
 
	public static void imprimirListadoPasajerosVuelo(ListaVuelos lv) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Listado de Vuelos:");
		
		for(int i = 0; i < lv.getCantVuelos(); i++) {
			System.out.println((i+1) + ". Codigo de Vuelo: " + lv.getVuelo(i).getCodigo());
		}
		
		System.out.println("Ingrese el Codigo del Vuelo para Imprimir Pasajeros:");
		String codigo = scanner.nextLine();
		
		Vuelo v = lv.buscarVuelo(codigo); 
		while(v == null) { 
			System.out.println("** Codigo de Vuelo Erroneo **");
			System.out.println("Ingrese el Codigo del Vuelo para Imprimir Pasajeros:");
			codigo = scanner.nextLine();
			v = lv.buscarVuelo(codigo);
		}
		
		System.out.println("Vuelo Encontrado! Imprimiendo Pasajeros");
		String lista = lv.buscarVuelo(codigo).getListaPasajeros().imprimir();
		System.out.println(lista);
		
	}
	
	public static void imprimirVuelosDisponibles(ListaVuelos lv) {
		
		System.out.println("Listado de Vuelos Disponibles:");
		for(int i = 0; i < lv.getCantVuelos(); i++) {
			
			System.out.println((i+1) + ". Codigo de Vuelo: " + lv.getVuelo(i).getCodigo());
			
		}
	}
	
	
}
