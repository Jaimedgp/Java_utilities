/**
*
* Esta clase crea un objeto de la clase Hongo y calcula el diametro de la colonia 
* al cabo de cierto tiempo
*
* Programa escrito por Jaime Diez Gonzalez-Pardo
*
* Version 1.0
*
*/

public class PruebaHongo {

		/**
		* Se crean dos objetos de la clase RhizopusOryzae y se calculan sus diametros para tres tiempos: 0h, 50h, 150h
		*/

	public static void main(String[] args) {
		
		RhizopusOryzae setas = new RhizopusOryzae(0, 3.5, 0.36, 0.06, 10.0/24.0, 2.757, "T = 20 C, pH = 3, aW = 0.895"); // Objeto de la clase RhizopusOryzae llamado setas
		RhizopusOryzae champis = new RhizopusOryzae(0, 3.0, 0.16, 0.06, 10.0/33.0, 2.757, "T = 30 C, pH = 5, aW = 0.99"); // Objeto de la clase RhizopusOryzae llamado champis
		

		System.out.println("\t" + "Sistema 1 para" + setas.getCondiciones() + "\n"); // Se printa por pantalla las condiciones del sistema1
		System.out.println("diametro (t=0h) :" +  setas.diametro(0) + "mm"); // Diametro de la colonia al cabo de 0 horas
		System.out.println("diametro (t=50h) :" + setas.diametro(50) + "mm"); // Diametro de la colonia al cabo de 50 horas
		System.out.println("diametro (t=150h) :" + setas.diametro(150) + "mm" + "\n" + "\n"); // Diametro de la colonia al cabo de 150 horas

		System.out.println("\t" + "Sistema 2 para" + champis.getCondiciones() + "\n"); // Se printa por pantalla las condiciones del sistema2
		System.out.println("diametro (t=0h) :" + champis.diametro(0) + "mm"); // Diametro de la colonia al cabo de 0 horas
		System.out.println("diametro (t=50h) :" + champis.diametro(50) + "mm"); // Diametro de la colonia al cabo de 50 horas
		System.out.println("diametro (t=150h) :" + champis.diametro(150) + "mm"); // Diametro de la colonia al cabo de 150 horas


	}

}





