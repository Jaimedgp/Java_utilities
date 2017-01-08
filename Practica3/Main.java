import fundamentos.*;

/**
*
* Esta clase representa el movimiento de un Dron que despega desde el suelo hasta chocar con un 
* edificio. Para ello se han segiuido las instrucciones de la guia de la practica.
*
* Programa escrito por Jaime Diez Gonzalez-Pardo
*
* Version 1.0
*
*/

public class Main {

        /**
        * Metodo main que inserta el Dron, el edificio, y que realizara el movimiento del Dron.
        */

    public static void main(String[] args) {

            // Se insertan primero el edificio pues de lo contrario, al situarse el Dron en el sitio del edificio
            // este taparia la imagen del Dron

        Imagen ImgEdificio = new Imagen(500, 100, "edificio.jpg"); // Se inserta la imagen del edificio
        
        Imagen ImgDron = new Imagen(100, 800, "dron.jpg"); // Se inserta la imagen del Dron

        Figura.espera(10000);

                 // Se asignan las variables para utilizarlas en el bucle while

            int y = 1;
            int x = 1;

            // Para realizar el movimiento, puesto que es un movimiento periodico, se utilizan bucles while
        
        while (y < 10) {

            ImgDron.mueve(0, -70);

            Figura.espera(200);

            y = y + 1;

        }


        while (x < 6) {

            ImgDron.mueve(70, 0);

            Figura.espera(200);

            x = x + 1;

        }

        ImgDron.mueve(70, 0);

        Figura.espera(200);

                // Coordenadas finales del avion

            int i = 800 - (70 * (y-1));

            int j = 100 + (70 * x);

        Imagen ImgBoom = new Imagen(j, i, "boom.png"); // Se inserta la imagen  del boom
    }
}