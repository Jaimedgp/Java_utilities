import java.util.*;
import java.io.*;

/**
 * Problema 8 
 *
 * @author JaimeDGP
 * @version 23 Mayo 2016
 */

public class Problema8 {

    /**
     * Metodo Principal que crea un archivo de texto con las 
     * temperaturas en Fahrenheit y su conversion en Celsius
     */
    public static void main(String[] args) {

        double c;

		// Se crea el objeto para escribir el archivo “temperaturas.txt” con su tratamiento de error
        try (PrintWriter write = new PrintWriter(new FileWriter ("temperaturas.txt"))) {

            read.setDefault(Locale.ENGLISH); // USAR EL LOCALE DE INGLES

            	// bucle de [-20ºF, 120ºF] de 10 en 10 USANDO NUMEROS REALES
            for (double f = -20; f <= 120; f += 10) {
                	// si se pone texto no definido en una variable, se escribe tal cual en el texto
                write.printf("%12g F  %12.1f C  %n", f, (f-32)/1.8; // Escribe los datos en el fichero
            }
		// tratamiento de error
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo temperaturas.txt");
        }
    }

    /**
     * Metodo que retorna un array con los 10 primeros
     * números reales contenidos en dicho fichero.
     *
     * @param nombreFichero nombre del fichero a leer
     * @return array de 10 primeros numeros reales
     * @throws NoSuchElementException si no hay 10 numeros reales
     */
    public static double[] leeDatosDeFich(String nombreFichero) throws NoSuchElementException {

        double[] diezNum = new double[10]; // se inicializa el array de tamaño 10

        // se crea el objeto para leer el archivo nombreFichero
        try (Scanner read = new Scanner(new FileReader(nombreFichero))) {

        	read.useLocale(Locale.ENGLISH);


/*
 * Con el bucle for tambien se podia poner que primero se utilice un bucle while para 
 * saber si el siguiente elemento es un Double y si no se pasa al siguiente y sino se
 * almacena el numero
 *      
 *      for (int i = 0; i< diezNum.length; i++) {
 *            while (!read.nextDouble()) {
 *              read.next();
 *          }
 *          diezNum[i] = read.nextDouble();
 *      }
 */

                // bucle que recorre el array diezNum
            for (int i = 0; i< diezNum.length; i++) {
                    // si el siguiente elemento es un double
                if (read.hasNextDouble()) {
                        // sustituye el elemento i de diezNum 
                        // por el elemento double del fichero
                    diezNum[i] = read.nextDouble(); 

                    // si no es un double pero queda mas elementos por leer
                } else if (read.hasNext()){ 
                    read.next(); // pasa al siguiente elemento del fichero
                    i -= 1; // no avanza de elemento del array
                } else { // si no quedan elementos por leer pero el bucle no ha finalicado
                    throw new NoSuchElementException(); // se lanza la excepcion
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("Error a leer el archivo " + nombreFichero);
            return null;
        }
        return diezNum;
    }

        /**
         * Metodo que analiza si hay llaves desparejadas en un codigo 
         * fuente y devuelve true si estan desparejadas y false si no
         *
         * @param nombreFichero nombre del codigo fuente
         * @return boolean true si estan las llaves desparejadas
         */
    public static boolean codigoFuente(String nombreFichero) {

    	boolean malaEstructura = false;

        double contador = 0; // se inicializa el contador

            // se crea el objetoque lee el archivo
        try(Scanner read = new Scanner(new FileReader(nombreFichero))) {
                // bucle que lee el archivo hasta que no halla lineas que leer
            while (read.hasNextLine()) {

            		// se lee la linea y se almacena en un String
            	String lineaLeida = read.nextLine();

            	if (lineaLeida.indexOf("{") >= 0) {
            		contador++; // se suma 1 al contador
            	}

            	if (lineaLeida.indexOf("}") >= 0) {
            		contador = contador - 1; // se resta 1 al contador
            	}

       			System.out.println(contador);
            	
            	if (contador < 0) {
            		malaEstructura = true;
            	}
            }            
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido abrir el archivo");
        }

        if (contador != 0) {
            malaEstructura = true;
        }
        return malaEstructura;
    }
}
