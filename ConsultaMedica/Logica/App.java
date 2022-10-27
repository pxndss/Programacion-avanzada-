package Logica;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import Dominio.*;


public class App{

public static void main(String[] args) throws FileNotFoundException {
    SistemaImpl sistema = new SistemaImpl();
    leerPaciente(sistema);
    leerRegistro(sistema);
    leerVenta(sistema);
    leerMedicamento(sistema);  
    menu(sistema);
        
}

    private static void menu(SistemaImpl sistema) { 
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Sistema de Consultas del Dr.Chaparron ");

        System.out.println("Bienvenido A la Consulta Medica");
        int op =0;

        while(op !=7){
            System.out.println("******Menu de opciones******");
            System.out.println("[1] Ranking de Medicamentos");
            System.out.println("[2] Eliminar un Registro");
            System.out.println("[3] Realizar una Consulta Medica");
            System.out.println("[4] Listado de Ventas");
            System.out.println("[5] Detalles de una Venta");
            System.out.println("[6]Realizar una venta");
            System.out.println("[7]Salir");

            op= scan.nextInt();

            switch(op){
                case 1:
                System.out.println("*** Ranking de Medicamentos ***");
                break;
            
                case 2: 
                System.out.println("***Eliminar un Registro***");
                break;

                case 3:
                System.out.println("***Realizar Consulta Medica***");
                break;

                case 4:
                System.out.println("***Listado de Ventas");
                break;

                case 5:
                System.out.println("***Detalles de una venta***");
                break;

                case 6:
                System.out.println("***Realizar una Venta***");
                break;

        }
        System.out.println(" ");
        }
        System.out.println("Saliendo del Sistema....");

    }
    private static void leerMedicamento(SistemaImpl sistema) throws FileNotFoundException { 
    Scanner scan = new Scanner(new File("Medicamentos.txt"));
    while(scan.hasNextLine());
    String linea = scan.nextLine();
    String [] partes = linea.split(",");
    String nombre= partes[0];
    String codigo = partes[1];
    String mg = partes[2];
    String cant=partes[3];
    String ml = (partes[4]);
    boolean liquido = Boolean.parseBoolean(partes[5]);
    boolean seguro =Boolean.parseBoolean(partes[6]);
    int precioCompra =Integer.parseInt( partes[7]);
    sistema.ingresarMedicamento(nombre,codigo,mg,cant,ml,liquido,seguro,precioCompra);
    
    }
    

    private static void leerVenta(SistemaImpl sistema) throws FileNotFoundException {

    Scanner scan = new Scanner(new File("Ventas.txt"));
    while(scan.hasNextLine());
        String linea = scan.nextLine();
        String [] partes = linea.split(",");
        int codigoVenta = Integer.parseInt(partes[0]);
        int montoTotal = Integer.parseInt( partes[1]);
        int vuelto = Integer.parseInt(partes[2]);
        String medioPago= partes[3];
        String fecha = partes[4];
        String rut = partes[5];
        int cantMedicamento = Integer.parseInt(partes[6]);
        int codigoMedicamento =Integer.parseInt(partes[7]);

        sistema.ingresarVenta(venta);
        

    }


    private static void leerRegistro(SistemaImpl sistema) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("Registro.txt"));
    while(scan.hasNextLine()){
        String linea = scan.nextLine();
        String [] partes = linea.split(",");
        String rut = partes[0];
        int correlativo = Integer.parseInt(partes[1]);
        String diagnostico = partes [2];
        String observacion = partes [3];
        String codigoMedicamento = partes[4];

        Registro registro = new Registro();
        sistema.ingresarRegistro(rut, correlativo, diagnostico, observacion, codigoMedicamento);
       }
    }

    private static void leerPaciente(SistemaImpl sistema) throws FileNotFoundException { 
        Scanner scan = new Scanner(new File("Paciente.txt"));    
        while(scan.hasNextLine()){
        String linea = scan.nextLine();
        String [] partes = linea.split(",") ;
        String nombre = partes [0];
        String apellido = partes [1];
        String rut = partes [2];
        int edad = Integer.parseInt(partes[3]);

        Paciente paciente = new Paciente(nombre,apellido,rut,edad, null, null);
        sistema.ingresarPaciente(nombre,apellido, rut, edad);
        }
        scan.close();
    }

    
}
