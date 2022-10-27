import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {

	public static void leerHabitaciones(ListaHabitaciones listaHabitaciones) throws FileNotFoundException {
		File archivo = new File("habitaciones.txt");
		Scanner scanner = new Scanner(archivo);

		while (scanner.hasNextLine()) {
			String[] data = scanner.nextLine().split(",");
			int numero = Integer.parseInt(data[0]);
			int valorDia = Integer.parseInt(data[1]);
			String tipo = data[2];

			Habitacion habitacion = new Habitacion(numero, valorDia, tipo);
			listaHabitaciones.ingresarHabitacion(habitacion);
		}

		scanner.close();
	}

	public static void leerUsuarios(ListaTrabajadores listaTrabajadores, ListaClientes listaClientes)
			throws FileNotFoundException {
		File archivo = new File("trabajadores-clientes.txt");
		Scanner scanner = new Scanner(archivo);

		while (scanner.hasNextLine()) {
			String[] data = scanner.nextLine().split(",");
			String codigo = data[0];
			String nombre = data[1];
			String apellido = data[2];
			String telefono = data[3];

			if (codigo.charAt(0) == 'C') {
				Cliente cliente = new Cliente(codigo, nombre, apellido, telefono);
				listaClientes.ingresarCliente(cliente);
			} else {
				String email = data[4];
				int sueldo = Integer.parseInt(data[5]);
				Trabajador trabajador = new Trabajador(codigo, nombre, apellido, telefono, email, sueldo);
				listaTrabajadores.ingresarTrabajador(trabajador);
			}

		}

		scanner.close();
	}

	public static void leerReservas(ListaHabitaciones listaHabitaciones, ListaReservas listaReservas,
			ListaClientes listaClientes) throws FileNotFoundException {
		File archivo = new File("reservaciones.txt");
		Scanner scanner = new Scanner(archivo);

		while (scanner.hasNextLine()) {
			String[] data = scanner.nextLine().split(",");
			int numero = Integer.parseInt(data[0]);
			String codigoCliente = data[1];
			int numeroHabitacion = Integer.parseInt(data[2]);

			int diaInicio = Integer.parseInt(data[3]);
			int mesInicio = Integer.parseInt(data[4]);
			int añoInicio = Integer.parseInt(data[5]);

			int diaFin = Integer.parseInt(data[6]);
			int mesFin = Integer.parseInt(data[7]);
			int añoFin = Integer.parseInt(data[8]);

			Cliente cliente = listaClientes.buscarCliente(codigoCliente);
			Habitacion habitacion = listaHabitaciones.buscarHabitacion(numeroHabitacion);
			if (cliente != null && habitacion != null) {
				Reserva reserva = new Reserva(numero, diaInicio, mesInicio, añoInicio, diaFin, mesFin, añoFin);
				reserva.setHabitacion(habitacion);
				reserva.setCliente(cliente);
				cliente.getListaReservas().ingresarReserva(reserva);
				listaReservas.ingresarReserva(reserva);
			}
		}

		scanner.close();
	}

	public static void menu(ListaHabitaciones listaHabitaciones, ListaReservas listaReservas,
			ListaClientes listaClientes, ListaTrabajadores listaTrabajadores) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1- realizar reserva");
		System.out.println("2- mostrar reservas por cliente");
		System.out.println("3- mostrar sueldos");
		System.out.println("4- anular reserva");
		System.out.println("5- mostar reservas ordenadas");
		System.out.println("6- salir");
		System.out.print("ingrese una opcion: ");
		int opcion = scanner.nextInt();
		while (opcion != 6) {
			switch (opcion) {
			case 1:
				generarReserva(listaHabitaciones, listaReservas, listaClientes, scanner);
				break;
			case 2:
				mostrarReserva(listaClientes, scanner);
				break;
			case 3:
				desplegarSueldos(listaTrabajadores);
				break;
			case 4:
				anularReserva(listaReservas, scanner);
				break;
			case 5:
				mostrarReservasOrdenadas(listaReservas);
				break;
			default:
				opcion = 6;
				break;
			}
			System.out.print("ingrese una opcion: ");
			opcion = scanner.nextInt();
		}

		scanner.close();

	}

	public static void generarReserva(ListaHabitaciones listaHabitaciones, ListaReservas listaReservas,
			ListaClientes listaClientes, Scanner scanner) {

		System.out.print("esta registrado si [1] o  no [2]: ");
		int opcion = scanner.nextInt();

		Cliente cliente = null;
		if (opcion == 1) {
			System.out.print("ingrese codigo: ");
			String codigo = scanner.next();

			cliente = listaClientes.buscarCliente(codigo);
		} else {
			System.out.print("ingrese nombre: ");
			String nombre = scanner.next();
			System.out.print("ingrese apellido: ");
			String apellido = scanner.next();
			System.out.print("ingrese telefono: ");
			String telefono = scanner.next();
			String codigo = "C" + (listaClientes.getCant() + 1);
			cliente = new Cliente(codigo, nombre, apellido, telefono);
			listaClientes.ingresarCliente(cliente);
		}

		if (cliente != null) {
			System.out.print("ingrese fecha de inicio de la reserva(dd/mm/yyyy): ");
			String fechaInicio = scanner.next();

			String[] fechaI = fechaInicio.split("/");

			int diaI = Integer.parseInt(fechaI[0]);
			int mesI = Integer.parseInt(fechaI[1]);
			int añoI = Integer.parseInt(fechaI[2]);

			int fechaInicioDias = diaI + mesI * 30 + añoI * 360;

			System.out.print("ingrese fecha de termino de la reserva(dd/mm/yyyy): ");
			String fechaFin = scanner.next();

			String[] fechaF = fechaInicio.split("/");

			int diaF = Integer.parseInt(fechaF[0]);
			int mesF = Integer.parseInt(fechaF[1]);
			int añoF = Integer.parseInt(fechaF[2]);

			int fechaFinDias = diaF + mesF * 30 + añoF * 360;

			ListaHabitaciones listaHabitacionesOcupadas = new ListaHabitaciones(100);
			for (int i = 0; i < listaReservas.getCant(); i++) {
				Reserva reserva = listaReservas.getReserva(i);
				int fechaInicioReserva = reserva.getDiasFechaInicio();
				int fechaFinReserva = reserva.getDiasFechaFin();
				if (fechaInicioReserva >= fechaInicioDias && fechaFinDias <= fechaFinReserva) {
					listaHabitacionesOcupadas.ingresarHabitacion(reserva.getHabitacion());
				}
			}

			System.out.println("Habitaciones disponible: ");
			for (int j = 0; j < listaHabitaciones.getCant(); j++) {
				Habitacion habitacion = listaHabitaciones.getHabitacion(j);
				if (listaHabitacionesOcupadas.buscarHabitacion(habitacion.getNumeroHabitacion()) == null) {
					System.out.println(habitacion.toString());
				}
			}

			System.out.print("ingrese numero de habitacion a reservar: ");
			int numero = scanner.nextInt();

			Habitacion habitacion = listaHabitaciones.buscarHabitacion(numero);
			Habitacion habitacionOcupada = listaHabitacionesOcupadas.buscarHabitacion(numero);
			if (habitacion != null && habitacionOcupada == null) {
				int codigo = listaReservas.getCant() + 1;
				Reserva nuevaReserva = new Reserva(codigo, diaI, mesI, añoI, diaF, mesF, añoF);
				nuevaReserva.setHabitacion(habitacion);
				nuevaReserva.setCliente(cliente);
				cliente.getListaReservas().ingresarReserva(nuevaReserva);
				listaReservas.ingresarReserva(nuevaReserva);
				System.out.println("reserva ingresada exitosamente");
			} else {
				System.out.println("habitacion no existe");
			}

		} else {
			System.out.println("no se pudo generar la reserva");
		}
	}

	public static void desplegarSueldos(ListaTrabajadores listaTrabajadore) {
		int sueldo = 0;
		for (int i = 0; i < listaTrabajadore.getCant(); i++) {
			Trabajador trabajador = listaTrabajadore.getTrabajador(i);
			sueldo += trabajador.getSueldo();
			System.out.println(trabajador.toString());
		}

		System.out.println("sueldo total es: " + sueldo);
	}

	public static void mostrarReserva(ListaClientes listaClientes, Scanner scanner) {
		System.out.print("ingrese codigo cliente: ");
		String codigo = scanner.next();

		Cliente cliente = listaClientes.buscarCliente(codigo);
		if (cliente != null) {
			System.out.println(cliente.toString());
			for (int i = 0; i < cliente.getListaReservas().getCant(); i++) {
				Reserva reserva = cliente.getListaReservas().getReserva(i);
				System.out.println(reserva.toString());
			}
		} else {
			System.out.println("cliente no existe");
		}

	}

	public static void anularReserva(ListaReservas listaReservas, Scanner scanner) {
		System.out.print("ingrese codigo de la reserva: ");
		int codigo = scanner.nextInt();

		Reserva reserva = listaReservas.buscarReserva(codigo);

		if (reserva != null) {
			Boolean eliminadaCliente = reserva.getCliente().getListaReservas().eliminar(reserva.getCodigo());
			Boolean eliminada = listaReservas.eliminar(codigo);

			if (eliminada && eliminadaCliente) {
				System.out.println("reserva eliminada exitosamente");
			} else {
				System.out.println("no se puedo eliminar la reserva");
			}
		} else {
			System.out.println("no existe reserva ingresada");
		}

	}

	public static void mostrarReservasOrdenadas(ListaReservas listaReservas) {
		ListaReservas lr = listaReservas.getListaOrdenada(listaReservas);

		for (int i = 0; i < lr.getCant(); i++) {
			System.out.println(lr.getReserva(i).toString());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		ListaHabitaciones listaHabitaciones = new ListaHabitaciones(100);
		ListaReservas listaReservas = new ListaReservas(100);
		ListaTrabajadores listaTrabajadores = new ListaTrabajadores(100);
		ListaClientes listaClientes = new ListaClientes(100);

		leerHabitaciones(listaHabitaciones);
		leerUsuarios(listaTrabajadores, listaClientes);
		leerReservas(listaHabitaciones, listaReservas, listaClientes);

		menu(listaHabitaciones, listaReservas, listaClientes, listaTrabajadores);
		System.out.println("ejecucion terminada");
	}

}
