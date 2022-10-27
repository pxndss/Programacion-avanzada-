package Logica;
import java.util.LinkedList;
import Dominio.*;


public class SistemaImpl implements Sistema {
    //listas Generales de 
    LinkedList<Paciente> listaPaciente = new LinkedList<>();
    LinkedList<Medicamento>listaMedicamento = new LinkedList<>();
    LinkedList<Venta>listaVenta = new LinkedList<>();
    LinkedList<Registro>listaRegistros = new LinkedList<>();
    @Override
    public void ingresarPaciente(String nombre, String apellido, String rut, int edad) {
        Paciente paciente = new Paciente(nombre, apellido, rut, edad, listaMedicamento, listaRegistros);
        listaPaciente.add(paciente);

        
    }
    @Override
    public Medicamento ingresarMedicamento(String nombre, String codigo, String mg, String cant, String ml, boolean liquido,
            boolean seguro, int precioCompra) {
                if( mg=="-"){
                    
                    Medicamento medicamento = new Jarabe(nombre, codigo, precioCompra, ml, liquido, seguro);
                    listaMedicamento.add(medicamento);}
                else{
                    Medicamento medicamento = new Tableta(nombre, codigo, precioCompra, mg, cant);
                    listaMedicamento.add(medicamento);
                    }
                return null;
                    
        }

    
    @Override
    public void ingresarRegistro(String rut, int correlativo, String diagnostico, String observacion, String codigoMedicamento) {
        Registro registro = new Registro();
        listaRegistros.add(registro);
        
    }
    @Override
    public void ingresarVenta(Venta venta) {
        Venta venta = new Venta();
        listaVenta.add(venta);
        
    }
    @Override
    public Paciente buscarPaciente(String rut) {
        for(int i =0;i<listaPaciente.size();i++){
            Paciente p = listaPaciente.get(i);
            if(p.getRut().equals(rut)){
                return p;
            }
        }
        return null;
        
    }
    @Override
    public Venta buscarVenta(int codigoVenta) {
        for(int i=0;i<listaVenta.size();i++){
            Venta v = listaVenta.get(i);
            if(v.getCodigoVenta()==codigoVenta)
            return v;
        }
        
        return null;
        
    }
    @Override
    public Medicamento buscarMedicamento(String codigoMedicamento) {
        for(int i=0;i<listaMedicamento.size();i++){
            Medicamento m = listaMedicamento.get(i);
            if(m.getCodigoMedicamento().equals(codigoMedicamento))
            return m;
        }

        return null;
        
    }
    @Override
    public void ordenamientoMedicamentos() {


       
        
    }
    @Override
    public void rankingMedicamentos() {
        for(int i=0;i<listaMedicamento.size();i++){
           Medicamento m = listaMedicamento.get(i);
           m.toString();

        }
    
    }
    @Override
    public void eliminarRegistro(Registro registro) {
       
        
    }
    @Override
    public void realizarConsultaMedica(Registro registro, Paciente paciente, Medicamento medicamento) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void listadoVentas() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void detallesVenta(Venta venta) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void realizarVenta(Venta venta) {
        // TODO Auto-generated method stub
        
    }
 
    
}
  
