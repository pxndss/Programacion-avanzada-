package Dominio;
public abstract class Medicamento {
    private String nombre;
    private String codigoMedicamento;
    private int precioCompra;
    private int cantidadVecesRecetado =0;


    public Medicamento(String nombre,String codigo,int precioCompra){
        this.nombre=nombre;
        this.codigoMedicamento=codigo;
        this.precioCompra=precioCompra;
        
        

        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(String codigo) {
        this.codigoMedicamento = codigo;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }
    public int getCantidadVecesRecetado() {
        return cantidadVecesRecetado;
    }

    public void setCantidadVecesRecetado(int cantidadVecesRecetado) {
        this.cantidadVecesRecetado = cantidadVecesRecetado;
    }

    @Override
    public String toString() {
        return "Medicamento [cantidadVecesRecetado=" + cantidadVecesRecetado + ", codigoMedicamento="
                + codigoMedicamento + ", nombre=" + nombre + ", precioCompra=" + precioCompra + "]";
    }
    
}
