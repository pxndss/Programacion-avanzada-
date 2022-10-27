
public class Reserva {
	private int codigo;
	private Cliente cliente;
	private Habitacion habitacion;
	private int diaInicio, mesInicio, añoInicio;
	private int diaFin, mesFin, añoFin;

	public Reserva(int codigo, int diaInicio, int mesInicio, int añoInicio, int diaFin, int mesFin, int añoFin) {
		this.codigo = codigo;
		this.diaInicio = diaInicio;
		this.mesInicio = mesInicio;
		this.añoInicio = añoInicio;
		this.diaFin = diaFin;
		this.mesFin = mesFin;
		this.añoFin = añoFin;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public int getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(int diaInicio) {
		this.diaInicio = diaInicio;
	}

	public int getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(int mesInicio) {
		this.mesInicio = mesInicio;
	}

	public int getAñoInicio() {
		return añoInicio;
	}

	public void setAñoInicio(int añoInicio) {
		this.añoInicio = añoInicio;
	}

	public int getDiaFin() {
		return diaFin;
	}

	public void setDiaFin(int diaFin) {
		this.diaFin = diaFin;
	}

	public int getMesFin() {
		return mesFin;
	}

	public void setMesFin(int mesFin) {
		this.mesFin = mesFin;
	}

	public int getAñoFin() {
		return añoFin;
	}

	public void setAñoFin(int añoFin) {
		this.añoFin = añoFin;
	}

	public int getDiasFechaInicio() {
		return diaInicio + mesInicio * 30 + añoInicio * 360;
	}

	public int getDiasFechaFin() {
		return diaFin + mesFin * 30 + añoFin * 360;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", cliente=" + cliente + ", habitacion=" + habitacion + ", diaInicio="
				+ diaInicio + ", mesInicio=" + mesInicio + ", añoInicio=" + añoInicio + ", diaFin=" + diaFin
				+ ", mesFin=" + mesFin + ", añoFin=" + añoFin + "]";
	}

}
