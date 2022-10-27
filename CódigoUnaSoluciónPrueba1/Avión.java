package prueba1b;

import java.util.LinkedList;
import java.util.List;

public abstract class Avión
{
	private List<Instalación> instalaciones = new LinkedList<>();
	private String codAvión;

	public Avión(String codAvión)
	{
		this.codAvión = codAvión;
	}

	public boolean instalarMotor(Motor m, int diaDesde, int diaHasta)
	{
		if (!hayEspacioEnDias(diaDesde, diaHasta)) return false;
		if (m.estáInstaladoEnDias(diaDesde, diaHasta)) return false;
		
		Instalación i = new Instalación(this, m, diaDesde, diaHasta);
		instalaciones.add(i);
		m.realizarInstalación(i);
		return true;
	}

	private boolean hayEspacioEnDias(int diaDesde, int diaHasta)
	{
		for(int d=diaDesde;d<=diaHasta;d++) {
			int n = contarMotoresInstalados(d);
			
			if (n >= getCantidadMáximaMotores()) return false;
		}
		return true;
	}

	public abstract int getCantidadMáximaMotores();

	private int contarMotoresInstalados(int día)
	{
		int c = 0;
		for (Instalación i : instalaciones) {
			if (i.corresponde(día)) c++;
		}
		return c;
	}

	public String getCódigo()
	{
		return codAvión;
	}

	public Configuración getConfiguración(int día)
	{
		Configuración config = crearConfiguración();
		
		for (Instalación i : instalaciones) {
			if (i.corresponde(día)) {
				config.agregarMotor(i.getMotor());
			}
		}
		return config;
	}

	protected abstract Configuración crearConfiguración();

	public RangoDias getRangoFechasInstalaciones()
	{
		int diaMenor = Integer.MAX_VALUE, diaMayor = Integer.MIN_VALUE;
		
		for (Instalación i : instalaciones) {
			if (i.getDiaDesde() < diaMenor) diaMenor = i.getDiaDesde();
			if (i.getDiaHasta() > diaMayor) diaMayor = i.getDiaHasta();
		}
		return new RangoDias(diaMenor, diaMayor);
	}

	public List<Motor> getMotoresUsados()
	{
		List<Motor> motores = new LinkedList<>();
		
		for (Instalación i : instalaciones) {
			if (!está(motores, i.getMotor())) {
				motores.add(i.getMotor());
			}
		}
		return motores;
	}

	private boolean está(List<Motor> motores, Motor motor)
	{
		for(Motor m : motores) {
			if (m == motor) return true;
		}
		return false;
	}

	public boolean usaMotorEnDía(Motor m, int día)
	{
		Configuración config = getConfiguración(día);
		
		return config.contiene(m);
	}

}
