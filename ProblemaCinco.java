import fundamentos.*;
import java.util.*;

public class ProblemaCinco {

	private double a, b;

	private String nombre, codigo;
	private int numAlumnos; 


		/**
		 * Metodo que calcula la regresion logaritmicas de una funcion correspondiente
		 * a y = a*ln(x) + b
		 *
		 *@param x[] , y[] array de numeros reales correspondientes a los puntos
		 *@param y[] SE SEPARAN LOS PARAMETROS
		 */
	public void regresionLogaritmica(double[] x, double[]y) {

			/*
			 * Se comprueba que ambos datos tengan el mismo numero de elementos
			 */
		if (x.length != y.length) {

				// Si no tienen el mismo tamaño se iguala a NaN
			a = Double.NaN;
			b = Double.NaN;			
		} else {
			double sumX=0, sumY=0, sumLnX=0, sumLn2X=0, sumLnXY=0, sumY2=0; // se inicializan las variables necesarias para calcular la regresion
			int n = x.length; // se define la variable n con el tamaño del array

				// Bucle for que te calcula las variables necesarias para el calcula de a y b
			for (int i = 0; i<n; i++) {
				sumX += x[i]; // sumatorio de x
				sumY += y[i]; // sumatorio de y
				sumLnX += Math.log(x[i]); // sumatorio del ln de x
				sumLn2X += Math.log(x[i])*Math.log(x[i]); // sumatorio del cuadrado de ln(x)
				sumLnXY += Math.log(x[i])*y[i]; // sumatorio de ln(x)*y
				sumY2 += y[i]*y[i]; // sumatorio de y*y
			}
			a = (sumLnXY- sumY*sumLnX/n)/(sumLn2X - sumLnX*sumLnX/n); // calculo de a
			b=sumY/n - a*sumLnX/n; // calculo de b
		}
	}

	/*
	 * Metodo statico busquedaArray(Objeto array de Asignatura arrayObjeto, texto newCodigo) retorna texto
	 *		String nombre = null
	 *		Para i desde 0 hasta el tamaño de arrayObjeto
	 *			si newCodigo = codigo del array en el elemento i
	 *				nombre = nombre de la asignatura del elemento i
	 *			fin si
	 *		fin para
	 *		retorna nombre
	 * fin metodo
	 */


		/**
		 * Metodo que retorna el nombre de la asignatura correspondiente al codigo del parametro
		 *
		 *@param arrayObjeto, objeto Asignatura; newCodigo codigo que se introduce
		 *@return nombre de la asignatura
		 */
	public static String busquedaArray(Asignatura[] arrayObjeto, String newCodigo) {

		String nombre = null; // se inicializa el nombre de la asignatura con el valor que tendra si no se encuentra uno correspondiente
			// bucle for que recorre todo el array
		for (int i = 0; i<arrayObjeto.length ; i++) {

				// si el codigo parametro es igual al codigo del array
			if (newCodigo.equal(arrayObjeto[i].get(codigo))) {
				nombre = arrayObjeto[i].get(nombre); // retorna el nombre correspondiente al codigo
			}
		}		
		return nombre;
	}

		/**
		 * Metodo que retorna el nombre de la asignatura correspondiente al codigo del parametro
		 *
		 *@param arrayListObjeto, objeto Asignatura; newCodigo codigo que se introduce
		 *@return nombre de la asignatura
		 */
	public static String busquedaArrayList(ArrayList<Asignatura> arrayListObjeto, String theNewCodigo) {

			// bucle for que recorre todo el arrayList
		for (int i = 0; i<arrayListObjeto.size() ; i++) {

				// si el codigo parametro es igual al codigo del arrayList
			if (theNewCodigo.equal(arrayListObjeto[i].get(codigo))) {
				return arrayListObjeto[i].get(nombre); // retorna el nombre correspondiente al codigo
			} else {
				return null; // Si no se encuentra el codigo se retorna null
			}
		}
	}

		/**
		 * Metodo que calcula la desviacion estandar de un conjunto de datos a partir
		 * de las ecuaciones facilitadas por el profesor
		 *
		 *@param data array de datos
		 *@return desviacion estander
		 */
	public static double desviacionEstandar(double[] data) {

		double suma = 0; // se inicializa el sumatorio de data

			// bucle for each que suma todos los valores de data
		for (double elemento : data) {
			suma += elemento; // sumatorio de data
		}
		double media = suma / data.length-1; // calculo de la media (sumatorio / tamaño)

		double d = 0; // se inicializa el residuo

			// bucle for each que suma los residuos
		for (double elemento : data) {
			d += (elemento-media)*(elemento-media); // sumatorio de los residuos al cuadrado
		}

		return d / (data.length-2); // se retorna la desviacion estandar
	}
}
