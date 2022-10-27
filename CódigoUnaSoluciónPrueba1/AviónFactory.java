package prueba1b;

public class AviónFactory
{

	public static Avión crear(String codAvión)
	{
		if (codAvión.startsWith("AV")) return new Avion2Motores(codAvión);
		if (codAvión.startsWith("AB")) return new Avion3Motores(codAvión);
		
		return null;
	}

}
