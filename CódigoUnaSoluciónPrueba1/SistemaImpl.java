package prueba1b;

import java.util.LinkedList;
import java.util.List;

public class SistemaImpl implements Sistema
{
	private List<Motor> motores = new LinkedList<Motor>();
	private List<Avión> aviones = new LinkedList<Avión>();
	
	@Override
	public boolean configurar(String codMotor, String codAvión, int diaDesde, int diaHasta)
	{
		Motor m = buscarCrearMotor(codMotor);
		Avión a = buscarCrearAvión(codAvión);
		
		return a.instalarMotor(m, diaDesde, diaHasta);
	}

	private Avión buscarAvión(String codAvión)
	{
		for(Avión a : aviones) {
			if (codAvión.equals(a.getCódigo())) return a;
		}
		return null;
	}
	private Avión buscarCrearAvión(String codAvión)
	{
		Avión a = buscarAvión(codAvión);
		if (a != null) return a;
		
		a = AviónFactory.crear(codAvión);
		aviones.add(a);
		return a;
	}

	private Motor buscarMotor(String codMotor)
	{
		for(Motor m : motores) {
			if (codMotor.equals(m.getCódigo())) return m;
		}
		return null;
	}
	
	private Motor buscarCrearMotor(String codMotor)
	{
		Motor m = buscarMotor(codMotor);
		if (m != null) return m;
		m = new Motor(codMotor);
		motores.add(m);
		return m;
	}

	@Override
	public String getConfiguraciónAviónCiertoDía(String codAvión, int día)
	{
		Avión a = buscarAvión(codAvión);
		Configuración config = a.getConfiguración(día);
		
		String txt = "";
		for(int i=1;i<=config.getCantidadMotores();i++) {
			Motor m = config.getMotor(i);
			String código = m != null ? m.getCódigo() : "NO INSTALADO";
			txt += "Motor " + i + ": " + código + "\n";
		}
		return txt;
	}

	@Override
	public String getHistoriaMotor(String codMotor)
	{
		Motor m = buscarMotor(codMotor);
		RangoDias rango = m.getRangoFechasInstalaciones();
		
		String txt = "";
		int diasInstalado = 0;
		for(int d=rango.getPrimerDia();d<=rango.getÚltimoDia();d++) {
			Instalación inst = m.getInstalación(d);
			if (inst == null) {
				txt += (d + ": NO INSTALADO");
			} else {
				txt += (d + ": " + inst.getAvión().getCódigo());
				diasInstalado++;
			}
			txt += "\n";
		}
		double porcentUso = 100.0 * diasInstalado / (5 * 365.0);
		double porcentRestante = 100 - porcentUso;
		
		txt += "% vida útil restante: " + porcentRestante + "\n";
		
		return txt;
	}

	@Override
	public String getGanttAvión(String codAvión)
	{
		Avión a = buscarAvión(codAvión);
		RangoDias rango = a.getRangoFechasInstalaciones();
		List<Motor> motores = a.getMotoresUsados();
		
		String txt = "";
		
		txt += "Avión " + codAvión + "\n";
		txt += "Motor/Día ";
		
		for(int d=rango.getPrimerDia();d<=rango.getÚltimoDia();d++) {
			txt += String.format("%3d", d) + " ";
		}
		txt += "\n";
		
		for(Motor m : motores) {
			txt += String.format("%9s", m.getCódigo()) + " ";
		
			for(int d=rango.getPrimerDia();d<=rango.getÚltimoDia();d++) {
				if (a.usaMotorEnDía(m, d)) {
					txt += "  X ";	
				} else {
					txt += "    ";
				}
			}
			txt += "\n";
		}
		
		return txt;
	}

}
