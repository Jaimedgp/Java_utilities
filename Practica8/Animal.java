import fundamentos.*;

/**
 *
 * Clase con el metodo principal del proyecto correspondiente a la practica 8
 * Crea un objeto de la clase Trayectoria y otro de la clase Dibujo (paquete fundamentos) y se calcula la longuitud de esta.
 *
 * @author Jaime Diez Gonzalez-Pardo
 * @version 18 abril 2016
 */

public class Animal {


		/**
		 * Se crean los dos objetos que representan el camino recorrido por el animal
		 */
	public static void main(String[] args) {

		int[] ppx = {120, 200, 305, 310, 405, 385, 310, 270, 305, 405}; // Coordenadas de la trayectoria en el eje X dadas por el profesor
		int[] ppy = {385, 310, 420, 285, 270, 190, 80, 135, 180, 140}; // Coordenadas de la trayectoria en el eje Y dadas por el profesor
		
		Trayectoria camino = new Trayectoria(ppx,ppy); // Se crea el objeto Trayectoria con las coordenadas de ppx y ppy

		Dibujo raton = new Dibujo("Trayectoria del raton"); // Se crea el objeto dibuja  
		raton.ponGrosorLapiz(4); // Se cambia el grosor de las lineas pintadas a 4
		raton.ponColorLapiz(ColorFig.rojo); // Se cambia el color de las lineas a rojo

		camino.dibuja(raton); // Se dibuja la trayectoria invocando al metodo de la clase Trayectoria
		raton.dibujaTexto("Longitud= "+camino.longitud(), 10, 300); // Se escribe sobre el Dibujo la longitud de la trayectoria
		raton.espera(); // Se pinta en pantalla
	}
}