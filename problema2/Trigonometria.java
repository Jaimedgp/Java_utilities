/**
*
* Esta clase calcula una serie de expresiones trigonometricas a partir de unos atributos
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 1.0
*
*/

public class Trigonometria {
	
	double alfa, beta; // ángulos en grados
	double w; //frecuencia angular en radianes/segundo
	double t; // tiempo en s
	double x; // sin unidades

		/**
    	* Se crea un metodo constructor que convierte los atributos en parametros del metodo
    	* Ademas convierte los angulos de grados a radianes
    	* No retorna nada
    	*/

	public Trigonometria(double alfa, double beta, double w, double t, double x) {

		this.alfa = alfa * (Math.PI/90.0); // angulo en radianes tambien se puede poner Math.toRadians()
		this.beta = beta * (Math.PI/90.0); // angulo en radianes
		this.w = w;
		this.t = t;
		this.x = x;

	}

		/**
		* Metodo que calcula la frecuencia angular a partir de alfa, beta y t
		* Retorna el valor de w
		* 
		* @return w
		*
		*/

	public double w(){

		w = Math.atan(alfa/beta)*(2.0/t); // o Math.atan2(alfa,beta)
		
		return w;
	}

		/**
		* Metodo que calcula el nuevo valor de beta a partir de alfa, t y el nuevo valor de w
		* Retorna el valor de beta
		*
		* return beta
		*
		*/

	public double beta() {

		beta = alfa * Math.sin(w*t); // como beta esta en el argumento como grados, no hace falta pasar alfa a radianes (NO SE HACE)
		return beta;
	}

		/**
		* Metodo que calcula el nuevo valor de x a partir de t y el nuevo w
		* Retorna el valor de x
		*
		* @return x
		*
		*/

	public double x() {

		x = Math.sqrt(Math.exp(t/2.0) * Math.cos(w*t));
		return x;
	}
}