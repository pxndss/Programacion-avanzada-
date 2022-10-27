package Logica;
import Dominio.*;


public interface Sistema{
    public void ingresarPaciente(String nombre,String apellido,String rut,int edad);
	public Medicamento ingresarMedicamento(String nombre, String codigo, String mg, String cant, String ml, boolean liquido,
    boolean seguro, int precioCompra);
	public void ingresarRegistro(String rut, int correlativo, String diagnostico, String observacion, String codigoMedicamento);
	public void ingresarVenta(Venta venta);
	public Paciente buscarPaciente(String rut);
	public Venta buscarVenta(int codigoVenta);
	public Medicamento buscarMedicamento(String codigoMedicamento);
	public void ordenamientoMedicamentos();
	public void rankingMedicamentos();
	public void eliminarRegistro(Registro registro);
	public void realizarConsultaMedica(Registro registro,Paciente paciente,Medicamento medicamento);
	public void listadoVentas();
	public void detallesVenta(Venta venta);
	public void realizarVenta(Venta venta);
}