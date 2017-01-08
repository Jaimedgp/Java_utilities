import java.util.*;
import java.io.*;
import fundamentos.*;

/**
 * Clase principal 
 *
 * @author JaimeDGP
 * @version 22 Mayo 2016
 */

public class Principal {

		// Metodo principal del programa
	public static void main(String[] args) {
		
			// ArrayList vacio de objetos de la clase DatosPIB
		ArrayList<DatosPIB> producto = new ArrayList<DatosPIB>();

		try (Scanner pib = new Scanner(new FileReader("evolucion_pib.txt"))) {

				// Se ignoran las 2 primeras lineas
			pib.nextLine();
			pib.nextLine();
			boolean mientras = pib.hasNextLine();

			while (pib.hasNext()) {

				int fecha = pib.nextInt();
				int pibi = pib.nextInt();
				String var = pib.next().split("%")[0];

				var = var.replace(",", ".");
				double variacion = Double.parseDouble(var);

				DatosPIB objeto = new DatosPIB(pibi, variacion, fecha);
				producto.add(objeto);
			}

			Grafica pib_anho = new Grafica("PIB por año", "Año", "PIB");

			pib_anho.ponTitulo("PIB por año");
			for (DatosPIB e : producto) {
				pib_anho.inserta(e.getFecha(), e.getPib());	
			}
			pib_anho.pinta();

			Grafica var_anho = new Grafica("Variacion por año", "Año", "Variacion");

			var_anho.ponTitulo("Variacion por año");
			for (DatosPIB e : producto) {
				var_anho.inserta(e.getFecha(), e.getVariacion());
			}
			var_anho.pinta();


		} catch (FileNotFoundException e) {
				System.out.println("Erro al leer evolucion_pib.txt");
		}
	}
}