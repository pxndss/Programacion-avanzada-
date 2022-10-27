package Dominio;
public class Jarabe extends Medicamento { 
    private String ml;
    private boolean liquido;
    private boolean seguro;
    public Jarabe(String nombre, String codigo, int precioCompra,String ml,boolean liquido,boolean seguro) {
        super(nombre, codigo, precioCompra);
        this.ml=ml;
        
    }
    public String getMl() {
        return ml;
    }
    public void setMl(String ml) {
        this.ml = ml;
    }
    public boolean isLiquido() {
        return liquido;
    }
    public void setLiquido(boolean liquido) {
        this.liquido = liquido;
    }
    public boolean isSeguro() {
        return seguro;
    }
    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }
   
    
   

    
    
}
