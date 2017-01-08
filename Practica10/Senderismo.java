import fundamentos.*;

/**
 * Clase principal que muestra por pantalla el perfil de la ruta escogida
 * e indica si se ha superado o no los 1000, 1500 y 2000 m
 * 
 * @author Jaime Diez Gonzalez-Pardo
 * @version 2 · Mayo · 2016
 */



public class Senderismo {
	
		/**
		 * Metodo que escribe en pantalla los datos
		 */
	public static void main(String[] args) {
		
		Ruta caminante = new Ruta("Estacas de Trueba.gpx"); // Crea un objeto Ruta a partir del fichero "Estacas de Trueba.gpx"

		System.out.println("Superada la cota 1000: " + caminante.cotaSuperada(1000)); // Indica si se ha superado los 1000 m
		System.out.println("Superada la cota 1500: " + caminante.cotaSuperada(1500)); // Indica si se ha superado los 1500 m
		System.out.println("Superada la cota 2000: " + caminante.cotaSuperada(2000)); // Indica si se ha superado los 2000 m

		caminante.perfil(); // Pinta la grafica del perfil de la ruta
		caminante.pinta(600); // Se pinta el recorrido de la ruta del caminante
	}
}
