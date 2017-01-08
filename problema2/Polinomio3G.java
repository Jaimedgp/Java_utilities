/**
*
* Esta clase calcula el valor de la funcion de tercer grado definida por 
* sus cuatro coeficientes a, b, c y un valor x.
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 1.0
*
*/


public class Polinomio3G {

	private double a,b,c,d; // Los cuatro coeficientes de la ecuacion

		/**
    	* Se crea un metodo constructor que convierte los atributos en parametros del metodo
		*
		* @param a parametro cubico
		* @param b parametro cuadratico
		* @param c parametro lineal
		* @param d parametro independiente
		*
    	* No retorna nada
    	*/

	public Polinomio3G() {

		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

		/**
		* Se crea un metodo con el parametro x de la funcion que calcula el valor de dicha funcion f
		* Retorna el valor de la funcion f
		*
		* @return valor de la ecuacion
		*
		*/

	public double calculo(double x){

		double f = (a*x*x*x) + (b*x*x) + (c*x) + d; // Calcula la funcion
		return f; // retorna elvalor de f
	}
}