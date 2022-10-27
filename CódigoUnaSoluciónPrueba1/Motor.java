package prueba1b;

import java.util.LinkedList;
import java.util.List;

public class Motor
{
	private List<Instalación> instalaciones = new LinkedList<>();
	private String codMotor;

	public Motor(String codMotor)
	{
		this.codMotor = codMotor;
	}

	public String getCódigo()
	{
		return codMotor;
	}

	public boolean estáInstaladoEnDias(int diaDesde, int diaHasta)
	{
		for (Instalación i : instalaciones) {
			if (i.corresponde(diaDesde, diaHasta)) return true;
		}
		return false;
	}

	public void realizarInstalación(Instalación i)
	{
		instalaciones.add(i);
	}

	public RangoDias getRangoFechasInstalaciones()
	{
		int diaMenor = Integer.MAX_VALUE, diaMayor = Integer.MIN_VALUE;
		
		for (Instalación i : instalaciones) {
			if (i.getDiaDesde() < diaMenor) diaMenor = i.getDiaDesde();
			if (i.getDiaHasta() > diaMayor) diaMayor = i.getDiaHasta();
		}
		return new RangoDias(diaMenor, diaMayor);
	}

	public Instalación getInstalación(int día)
	{
		for (Instalación i : instalaciones) {
			if (i.corresponde(día)) return i;
		}
		return null;
	} 

}
