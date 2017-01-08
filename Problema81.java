import java.util.*;
import java.io.*;
/**
 * Problema 8 y ultimo
 *
 * @author JaimeDGP
 * @version 23 Mayo 2016
 */

public class Problema8 {

	public static double[] leeDatosFichero(String nombre) {

		double[] diezNum = new double[10];

		try(Scanner read = new Scanner(new FileReader(nombre))) {

			for (int i = 0; i<10 ; i++) {
				try {
					diezNum[i] = read.nextDouble();
			
				} catch (NumberFormatException e){
					i = i -1;
				} catch (NoSuchElementException e){
					i = i -1;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer " + nombre);
		}
		return diezNum;
	}

	public static boolean desparejado(String nombre){

		int contador = 0;

		try(Scanner read = new Scanner(new FileReader(nombre))) {

			while (read.hasNextLine()) {
			    String k = read.next();
				if (k == "{") {
					contador++;
				} else if (k == "}") {
					contador = contador - 1;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("42");
		}

		if (contador == 0) {
			return false;
		} else {
			return true;
		}
	}
}