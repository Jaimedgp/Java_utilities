import fundamentos.*; // importa todos los archivos fundamentos

/**
*
* Clase que contiene el metodo main para ejecutar la clase pendulo
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 21·Marzo·2016
*
*/

public class OperaPendulo {

	public static void main(String[] args) {
		
		Lectura pendulo = new Lectura("Pendulo"); // Objeto de la clase Lectura del paquete fundamentos para leer datos por pantalla

		pendulo.creaEntrada("Longitud del pendulo en m", 0.0); // Longitud del pendulo en m
		pendulo.creaEntrada("Masa del pendulo en Kg", 0.0); // Masa del pendulo en Kg
		pendulo.creaEntrada("Amplitud maxima en grados", 0.0); // Amplitud maxima en grados
		pendulo.creaEntrada("Fase del metodo en grados", 0.0); // Fase del metodo en grados

		pendulo.espera("Introduce los datos del pendulo y pulsa Aceptar"); // Espera hasta apretar el boton Aceptar para continuar
		double operaLon = pendulo.leeDouble("Longitud del pendulo en m"); // Se crea una nueva variable con el valor metido por teclado de la longitud
		double operaM = pendulo.leeDouble("Masa del pendulo en Kg"); // Se crea una nueva variable con el valor metido por teclado de la masa
		double operaThetaMax = pendulo.leeDouble("Amplitud maxima en grados"); //Se crea una nueva variable con el valor metido por teclado de la amplitud maxima
		double operaPhi = pendulo.leeDouble("Fase del metodo en grados"); // Se crea una nueva variable con el valor metido por teclado del desfase

			// Se pasan los datos del desfase y la amplitud maxima de grados a radianes

		operaThetaMax = Math.toRadians(operaThetaMax);
		operaPhi = Math.toRadians(operaPhi);

		Pendulo penduloMat = new Pendulo(operaLon, operaM, operaThetaMax, operaPhi); // Se crea el objeto pendulo con los datos metidos por teclado

		double w = penduloMat.frecuenciaAngular(); // se guarda en una variable el valor retornado por el metodo frecuenciaAngular de la clase pendulo

			// se guarda en una variable el valor de posicionAngular para los tiempos 0.5, 1, 1.5

		double temp1 = penduloMat.posicionAngular(0.5); 
		double temp2 = penduloMat.posicionAngular(1);
		double temp3 = penduloMat.posicionAngular(1.5);

			// Se printan los resultados por pantalla usando la clase Escritura del paquete fundamentos

		Escritura sistema1 = new Escritura("\t" + "Pendulo" + "\n"); // Objeto de la clase Escritura 
		sistema1.insertaValor("frecuencia angular :", w + "s"); // Se crea una caja para w
		sistema1.insertaValor("Posicion angular (t=0.5s) :", Math.toDegrees(temp1) + "grados"); // Se crea una caja para temp1
		sistema1.insertaValor("Posicion angular (t=1s) :", Math.toDegrees(temp2) + "grados"); // Se crea una caja para temp2
		sistema1.insertaValor("Posicion angular (t=1.5s) :", Math.toDegrees(temp3) + "grados"); // Se crea una caja para temp3

		sistema1.espera(); // Espera hasta apretar el boton Aceptar para continuar
		
	}
}