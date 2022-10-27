package prueba1b;

public interface Sistema
{
	/**
	 * Configura en el sistema el hecho de que un motor fue instalado
	 * en un avión, desde un día hasta otro día (inclusive).
	 * 
	 * Si el motor no existe, se crea en el sistema.
	 * Si el avión no existe, se crea en el sistema.
	 * 
	 * @param motor El código del motor que se quiere configurar
	 * @param avion El código del avión donde se quiere configurar el motor
	 * @param desde El día de inicio de la instalación del motor en el avión
	 * @param hasta El día de término donde el motor fue retirado del avión
	 * 
	 * @return True si la configuración fue exitosa; False si no se pudo
	 * 	instalar el motor en el avión, ya sea por que se excede la cantidad
	 * 	de motores del avión, o por que el motor ya está instalado en 
	 * 	otro lugar en el rango de fechas indicada.
	 */
	boolean configurar(String motor, String avion, int desde, int hasta);

	/**
	 * Retorna un string que indica la configuración de un avión en cierto día.
	 * 
	 * @param codAvión El código del avión que se quiere revisar
	 * @param día El día de interés
	 * @return Un String que contiene el estado del avión, indicando el
	 * 	detalle de los motores instalados.
	 */
	String getConfiguraciónAviónCiertoDía(String codAvión, int día);

	/**
	 * Retorna un string con la historia de instalaciones del motor indicado.
	 * 
	 * @param codMotor El código del motor de interés.
	 * @return Un String que contiene, día a día, la indicación de en qué
	 * 	avión estaba instalado el motor. Incluso contiene los días en
	 * 	que el motor no estuvo instalado en ningún avión.
	 */
	String getHistoriaMotor(String codMotor);

	/**
	 * Retorna un string con el detalle de todos los motores que fueron 
	 * instalados en un avión.
	 * 
	 * @param codAvión El código del avión de interés.
	 * @return Un String que contiene, para el avión indicado, el detalle
	 * 	día a día de qué motor estaba instalado en el avión.
	 */
	String getGanttAvión(String codAvión);

}
