  //////////////////////////////////////////////////////////////////
 ///////                                               ////////////
//////////////////////////////////////////////////////////////////

// el incremento n = n +1 tambien se puede escribir como n ++
// el decremento n = n - 1 tambien se puede escribir como n --


  //////////////////////////////////////////////////////////////////
 ///////            CLASE CON METODOS                  ////////////
//////////////////////////////////////////////////////////////////

/**
* La clase contiene tres notas de un alumno
*/

public class Notas {
	
	private int nota1;
	private int nota2;
	private int nota3;

	// Tambien se puede poner int nota1, nota2, nota3;
	// Los atributos suelen ser privados para evitar que sean utilizados o cambiados por otras clases

	/**
	* Las tres notas se pasan de atributos como argumentos del metodo
	* No retorna nada
	*/

	public ponNotas(int nuevaNota1, int nuevaNota2, int nuevaNota3){		// Al no poner void lo que creamos es un constructor
		
		nota1 = nuevaNota1;
		nota2 = nuevaNota2;
		nota3 = nuevaNota3;
	}


		/**
		* Constructor que te pine las tres notas
		* No tiene incluido ningun void ni double y el nombre es el mismo que el de la clase
		*/

	public Notas (int n1, int n2, int n3){

		nota1 = n1;
		nota2 = n2;
		nota3 = n3;
	}


	/**
	* Se calcula la media entera de las nuevas notas asignadas en el metodo anterior
	* Retorna el valor de la media entera
	*/

	public int mediaEntera(){    //Siempre hay que especificar si se trata de void o double ...

		int notaMediaEntera = (nota1 + nota2 + nota3)/3; // el escribir el tres como 3.0 hace que Java nos responda con un numero decimal

		return notaMediaEntera;		//Como norma general los metodos no pintan en pantalla (System.out.println), retornan (return)
	}


	/**
	* Se calcula la media real de las nuevas notas asignadas en el metodo ponNotas
	* Retorna el valor de la media real
	*/

	public double mediaReal(){

		double notaMediaReal = (nota1 + nota2 + nota3)/3.0;

		return notaMediaReal;

	}

}

  //////////////////////////////////////////////////////////////////
 ///////             BUCLE IF                          ////////////
//////////////////////////////////////////////////////////////////


public class Marzo23 {

	public static void main(String[] args) {
		
		if (condicion) {
			instruccion1;
			
			}

			else {
				instruccion2;
		}

		if (nota >= 5.0) {
			System.out,println("Aprobado");
		
			if (nota >= 9.0) {
				System.out.println(" cum laude");
			}
			else{
				System.out.println(" ");
			}
		}

		else {
			System.out.println("Sustenso");
		}

		////////////////////////////////////////////////////

		boolean esBisiesto;

		int year = ;

		if (year % 4 == 0) {
			if (year %100 == 0) {
				if (year % 400 == 0) {

					esBisiesto = true;					
				}

				else {

					esBisiesto = false;
				}
			}

			else {
				esBisiesto = true;
			}
		}
		else {
			esBisiesto = false;
		}
		
	}

}


  //////////////////////////////////////////////////////////////////
 ///////                 SWITCH                        ////////////
//////////////////////////////////////////////////////////////////

public String convierte() {

	String notaLetra;

	switch (notaMedia) {

		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			notaLetra = "Suspenso";
			break;
		case 5:
		case 6:
			notaLetra = "Aprobado";
			break
		case 7:
		case 8:
			notaLetra = "Notable";
			break
		case 9:
		case 10:
			notaLetra = "Sobresaliente";
			break
		default:
			notaLetra = "Error";

	}
}

  //////////////////////////////////////////////////////////////////
 ///////                BUCLE WHILE                    ////////////
//////////////////////////////////////////////////////////////////

import fundamentos.*;

public class Apuntes {

	public static void main(String[] args) {
		
		Lectura apuntes = new Lectura("Apuntes");

		apuntes.creaEntrada("Introduce el numero", 0.0);
		apuntes.espera("Introduce el numero y pulsa Aceptar"); // Espera hasta apretar el boton Aceptar para continuar
		double i = apuntes.leeDouble("Numero");
		double suma = 0;
		double maxim = -Double.MAX_VALUE; // El mínimo valor posible

		while (i>=0) {

			suma = suma + i;

			if (i>max) {
				
				max = i;

			}

			apuntes.creaEntrada("Introduce el numero", 0.0);
			apuntes.espera("Introduce los datos del pendulo y pulsa Aceptar"); // Espera hasta apretar el boton Aceptar para continuar
			double i = apuntes.leeDouble("Introduce el numero");


			
		}

	}
}

  //////////////////////////////////////////////////////////////////
 ///////                 ARRAYS                        ////////////
//////////////////////////////////////////////////////////////////


	// type[] name = new type[size]
double[] newarray = new double[24]; // create array type double size 24 elements 0,1,2,...,23

int[] diasMes = new int[12];

int[] diasMes = {1,2,3,4,5,5,6,7,8,9,1,2};

	/////////////////////////////////////////

	public class Clase {
		public double calculaMax() {

			double[] datos = new double[10];

			Lectura p = new Lectura("Datos");

			for (int i; i<10; i++) {
				p.creaEntrada("Dato" + (i+1), 0);

			}
			
			p.esperaYCierra();

			for (int i =0; i<10; i++) {
				
				datos[i] = p.leeDouble("Dato" + (i+1));
			}

			double max = - Double.MAX_VALUE;
		}
	}

/////////////////////////////////////////////////////////////////

	/* Tambien se puede recorrer la array definiendo el bucle for de otra forma
	 * 
	 * 		for (double x: name_array) {
	 *			//trabaja con x
	 *		}
	 *
	 */


////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////

try (Scanner in = new Scanner(____)) {
	in.useLocale(Locale.ENGLISH);
	while (in.hasNext()) {
		String palabra = in.next();
		System.out.println("Palabra: " + palabra);
		while (in.hasNextDouble()) {
			double d = in.nextDouble();
			System.out.println("Numero: " + d);
		}
	}
}

///////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////

public class Colores {

	public enum Color {ROJO, VERDE, AZUL}; // Color solo puede tomar los valores {ROJO, VERDE, AZUL}

	public static void main(String[] args) {
		Color c = Color.Rojo;
		Color.values()	}
}