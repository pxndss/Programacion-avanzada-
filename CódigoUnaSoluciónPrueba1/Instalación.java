package prueba1b;

public class Instalación
{
	private Avión avión;
	private Motor motor;
	private int diaDesde;
	private int diaHasta;

	public Instalación(Avión avión, Motor motor, int diaDesde, int diaHasta)
	{
		this.avión = avión;
		this.motor = motor;
		this.diaDesde = diaDesde;
		this.diaHasta = diaHasta;
	}

	public boolean corresponde(int día)
	{
		return getDiaDesde() <= día && día <= getDiaHasta();
	}

	public boolean corresponde(int d1, int d2)
	{
		if (corresponde(d1)) return true;
		if (corresponde(d2)) return true;
		if (d1 <= getDiaDesde() && getDiaDesde() <= d2) return true;
		if (d1 <= getDiaHasta() && getDiaHasta() <= d2) return true;
		return false;
	}

	public Avión getAvión()
	{
		return avión;
	}

	public Motor getMotor()
	{
		return motor;
	}

	public int getDiaDesde()
	{
		return diaDesde;
	}

	public int getDiaHasta()
	{
		return diaHasta;
	}

}
