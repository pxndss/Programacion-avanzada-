package Dominio;
public class Tableta extends Medicamento {
    private String mg;
    private String cant;
    
    public Tableta(String nombre, String codigo, int precioCompra,String mg,String cant) {
        super(nombre, codigo, precioCompra);
        this.mg=mg;
        this.cant=cant;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

}
