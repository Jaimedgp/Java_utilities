import java.util.*;
import java.io.*;
import fundamentos.*;

/**
 * Clase resumen de la asignatura Programación en la que se pretende 
 * utilizar todos comandos y estructuras vistas en clase
 *
 * @author JameDGP
 * @version 25 Mayo 2016
 * @github https://github.com/Jaimedgp
 */

public class Examen {
	
	private int entero;
	private ArrayList<Object> arraylist;
	private static final PI = 3.14;

		/**
	 	 * Metodo constructor de la clase Examen este metodo ha de
	 	 * tener el mismo nombre que la clase con mayuscula la primera letra
	 	 * sin retornar nada
	 	 */
	public nombreMetodo(String texto, double real) {
	 	this.texto = texto;
	 	this.real = real;

	} 

		/**
		 * Comentario del metodo
		 *
		 * @param 
		 * @return 
		 * @throws 
		 */
	public ArrayList<String> leer(String nomFich) {
		
		try (Scanner in= new Scanner(new FileReader(nomFich))) {
				// lee el fichero línea a línea
			while (in.hasNextLine()) {
				
			}
		} catch (FileNotFoundException e) {
		 System.out.println("Error abriendo fichero");
		}
	}

		/**
		 * Comentario del metodo
		 *
		 * @param 
		 * @return 
		 * @throws 
		 */
	public void nombreMetodo() {
	
		try (PrintWriter out=new PrintWriter(new FileWriter(nomFich))) {
				out.printf("%-25s DNI:%s Nota:%4.1f%n", a.nombre(),a.dni(), a.nota());
		} catch (IOException e){
			System.out.println("Error al abrir nomFich"));
		}
			 	
	}

 }