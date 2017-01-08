import java.util.*;

public class ProblemaSeis {

		/**
		 * Método al que se le pasa como parámetro un array de Strings y retorna un ArrayList de Strings,
		 * conteniendo aquellos Strings del array original que comiencen por una letra mayúscula.
		 *
		 * @param String[] textos array de Strings
		 * @return ArrayList con los Strings de textos que comiencen con mayuscula
		 */
	public  static ArrayList<String> seleccionStrings(String[] textos) {

			/*
			 * Si el metodo es estatico se debera crear este objeto
			 * Si el metodo no es estatico no hay que crearlo pues se 
			 * 	podra calcular con un objeto creado fuera del metodo
			 */
		ArrayList<String> text = new ArrayList<String>(); // Se inicializa el ArrayList 

			// bucle for (each) que recorre todos los elementos del array
		for (String element : textos) {

				// Condicional si la primera letra del elemento es mayuscula
			if (Character.isUpperCase(element.charAt(0))) {
				text.add(element); // Si se cumple la condicion se almacena en el arrayList text
			}
		}

		return text; // Retorna el ArrayList con todos los Strings seleccionados
	}

		/**
		 * Clase principal que muestra por pantalla los datos de la clase Hogar y que realiza un tratamiento de error en caso de 
		 * producirse.
		 *
		 * @author JaimeDGP
		 * @version 2 May 2016
		 */
	public static void main(String[] args) {

		Hogar home = Hogar("electrodomesticos.txt"); // Crea un objeto de la clase Hogar a partir del fichero de nombre "electrodomesticos.txt"
		
		try { // tratamiento de error
			home.listadoElectrodoméstico("Lavadora"); // Se invoca al metodo listadoElectrodomestico de la clase Hogar
			home.listadoElectrodoméstico("Luces"); // Se invoca al metodo listadoElectrodomestico de la clase Hogar
			System.out.println(home.consumoAnualHogar()); // Se muestra en pantalla el consumo anual del hogar obtenido mediante consumoAnualHogar()
		} catch (NoEncontrado e) { // en caso de error NoEncontrado
			System.out.println("Lo siento se ha producido un error, intentelo de nuevo"); // Se muestra en pantalla un mensaje de error
		}
		try { // tratamiento de error
			System.out.println(home.listadoElectrodoméstico("xxxx"));
		} catch (NoEncontrado e) {
			System.out.println("Lo siento se ha producido un error, intentelo de nuevo"); // Se muestra en pantalla un mensaje de error
		}
	}

		/**
		 * Metodo que retorna el valor del metodo estatico medida() de la clase Experimento
		 * Este metodo realiza un tratamiento de errores. si al invocar el metodo medida() se produce el 
		 * error MedidaInestable, retorna 0.0; si se lanza el error MedidaErronea retorna NaN. en ambos casos se muestra un mensaje de error
		 *
		 * @return medida()
		 */
	public static double tratamiento() {

		try { // realiza la accion
			return Experimento.medida(); // Si no hay error retorna Experimento.medida()
		} catch (MedidaInestable e) { // Si se produce el error MedidaInestable
			System.out.println("Se ha producido un error"); // Se muestra un mensaje de error
			return 0.0; // retorna 0.0
		} catch (MedidaErronea e) { // Si se produce el error MedidaErronea
			System.out.println("Se ha producido un error"); // Se muestra un mensaje de error
			return Double.NaN; // Retorna NaN
		} 
	}
}