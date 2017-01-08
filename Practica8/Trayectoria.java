import fundamentos.*;

/**
 * Esta clase representa la trayectoria de un animal seguido por GPS, dibujando su camino y calculando la distacia que recorre
 *
 * @author Jaime Diez Gonzalez-Pardo
 * @version 18 abril 2016
 */

public class Trayectoria {

	private int[] x; // array de tipo int 
	private int[] y; // array de tipo int


		/**
		 * Metodo constructor que crea el objeto Trayectoria con la coordenadas posicion del animal
		 *
		 * @param int[] px (coordenadas en el eje X), int[] py (coordenadas en el eje Y)
		 */
	public Trayectoria(int[] px, int[] py) {

			// Se convierten los atributos en arrays del mismo tamaño que los parametros
		this.x = new int[px.length]; 
		this.y = new int[py.length];

			// bucle for que convierte todos los elementos de los parametros en elementos de los atributos
		for (int s = 0; s<px.length; s++) {
			x[s] = px[s];
			y[s] = py[s];
		}
	}


			/**
			 * 		PSEUDOCÓDIGO
			 * Método longitud() retorna real
			 * 		real dist = 0
			 * 		Para i desde 0 hasta el anteúltimo elemento de x
			 * 			dist = dist + la raiz cuadrada de x[i+1]-x[i] al cuadrado menos y[i+1]-y[i] al cuadrado
			 * 		fin para
			 * 		retorna dist
			 */

		/**
		 * Metodo que calcula la longitud que recorre la trayectoria a partir de la diferencia entre dos elementos consecutivos del array
		 *
		 * @return double dist (distancia o longitud recorrida)
		 */
	public double longitud() {

		double dist = 0; // Se inicia la variable dist en 0

			// Bucle for que recorre todo el array calculando la diferencia entre elementos consecutivos
			// puesto que se calcula entre x[i+1] y x[i], el bucle solo llega hasta el anteultimo elemento
		for (int i = 0; i<x.length-1; i++) {
			dist += Math.sqrt(Math.pow(x[i+1]-x[i], 2) + Math.pow(y[i+1]-y[i], 2)); // Se suma a la variable distancia la diferencia de elementos
		}
		return dist; // Se retorna la distancia
	}

		/**
		 * Metodo que dibuja la trayectoria a partir de la clase Dibujo del paquete fundamentos
		 * 
		 * @param Dibujo dib (objeto de la clase dibujo)
		 */
	public void dibuja(Dibujo dib) {

		dib.dibujaLineas(x, y); // Dibuja las lines de los arrays x e y
	}

}