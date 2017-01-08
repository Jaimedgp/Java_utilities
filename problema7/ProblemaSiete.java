/**
 * Clase principal que ejecuta los metodos de la clase Raiz
 *
 * @author JaimeDGP
 * @version 10 Abril 2016
 */

public class ProblemaSiete{

		/**
		 * Invoca repetidamente el método leeHumedad hasta que se produzca
		 * una lectura correcta o hasta que se alcance el número máximo de
		 * intentos indicado.
		 * @param numIntentos número máximo de intentos
		 * @return la humedad retornada por la primera lectura correcta de
		 *   leeHumedad o Double.NaN en el caso de que todos los intentos
		 *   sean lecturas incorrectas.
		 */
	public double leeHumedadReintentando(double numIntentos) {

		boolean medida = true; // se inicializa la variable que ejecuta el if

			// bucle que realiza 1000 intentos de invocar al metodo
		for (int i = 0; i<= numIntentos; i++) {
				// realiza el try si medida es true
			try { //tratamiento de error
				return leeHumedad(); // intenta invocar al metodo
			} catch (LecturaIncorrecta e) { // se lanza la excepcion
			}
		}
		
		return Double.NaN;
	}


		/**
		 * Calcula el valor de la funcion f(x)=x^3-5x^2-28x+32 en el punto x 
		 * @param x valor en el que se calcula f(x)
		 * @return el valor de f(x)
		 */
	public static double ecuacion(double x) {

		return x*x*x-5*x*x-28*x+32; // retorna el valor de f(x)
	}
	
		/**
		 * Intenta hallar el valor de la raiz de f(x) del metodo ecuacion()
		 * entre los valores a y b mediante el algoritmo de la biseccion siempre
		 * que a y b sean de mismo signo. Como valor de la raiz valdra aquel punto
		 * cuyo f(x) sea cercano a 0 o el punto medio entre ambos en el momento en 
		 *el que b-a sea menor de un valor
		 *
		 * @param a, b valores entre los que se calcula la raiz
		 * @return raiz de la funcion f(x)
		 * @throws SignosIguales cuando a y b son del mismo signo
		 */ 
	public static double biseccion(double a, double b)  throws SignosIguales { 

		double epsilon = 1e-8); // margen de error para la raiz f(c) € -epsilon< 0 <epsilon
		double c;
			// condicional que lanza la excepcion SignosIguales
		if ((ProblemaSiete.ecuacion(a)/ProblemaSiete.ecuacion(b))>0) {
			throw new SignosIguales();
		}

			// bucle do-while
		do{
			c = (a+b)/2; // se vuelve a calcular c
				// si f(a) y f(c) son de igual signo reemplaza a por c
			if ((ProblemaSiete.ecuacion(c)/ProblemaSiete.ecuacion(a))>0) { 
				a = c;

				// si f(b) y f(c) son de igual signo reemplaza b por c
			} else if ((ProblemaSiete.ecuacion(c)/ProblemaSiete.ecuacion(b))<0) {
				b = c;
			}

				// Siempre que c sea = 0 +- epsilon tolerancia es false de tal forma que se para el while
			if (!(ProblemaSiete.ecuacion(c)<-epsilon || ProblemaSiete.ecuacion(c)>epsilon)) {
				tolerancia = false;
			}

			// realiza la operacion hasta que hasta que f(c) sea cercano a cero más menos un margen 
			// epsilon=10-8, o hasta que b-a sea menor en valor absoluto a una tolerancia=10-5
		} while ( Math.abs(b-a)>=1e-5) && (Math.abs(ProblemaSiete.ecuacion(c))>epsilon);
		

		return c;  //tras el while el punto intermedio c es la raíz buscada.
	}

		/**
		 * Metodo main que invoca y printa las raices obtenidas por el metodo biseccion
		 */
	public static void main(String[] args) {
		
		try{ // tratamiento de excepciones
			System.out.println("La raiz encontrada entre los valores -10 y -2 es: " + Raiz.biseccion(-10,-2)); // raiz entre [-10,-2]
			System.out.println("La raiz encontrada entre los valores -2 y 4 es: " + Raiz.biseccion(-2,4)); // raiz entre [-2,4]
			System.out.println("La raiz encontrada entre los valores 4 y 12 es: " + Raiz.biseccion(4,12)); // raiz entre [4,12]
		} catch (SignosIguales e) { // Se lanza el error
			System.out.println(e); // mensaje de error
		}
		try { // tratamiento de excepciones
			System.out.println("La raiz encontrada entre los valores -1 y -2 es: " + Raiz.biseccion(-2,-1)); // raiz entre [-2,-1]
		} catch (SignosIguales e) { // se lanza el error 
			System.out.println("La excepcion "+e+"se ha lanzado correctamente"); // mensaje de error
		}
	}
}