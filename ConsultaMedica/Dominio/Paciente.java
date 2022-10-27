package Dominio;

import java.util.LinkedList;

public class Paciente {
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;

    private LinkedList<Medicamento> lMedicamentos;
    private LinkedList<Registro> lp;

    public Paciente(String nombre, String apellido, String rut, int edad, LinkedList<Medicamento> lm,LinkedList<Registro> lp) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.edad = edad;
        lMedicamentos= new LinkedList<>();
        lp= new LinkedList<>();       
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
   
    
    public LinkedList<Registro> getLp() {
        return lp;
    }
    public void setLp(LinkedList<Registro> lp) {
        this.lp = lp;
    }
    public LinkedList<Medicamento> getlMedicamentos() {
        return lMedicamentos;
    }
    public void setlMedicamentos(LinkedList<Medicamento> lMedicamentos) {
        this.lMedicamentos = lMedicamentos;
    }
    
}


