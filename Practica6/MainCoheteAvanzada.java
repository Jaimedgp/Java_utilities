import fundamentos.*;

/**
* Clase main que printa en pantalla los datos de la clase cohete 
*   segun la parte avanzada
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 4 Abril 2016
*
*/

public class MainCoheteAvanzada {

	public static void main(String[] args) {
		
		Lectura atributos = new Lectura("Atributos"); //
			atributos.creaEntrada("velocidad de salida de los gases, m/s", 0.0); // Longitud del pendulo
			atributos.creaEntrada("combustible quemado por segundo, Kg/s", 0.0); // Masa del pendulo
			atributos.creaEntrada("masa inicial del cohete y su combustible inicial, Kg", 0.0); // Amplitud maxima en grados
			atributos.creaEntrada("masa de combustible inicial, Kg", 0.0); // Fase del metodo en grados

			atributos.espera("Introduce los atributos del cohete y pulsa Aceptar");

			double u1 = atributos.leeDouble("velocidad de salida de los gases, m/s");
			double d1 = atributos.leeDouble("combustible quemado por segundo, Kg/s");
			double m01 = atributos.leeDouble("masa inicial del cohete y su combustible inicial, Kg");
			double c1 = atributos.leeDouble("masa de combustible inicial, Kg");

		Lectura tiempos = new Lectura("Tiempos");
			tiempos.creaEntrada("Tiempo 1", 0.0);
			tiempos.creaEntrada("Tiempo 2", 0.0);
			double t1 = tiempos.leeDouble("Tiempo 1");
			double t2 = tiempos.leeDouble("Tiempo 2");

		Cohete apolo11 = new Cohete(u1, d1, m01, c1);

		Escritura cohete1 = new Escritura("Apolo 11");
		cohete1.insertaValor("T0", apolo11.t0() + "s");
		cohete1.insertaValor("Tmax", apolo11.tmax() + "s");
		cohete1.insertaValor("Velocidad en Tmax", apolo11.vmax() + "m/s");
		cohete1.insertaValor("Altura maxima", apolo11.altmax() + "m");
		cohete1.insertaValor("velocidad en t0/2", apolo11.v(apolo11.t0()/2.0) + "m/s");
		cohete1.insertaValor("velocidad en t1", apolo11.v(t1) + "m/s");
		cohete1.insertaValor("velocidad en t2", apolo11.v(t2) + "m/s");
		cohete1.insertaValor("Posicion en t0/2", apolo11.x(apolo11.t0()/2.0) + "m");
		cohete1.insertaValor("Posicion en t1", apolo11.x(t1) + "m");
		cohete1.insertaValor("Posicion en t1", apolo11.x(t1) + "m");
		cohete1.insertaValor("Posicion en Tmax", apolo11.x(apolo11.tmax()) + "m");
	}
}