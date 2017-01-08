/**
* 
* Clase que permite almacenar las medidas de un elipsoide en los atributos a, b, c y calcule su volumen
*
*
* Clase para crear y manejar Elipsoides
*
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 1.0
*
*/

public class Elipsoide {

	private double a, b, c;
	
		/**
    	* Se crea un metodo constructor que convierte los atributos en parametros del metodo
    	*
    	*
		* Recibe los valores de los semiejes del Elipsoide, en cm
		*
		* @param a semieje en la direccion X, en cm
		* @param b semieje en la direccion Y, en cm
		* @param c semieje en la direccion Z, en cm
		* 
		*
    	* No retorna nada
    	*/

	public Elipsoide(double a, double b, double c) {

		this.a = a;
		this.b = b;
		this.c = c;		
	}

		/**
		* Se crea un metodo que calcule el volumen del elipsoide segun los atributos del construcutor
		*
		*
		* Retorna el volumen del Elipsoide, en cm^3
		*
		* @return volumen dek Elipsoide, en cm^3
		*
		*
		* Retorna el valor del volumen V de tipo double
		*/

	public double volumen() {  // Los nombres de los metodos empiezan por minusculas

		double V = (4.0/3.0)* Math.PI * a*b*c; // Es preferible no guardar el resultado en una variable sino directamente retornar la ecuacion
		return V;

		// El punto zero {4.0} no hace falta si no se hace directamente la fraccion {4* Math.PI * a*b*c/3;}

		// return (4.0/3.0)* Math.PI * a*b*c; FORMA CORRECTA SIN LA ECUACION NO ES EXCESIVAMENTE LARGA
	}
}