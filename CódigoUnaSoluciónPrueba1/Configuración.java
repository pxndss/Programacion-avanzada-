package prueba1b;

public abstract class Configuración
{
	private Motor[] motores;
	private int numMotores;
	
	public abstract int getCantidadMotores();
	
	public Configuración()
	{
		motores = new Motor[getCantidadMotores()];
		numMotores = 0;
	}
	
	public Motor getMotor(int i)
	{
		return motores[i-1];
	}

	public void agregarMotor(Motor motor)
	{
		motores[numMotores++] = motor;
	}

	public boolean contiene(Motor motor)
	{
		for(Motor m : motores) {
			if (m == motor) return true;
		}
		return false;
	}
} 
