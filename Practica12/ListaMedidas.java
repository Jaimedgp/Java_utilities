import java.util.*;
import java.io.*;

/**
 * Esta clase almacena una lista de medidas eléctricas de un
 * circuito y dispone de métodos para interpretar estas medidas
 *
 * @author JaimeDGP
 * @version 16 Mayo 2016
 */

public class ListaMedidas {

		// atributo que contiene la lista de medidas
	private ArrayList<MedidaElectrica> lista;



		/**
		 *  Constructor que crea la lista de medidas y, leyendo con
		 * el método mide(), le añade 10000 medidas del circuito
		 * y nudo indicados en los parámetros.
		 * Las medidas que lancen FueraRango se ignoran y no
		 * se almacenan en la lista, pero se sigue leyendo hasta
		 * completar las 10000 llamadas al método mide().
 		 * Por tanto, el tamaño final de la lista es igual a 10000
 		 * si no hay errores, o menor si hay errores.
		 *
		 * @param c, objeto de la clase Circuito y numNudo
		 */
	public ListaMedidas(Circuito c, int numNudo) {
	    
	    lista = new ArrayList<MedidaElectrica>(); // se crea el arrayList 

	    	// añade 10000 medidas del metodo mide
		for (int i=0; i<10000 ; i++) {
			try{
				lista.add(c.mide(numNudo));
			} catch (FueraRango e) { // salta el error

			} 
		}
	}

		/**
		 * Escribe la lista de medidas en el fichero de texto cuyo
		 * nombre se indica. Se escribe cada medida (compuesta por
		 * tiempo, voltaje e intensidad) en una línea, usando
		 * columnas de 15 caracteres de ancho y 3 decimales para
		 * cada valor.
		 * Se escribe al principio del fichero una cabecera con el
		 * texto:
		 * tiempo(s) voltaje(V) intensidad(A)
		 */
	public void escribe(String nombreFichero) {
		
			// tratamiento de error
		try (PrintWriter out = new PrintWriter(new FileWriter (nombreFichero))) { // abre el fichero
		
			out.printf("%15s %15s %15s %n", "tiempo(s)", "voltaje(V)", "intensidad(A)"); // escribe los titulos

				// recorre el arrayList lista
			for (MedidaElectrica q : lista) {
				out.printf("%15.3g %15.3g %15.3g %n", q.getTiempo(), q.getVoltaje(), q.getIntensidad()); // escribe los datos
			}

		} catch (IOException e) {
		
		}
	}

		/**
		 * Valores en rango: retorna true si todos los valores de
		 * voltaje e intensidad están dentro de los rangos indicados
		 * (incluidos los valores extremos), y false en caso
		 * contrario. Los voltajes van en V y las intensidades en A.
		 * Se utiliza uno de los patrones de búsqueda vistos
		 * en clase
		 *
		 * @param valores minimos y maximos de los rangos
		 * @return boolean si la intensidad esta en los rangos indicados
		 */
	public boolean valoresEnRango(double voltajeMin, double voltajeMax, double intensidadMin, double intensidadMax) {

			// recorre el arrayList lista
		for (MedidaElectrica w: lista) {
				// si no se encuentra entre [min volt, max volt]
			if (voltajeMin > w.getVoltaje() || voltajeMax < w.getVoltaje()) {
				return false; // returna false

				// si no se encuentra entre [max inten, min inten]
			} else if (intensidadMin > w.getIntensidad() || intensidadMax < w.getIntensidad()) {
				return false; // retorna false
			}
		}
		return true; // sino retorna true
	}

		/* Retorna un array de reales que contiene la derivada del
		 * array x, con respecto al array t. Los arrays x y t deben
		 * ser del mismo tamaño. Si no lo son o si su longitud es
		 * menor que 2 se lanza LongitudIncorrecta.
		 * La solución a retornar es un array de una casilla
		 * menos que x y t.
		 * El contenido de este array, que es la derivada, se calcula
		 * así:
		 * Para cada casilla i de la derivada desde la primera
		 * a la última, la derivada es el incremento de x entre las
		 * casillas i e i+1 dividido por el incremento de t entre las
		 * casillas i e i+1: (x[i+1]-x[i])/(t[i+1]-t[i])
		 */
	private double[] derivada(double[] x, double[] t) throws LongitudIncorrecta {

			// si ambos arrays son de distinto signo o menor que 2
		if (x.length != t.length || x.length < 2) {
			throw new LongitudIncorrecta(); // reporta error
		}

			// se crea array de tamanho x-1
		double derivada[] = new double[x.length-1];

			// calcula la derivada en el punto i 
		for (int i = 0; i<x.length-1 ; i++) {
			derivada[i] = (x[i+1]-x[i])/(t[i+1]-t[i]);
		}

		return derivada; 
	}

		/**
		 * Retorna el número de medidas para las que la intensidad
		 * o el voltaje tiene cambios muy bruscos, contando los
		 * puntos en que la derivada sea muy grande (mayor que el
		 * límite indicado en los parámetros, en valor absoluto)
		 * Los parámetros están en V/s y A/s
		 */
	 public int numCambiosRapidos(double limiteDerivVolt, double limiteDerivInten) {

	 		//obtener el voltaje, intensidad y tiempo en arrays separados
	 	double[] volt = new double[lista.size()];
	 	double[] inten = new double[lista.size()];
	 	double[] t = new double[lista.size()];

	 	for (int i = 0; i < lista.size(); i++) {
	 	 	volt[i] = lista.get(i).getVoltaje();
	 	 	inten[i] = lista.get(i).getIntensidad();
	 	 	t[i] = lista.get(i).getTiempo();
	 	 } 

	 		// inicializar el contador de puntos con cambios bruscos
	 	 int contador = 0;

		 try { 

		 	 	// calcular las derivadas del voltaje y la intensidad usando el metodo derivada
		 	double[] derivVolt = derivada(volt, t);
			double[] derivInten = derivada(inten, t);

		 	 	// contar puntos con cambios bruscos de voltaje o intensidad
		 	for (int i = 0; i< derivVolt.length; i++) {
		 	 	if (Math.abs(derivVolt[i]) > limiteDerivVolt || Math.abs(derivInten[i]) > limiteDerivInten) {
		 	 		contador++;
		 	 	}
		 	 }
		} catch (LongitudIncorrecta e) {
			System.out.println("Error");
		}
	 		// retorna la respuesta
	 	return contador;
	 }
}