import fundamentos.*;

/**
 * Clase principal de la parte avanzada que muestra por pantalla la precipitacion del 22/09/2014, de los mes de enero y de marzo del 2016
 * del fichero "datos.txt" y la precipitacion de enero del fichero "desierto.txt" (inexistente)
 * 
 * @author Jaime Diez Gonzalez-Pardo
 * @version 25 · Abril · 2016
 */

public class SantanderAvanzada {

		/**
		 * Metodo que escribe en pantalla los datos de la parte avanzada
		 */
	public static void main(String[] args) {
		
		DatosPluviometroAvanzada santander = new DatosPluviometroAvanzada("datos.txt"); // Se crea el objeto con los datos del archivo "datos.txt"
		System.out.println(santander.precipitacionDia(22, 9, 2014)); // Se escriben por pantalla la precipitacion total del 22/9/2014
		System.out.println(santander.precipitacionMaxEnMes(1)); // Se escribe la precipitacion maxima en el mes de enero
		santander.listarMes(3, 2016); // se printa por pantalla un listado de las precipitaciones del mes de marzo del 2016

		DatosPluviometroAvanzada cadiz = new DatosPluviometroAvanzada("desierto.txt"); // Se crea el objeto con los datos del archivo "desierto.txt" (inexistente)
		System.out.println(cadiz.precipitacionMaxEnMes(1)); // Se escribe la precipitacion maxima en el mes de enero
	}
}