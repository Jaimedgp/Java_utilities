/**
 * Clase principal
 *
 * @author JaimeDGP
 * @version 16 Mayo 2016
 */

public class Principal {


		/**
		 * Metodo principal
		 */
	public static void main(String[] args) {
		
		Circuito norton = new Circuito(20); // se crea el objeto de la clase Circuito

		ListaMedidas vegas = new ListaMedidas(norton, 3); // ListaMedidas para el nudo 3

		vegas.escribe("medidas.txt"); // escribe los datos en el archivo medidas.txt

		System.out.println("Medidas dentro de [-5.0,5.0] V y  [-1.0,1.0] A: " + vegas.valoresEnRango(-5.0, 5.0, -1.0, 1.0));

		System.out.println(vegas.numCambiosRapidos(99, 4.5));
	}
}

