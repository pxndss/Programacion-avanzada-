package prueba1b;

public class RangoDias
{
	private int diaMenor;
	private int diaMayor;

	public RangoDias(int diaMenor, int diaMayor)
	{
		this.diaMenor = diaMenor;
		this.diaMayor = diaMayor;
	}

	public int getÚltimoDia()
	{
		return diaMayor;
	}

	public int getPrimerDia()
	{
		return diaMenor;
	}
}
