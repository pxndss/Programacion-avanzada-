package prueba1b;

public class Avion2Motores extends Avión
{
	public Avion2Motores(String codAvión)
	{
		super(codAvión);
	}

	@Override
	public int getCantidadMáximaMotores()
	{
		return 2;
	}

	@Override
	protected Configuración crearConfiguración()
	{
		return new Configuración2Motores();
	}

}
