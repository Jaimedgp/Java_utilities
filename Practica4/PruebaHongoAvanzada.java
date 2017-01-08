/**
*
* Esta clase crea un objeto de la clase Hongo y calcula el diametro de la colonia cada t tiempo para la parte avanzada utilizando la clase Escritura
* para printar los resultados en tablas segun esa clase del paquete fundamentos
*
* Programa escrito por Jaime Diez Gonzalez-Pardo
*
* Version 1.0
*
*/

import fundamentos.*; // importa todos los archivos fundamentos

public class PruebaHongoAvanzada {

		/**
		* Se crean dos objetos de la clase RhizopusOryzae y se calculan sus diametros para tres tiempos: 0h, 50h, 150h
		*/

	public static void main(String[] args) {
		
		RhizopusOryzae setas = new RhizopusOryzae(0, 3.5, 0.36, 0.06, 10.0/24.0, 2.757, "T = 20 C, pH = 3, aW = 0.895"); // Objeto de la clase RhizopusOryzae llamado setas
		RhizopusOryzae champis = new RhizopusOryzae(0, 3.0, 0.16, 0.06, 10.0/33.0, 2.757, "T = 30 C, pH = 5, aW = 0.99"); // Objeto de la clase RhizopusOryzae llamado champis

		Escritura sistema1 = new Escritura("\t" + "Sistema 1 para" + setas.getCondiciones() + "\n"); // Objeto de la clase Escritura con titulo las condiciones del sistema 1
		sistema1.insertaValor("diametro (t=0h) :", setas.diametro(0) + "mm"); // Se crea una caja para 0h
		sistema1.insertaValor("diametro (t=50h) :", setas.diametro(50) + "mm"); // Se crea una caja para 50h
		sistema1.insertaValor("diametro (t=150h) :", setas.diametro(150) + "mm"); // Se crea una caja para 150h

		sistema1.espera(); // Espera hasta apretar el boton Aceptar para continuar y cerrar la pestaña

		Escritura sistema2 = new Escritura("\t" + "Sistema 2 para" + champis.getCondiciones() + "\n"); // Objeto de la clase Escritura con titulo las condiciones del sistema 2
		sistema2.insertaValor("diametro (t=0h) :", champis.diametro(0) + "mm"); // Se crea una caja para 0h
		sistema2.insertaValor("diametro (t=50h) :", champis.diametro(50) + "mm"); // Se crea una caja para 50h
		sistema2.insertaValor("diametro (t=150h) :", champis.diametro(150) + "mm"); // Se crea una caja para 150h

		sistema2.espera(); // Espera hasta apretar el boton Aceptar para cerrar la pestaña


	}

}





