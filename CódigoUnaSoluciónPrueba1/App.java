package prueba1b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App
{
	private static final String FILE = "D:/Devel/eclipse-workspace/ProgramaciónAvanzada_2022_W/src/prueba1b/aviones.txt";
	
	public static void main(String[] args) throws IOException
	{
		App app = new App();
		app.iniciar();
	}

	private Sistema sist = new SistemaImpl();
	
	private void iniciar() throws IOException
	{
		cargarArchivo();
		menú();
	}

	private void menú()
	{
		while (true) {
			mostrarMenú();
			int opción = getOpciónMenú();
			if (opción == 1) break;
			ejecutarOpción(opción);
		}
	}

	private void ejecutarOpción(int opción)
	{
		switch(opción) {
		case 2:
			verConfiguraciónAviónCiertoDía();
			break;
		case 3:
			verHistorialMotor();
			break;
		case 4:
			verCargaGanttAvión();
		}
	}

	private void verCargaGanttAvión()
	{
		String codAvión = leerStringDesdeTeclado("Código de avión");
		String reporte = sist.getGanttAvión(codAvión);
		System.out.println(reporte);
	}

	private void verHistorialMotor()
	{
		String codMotor = leerStringDesdeTeclado("Código de motor");
		
		String reporte = sist.getHistoriaMotor(codMotor);
		System.out.println(reporte);
	}

	private void verConfiguraciónAviónCiertoDía()
	{
		String codAvión = leerStringDesdeTeclado("Código de avión");
		int día = leerEnteroDesdeTeclado("Día");
		
		String reporte = sist.getConfiguraciónAviónCiertoDía(codAvión, día);
		System.out.println(reporte);
	}

	private int getOpciónMenú()
	{
		return leerEnteroDesdeTeclado("Opción");
	}

	private int leerEnteroDesdeTeclado(String título)
	{
		System.out.print(título + " > ");
		Scanner s = new Scanner(System.in);
		return Integer.valueOf(s.nextLine());
	}
	private String leerStringDesdeTeclado(String título)
	{
		System.out.print(título + " > ");
		Scanner s = new Scanner(System.in);
		return (s.nextLine());
	}

	private void mostrarMenú()
	{
		System.out.println("Menú:");
		System.out.println("-----------------------");
		System.out.println("1. Salir");
		System.out.println("2. Ver configuración de un avión cierto día");
		System.out.println("3. Ver el historial de un motor");
		System.out.println("4. Ver carta gantt de un avión");
		System.out.println("");
	}

	private void cargarArchivo() throws IOException
	{
		Scanner s = new Scanner(new File(FILE));
		int linea = 0;
		
		while (s.hasNextLine()) {
			linea++;
			String line = s.nextLine();
			
			// M1 AV1 10-20
			String[] partes = line.split(" ");
			String motor = partes[0];
			String avion = partes[1];
			String[] dias = partes[2].split("-");
			int desde = Integer.valueOf(dias[0]);
			int hasta = Integer.valueOf(dias[1]);
			
			
			if (!sist.configurar(motor, avion, desde, hasta)) {
				System.out.println("Línea " + linea + ": No se puede configurar: " + line);
			}
		}
		s.close();
	}

}
