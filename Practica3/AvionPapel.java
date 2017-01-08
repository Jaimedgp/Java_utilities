import fundamentos.*;

/**
*
* Esta clase representa el movimiento de un avion de papel lanzado desde el suelo hasta chocar con un 
* edificio.
*
* Programa escrito por Jaime Diez Gonzalez-Pardo
*
* Version 2.3
*
*/

public class AvionPapel {

        /**
        * Metodo main que inserta el edificio y dibuja el avion, moviendole y cambiando
        * la imagen al chocar con el edificio
        */

    public static void main(String[] args) {
        
            // Se insertan primero el edificio pues de lo contrario, al situarse el avion en el sitio del edificio
            // este taparia la imagen del avion

        Imagen ImgEdificio = new Imagen(500, 100, "edificio.jpg"); // Se inserta la imagen del edificio

            // Se crean las lineas que crean el avion

        Linea A = new Linea(150, 710, 30, 740);
        Linea B = new Linea(150, 710, 50, 750);
        Linea C = new Linea(30, 740, 50, 750);
        Linea D = new Linea(50, 750, 60, 770);
        Linea F = new Linea(60, 770, 65, 755);
        Linea G = new Linea(65, 755, 150, 710);
        Linea H = new Linea(65, 755, 85, 775);
        Linea W = new Linea(85, 775, 150, 710);
        Linea Y = new Linea(60, 770, 75, 765);

        A.espera(10000); // Se espera 1 s antes de comenzar el movimiento del avion

            int z = -35; // Se asigna la variable que se usa para los bucles while

        while (z < -20) {

                // El movimiento del avion se puede asemejar a una S o a un signo de integracion.
                // para describir ese movimiento se pueden usar las ecuaciones (x = y*y*y) o tambien
                // se puede utilizar tambien la funcion y = log(x) para el segundo tramo y (y = -1/x)
                // para el primer tramo. Se usara esta ultima forma pero realizando algunas variaciones
                // para que se ajuste a la cantidad de pixeles que se ha de mover.

            double u1 = (z + 35)/20.0; // Variable en el eje de las x
            double o1 = ((-1.0 / z)*60.0); // Variable en el eje de las y

                // Puesto que para realizar las operaciones se necesita operar con numeros reales (doubles)
                // se necesita pasar a nimeros enteros (int) que es el tipo de dato que usa la clase mueve

            int o = (int) o1; 
            int u = (int) u1;

            A.espera(20); // realizar el movimiento cada 20 ms

                // Mover cada una de las lineas la misma cantidad para que se vuelva a formar el avion

            A.mueve(u, -o);
            B.mueve(u, -o);
            C.mueve(u, -o);
            D.mueve(u, -o);
            F.mueve(u, -o);
            G.mueve(u, -o);
            H.mueve(u, -o);
            W.mueve(u, -o);
            Y.mueve(u, -o);

            z += 1; // Se suma 1 al valor de la variable z
        }

        while (z < -1) {

            double u1 = (z + 35)/2.0; // variable en el eje de las x
            double o1 = ((-1.0 / z)*80.0); //variable en el eje de las y

                // Puesto que para realizar las operaciones se necesita operar con numeros reales (doubles)
                // se necesita pasar a nimeros enteros (int) que es el tipo de dato que usa la clase mueve

            int o = (int) o1;
            int u = (int) u1;

            A.espera(80); // Se varia el tiempo de ejecucion pues en este intervalo el avion se desplaza mayor cantidad de pixeles

                // Mover cada una de las lineas la misma cantidad para que se vuelva a formar el avion

            A.mueve(u, -o);
            B.mueve(u, -o);
            C.mueve(u, -o);
            D.mueve(u, -o);
            F.mueve(u, -o);
            G.mueve(u, -o);
            H.mueve(u, -o);
            W.mueve(u, -o);
            Y.mueve(u, -o);

            z += 1; // Se suma 1 al valor de la variable z
        }

        double k = 0; // Se crea otra variable para el bucle while del logaritmo

        while (k < 30) {

            double e1 = k/2; // variable del eje x
            double e2 = Math.log((10*k)+1)*2.2; // variable del eje y. Se utiliza la clase Math para la operacion

                // Puesto que para realizar las operaciones se necesita operar con numeros reales (doubles)
                // se necesita pasar a nimeros enteros (int) que es el tipo de dato que usa la clase mueve


            int f = (int) e1;
            int e = (int) e2;

            A.espera(8); // Al ser muy lenta esta parte se realiza el movimiento cada menos tiempo 8 ms

                // Mover cada una de las lineas la misma cantidad para que se vuelva a formar el avion

            A.mueve(f, -e);
            B.mueve(f, -e);
            C.mueve(f, -e);
            D.mueve(f, -e);
            F.mueve(f, -e);
            G.mueve(f, -e);
            H.mueve(f, -e);
            W.mueve(f, -e);
            Y.mueve(f, -e);

            k += 1; // Sumar 1 a la variable k
        }

            // Se desplaza el avion un ultimo movimiento en el eje de las x 

        A.mueve(50, 0);
        B.mueve(50, 0);
        C.mueve(50, 0);
        D.mueve(50, 0);
        F.mueve(50, 0);
        G.mueve(50, 0);
        H.mueve(50, 0);
        W.mueve(50, 0);
        Y.mueve(50, 0);

            // Se vulve a insertar la imagen edificio para ocultar las lineas de avion de forma que para el 
            // que ejecuta el programa el avion desaparece. Esto se hace por no tener los conocimientos para 
            // hacer desaparecer un objeto.

        Imagen ImgEdificio1 = new Imagen(500, 100, "edificio.jpg");

            /**
            * Se crea otro avion encima de la imagen edificio pero en esta figura la punta aperece doblada simulando el aplastamiento por chocar con el avion
            */

        Linea A1 = new Linea(577, 203, 480, 230);
        Linea B1 = new Linea(582, 205, 500, 240);
        Linea G1 = new Linea(585, 208, 515, 245);
        Linea W1 = new Linea(587, 215, 535, 265);
        Linea H1 = new Linea(515, 245, 535, 265);
        Linea C1 = new Linea(480, 230, 500, 240);
        Linea D1 = new Linea(500, 240, 510, 260);
        Linea F1 = new Linea(510, 260, 515, 245);
        Linea Y1 = new Linea(510, 260, 525, 255);


        Linea W2 = new Linea(587, 215, 590, 220);
        Linea W3 = new Linea(590, 220, 592, 212);
        Linea W4 = new Linea(592, 212, 595, 215);
        Linea W5 = new Linea(595, 215, 602, 198);

        Linea G2 = new Linea(585, 208, 588, 213);
        Linea G3 = new Linea(588, 213, 590, 205);
        Linea G4 = new Linea(590, 205, 593, 208);
        Linea G5 = new Linea(593, 208, 602, 198);

        Linea B2 = new Linea(582, 205, 585, 210);
        Linea B3 = new Linea(585, 210, 587, 202);
        Linea B4 = new Linea(587, 202, 590, 205);
        Linea B5 = new Linea(590, 205, 602, 198);

        Linea A2 = new Linea(577, 203, 580, 208);
        Linea A3 = new Linea(580, 208, 582, 200);
        Linea A4 = new Linea(582, 200, 585, 203);
        Linea A5 = new Linea(585, 203, 602, 198);

    }
}