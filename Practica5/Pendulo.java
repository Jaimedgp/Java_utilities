/**
*
* Clase que guarda los datos sobre el pendulo y calcula mediante diversos
* metodos la frecuencia y posicion angular. Pertenece al proyecto relativo
* a la practica numero 5 de la clase de programacion.
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 21·Marzo·2016
*
*/

public class Pendulo {

	private double lon; // Longitud del pendulo en metros
	private double m ; // Masa del pendulo en kilogramos
	private double thetaMax; // Amplitud maxima en radianes
	private double phi; // Fase del pendulo en radianes

		/**
		* Constructor que crea el objeto pendulo y para los atributos a parametros
		*
		* @param L, m, Theta, fase
		*/
	public Pendulo(double lon, double m, double thetaMax, double phi) {

		this.lon = lon;
		this.m = m;
		this.thetaMax = thetaMax;
		this.phi = phi;
	}

		/**
		* Metodo que calcula la frecuencia angular en segundos a partir del periodo
		* 
		* @return frecuencia 
		*/
	public double frecuenciaAngular() {

		return Math.sqrt(9.8/lon);
	}

		/**
		* Metodo que calcula la posicion angular en radianes en funcion del parametros tiempo
		*
		* @param temp
		* @return posicion angular
		*/
	public double posicionAngular(double temp) {

		return thetaMax * Math.sin(frecuenciaAngular()*temp + phi);
	}
}