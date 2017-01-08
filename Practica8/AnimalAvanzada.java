import fundamentos.*;

/**
 *
 * Clase con el metodo principal del proyecto correspondiente a la practica 8 parte avanzada
 * Crea un objeto de la clase Trayectoria a partir de valores metidos por teclado en el objeto creado cajaTexto y otro de la
 * clase Dibujo (paquete fundamentos) y se calcula la longuitud de esta.
 *
 * @author Jaime Diez Gonzalez-Pardo
 * @version 18 abril 2016
 */

public class AnimalAvanzada {


		/**
		 * Se crean los tres objetos que representan el camino recorrido por el animal
		 */
	public static void main(String[] args) {
		
		CajaTexto box = new CajaTexto("Trayectoria del animal", 2, 2); // Se crea el objeto que lee las coordenadas por teclado
		box.espera(); // Se espera 

		int n = 0; // Se inicia la variable nº de lineas

			// bucle que cuenta el numero de lineas introducidas
		while (box.hayMas()) {
			n++; // Suma una linea mas
			box.avanzaLinea(); // pasa a la siguiente linea			
		}

		box.reinicia(); // Se vuelve a la primera linea

		// Se inicializan los arrays de las coordenadas
		int[] ppx = new int[n]; 
		int[] ppy = new int[n];

			// bucle que pasa los valores metidos por teclado a elementos de las coordenadas mientras haya linea que leer
		for (int t = 0; t<n; t++) {
			ppx[t] = box.leeInt(0); // sustituye el elemento por el valor de la coordenada metida por teclado
			ppy[t] = box.leeInt(1); // sustituye el elemento por el valor de la coordenada metida por teclado
			
			box.avanzaLinea(); // pasa a la siguiente linea
		}

		int[] polX = {630, 630, 3, 3, 220}; // Coordenas del recinto en el eje X
		int[] polY = {5, 450, 450, 130, 5}; // Coordenadas del recinto en el eje Y

		Trayectoria camino = new Trayectoria(ppx,ppy); // Se crea el objeto Trayectoria con las coordenadas de ppx y ppy

		Dibujo raton = new Dibujo("Trayectoria del raton"); // Se crea el objeto dibuja  
		raton.ponGrosorLapiz(4); // Se cambia el grosor de las lineas pintadas a 4
		raton.ponColorLapiz(ColorFig.azul); // Se cambia el color de las lineas del recinto a azul
		raton.dibujaPoligono(polX, polY); // Se dibuja el recinto

		raton.ponColorLapiz(ColorFig.rojo); // Se cambia el color de las lineas de la trayectoria a rojo
		camino.dibuja(raton); // Se dibuja la trayectoria invocando al metodo de la clase Trayectoria
		raton.dibujaTexto("Longitud= "+camino.longitud(), 10, 300); // Se escribe sobre el Dibujo la longitud de la trayectoria
		raton.espera(); // Se pinta en pantalla

	}
}