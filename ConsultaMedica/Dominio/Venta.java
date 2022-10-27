package Dominio;

public class Venta {
    private int codigoVenta;
    private int montoTotal;
    private int vuelto;
    private String medioDePago;
    private String fecha;// pq es mas facil de comparar
    private Paciente paciente;
 

    public String getMedioDePago() {
        return medioDePago;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public int getCodigoVenta() {
        return codigoVenta;
    }
    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    public int getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
    public int getVuelto() {
        return vuelto;
    }
    public void setVuelto(int vuelto) {
        this.vuelto = vuelto;
    }
    public String isMedioDePago() {
        return medioDePago;
    }
    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

}
