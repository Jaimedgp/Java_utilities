/**
 * Clase principal que representa y muestra en pantalla los datos de la clase coche
 *
 * @author JaimeDGP
 * @version 12 Mayo 2016
 */

public class Principal {
	
		/**
		 * Metodo principal de la clase
		 */
	public static void main(String[] args) {
			// Se crea el objeto de la clase coche
		Coche seat = new Coche(18.5, 1.3, 4.5, "obstaculos.txt");

		seat.dibujo(); // Se pinta el dibujo del metodo dibujo()

		try{ // Manejo de excepcion
			System.out.println("Primer obstaculo peligroso: " + seat.pocoMargenAlcance().getId()); // Se muestra el identificador del primer obstaculo
				// bucle que recorre todolos posibles choques mostrando su identificador
			for (Obstaculo ostia : seat.posiblesChoques()) {
				System.out.println("Posibles choques inminentes: " + ostia.getId());		
			}
				// si se detecta la excepcion
		} catch (NoEncontrado e) {
			System.out.println("No se ha encontrado obstaculo");
		}
		seat.informe(); // se muestra un informe de los obstaculos
	}
}