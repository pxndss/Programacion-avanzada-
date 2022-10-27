package prueba1b;

public class Avion3Motores extends Avión
{

	public Avion3Motores(String codAvión)
	{
		super(codAvión);
	}

	@Override
	public int getCantidadMáximaMotores()
	{
		return 3;
	}

	@Override
	protected Configuración crearConfiguración()
	{
		return new Configuración3Motores();
	}

}
