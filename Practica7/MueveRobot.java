/**
 *
 * Esta clase realiza varios tipos de movimientos a partir de un robot creado en un laberinto
 *
 * @author Jaime Diez Gonzalez-Pardo
 *
 * @version 11 Abril 2016
 *
 */

public class MueveRobot {

    private Robot bb8; //

        /**
         * Constructor que crea un objeto Robot a partir de las coordenadas de posicion
         *
         * @param posX (posicion en el eje X) y pos Y (Posicion en el eje Y)
         */
    public MueveRobot(int posX, int posY) {

        bb8 = new Robot(posX, posY, 0); //
    }

        /**
         * Metodo que hace avanzar el robot hasta encontrar un obstaculo de frente
         */
    public void avanzaRecto() {

            // el metodo avanza retorna el booleano necesario para ejecutar el while
        while (bb8.avanza()) {
            bb8.pinta(); // pinta el robot cada vez que avanza
        }
    }

        /**
         * El metodo hace avanza el robot 3 y girar 3, 8 veces
         */
    public void avanzaEnEscalera() {

            // bucle for que realiza la operacion 8 veces
        for (int i=1; i<=8; i++) {
            
                // bucle for que realiza la operacion avanza y pinta 3 veces
            for (int a=1; a<=3; a++) {
                bb8.avanza();
                bb8.pinta();
            } 

            bb8.gira90(); // gira 90º
            bb8.pinta();

                // bucle for que realiza la operacion avanza y pinta otras 3 veces
            for (int b=1; b<=3; b++) {
                bb8.avanza();
                bb8.pinta();
            } 

                // bucle for que realiza la operacion gira 270º (gira 90º tres veces)
            for (int c=1; c<=3; c++) {
                bb8.gira90();
                bb8.pinta();
            } 

        }
    }

        /**
         * Metodo que avanza hasta encontrar un obstaculo y entonces gira 90º
         * realiza esta operacion 10 veces
         */
    public void avanzaEvitando() {

            // bucle for que realiza la operacion 10 veces
        for (int ii=1; ii<=10; ii++) {
            avanzaRecto();
            bb8.gira90();
            bb8.pinta();
        }
    }

        /**
         * Metodo que tras avanzar hasta encontrar un obstaculo, gira un numero aleatorio de veces 90º
         * realiza esta operacion 20 veces
         */
    public void avanzaYGiraAleatorio() {

            // bucle for que realiza la operacion 20 veces
        for (int f=0; f<=20; f++) {
            avanzaRecto();
            bb8.pinta();
            int n = (int)((Math.random()*3)+1); // numero aleatorio entre 1 y 3
            for (int ff=1; ff<=n; ff ++)  {
                bb8.gira90();
            }
            bb8.pinta();
        }
    }

        /**
        * Metodo que reproduce un movimiento del robot de forma aleatoria mientras este se 
        * encuentre dentro del laberinto
        *
        * @return i = numero de veces que avanza
        */
    public double movimientoAleatorio() {

        double i = 0;

        while (bb8.estaDentroLaberinto()) {

            int n = (int)((Math.random()*3)+1);
            for (int ff=1; ff<=n; ff ++)  {
                bb8.gira90();
            }
            bb8.pinta();
            int nn = (int)((Math.random()*10)+1);
            for (int fff=1; fff<=nn; fff ++)  {
                bb8.avanza();
                bb8.pinta();
                i ++;
            }
        }
        return i;
    }

        /**
        * Metodo que reproduce un movimiento del robot pegado siempre a una pared por su lado derecho
        *
        * @return i = numero de veces que avanza
        */
    public double avanzaConManoDerecha() {

        avanzaRecto();
        bb8.gira90();

        double i = 1; // se inicia la variable i contando el avanza recto como 1 avanza

            // estaDentroLaberinto() nos proporciona el booleano necesario para iniciar el while mientras se encuentre dentro del laberinto
        while (bb8.estaDentroLaberinto()) {

                // hayObstaculo() nos proporciona el booleano necesario para iniciar el if. Robot.DCHA es la bariable que indica la direccion del obtaculo
            if (bb8.hayObstaculo(Robot.DCHA)){
            	if (bb8.hayObstaculo(Robot.DELANTE)) {  // Robot.DELANTE es la bariable que indica la direccion del obtaculo
	                bb8.gira90();
            	} else {
            		bb8.avanza();
            	}

            } else {
                for (int c=1; c<=3; c++) { // Gira 270º
                    bb8.gira90();
                }
                bb8.avanza(); 
            }

            bb8.pinta();
            i++; // al finalizar el while habra realizado avanza() 1 vez 
        }
        return i;
    }
}