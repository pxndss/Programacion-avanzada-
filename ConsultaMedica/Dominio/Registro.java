package Dominio;

public class Registro {
    private Paciente paciente;
    private Medicamento medicamento;
    private int corrrelativo; 
    private String diagnostico; 
    private String observacion;


    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medicamento getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    public int getCorrrelativo() {
        return corrrelativo;
    }
    public void setCorrrelativo(int corrrelativo) {
        this.corrrelativo = corrrelativo;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    } 
   
}    

