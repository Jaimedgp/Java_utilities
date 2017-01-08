import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.io.*;
import fundamentos.Dibujo;
import fundamentos.ColorFig;

/**
 * Clase para simular y probar el funcionamiento del sistema de
 * deteccion de colisiones 
 *
 * @author Jaimedgp
 * @version 12 Mayo 2016
 */

public class Coche {

    private ArrayList<Obstaculo> lista; //una lista de obstaculos
    private double vC;                  // velocidad del coche en m/s
    private final double A,L;           // dimensiones del coche 
                                        // (semianchura y longitud) en m
        /**
         * Constructor que recibe como parametros la velocidad del coche
         * vC en m/s, las dimensiones A y L del coche en m y el nombre de
         * un fichero de texto del que se leen datos para rellenar la
         * lista de obstaculos
         */
    public Coche(double vC, double A, double L, String nombreFichero) {
        this.vC = vC;
        this.A = A;
        this.L = L;
        lista = new ArrayList<Obstaculo>();
        try (Scanner in=new Scanner(new FileReader(nombreFichero))) {
            in.useLocale(Locale.ENGLISH);
            int id;
            double vT,vN,d,alfa,r;
            in.nextLine();
            while (in.hasNext()) {
                id = in.nextInt();
                vT = in.nextDouble();
                vN = in.nextDouble();
                d = in.nextDouble();
                alfa = in.nextDouble();
                r = in.nextDouble();
                Obstaculo nuevo = new Obstaculo(id,r);
                nuevo.set(vT,vN,d,alfa);
                lista.add(nuevo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el fichero");
            // Error grave. Se abandona el programa
            System.exit(-1);
        }
    }
    
        /**
         * Retorna un array conteniendo todos los obstaculos para los que se 
         * detecta un posible choque
         */
    public Obstaculo[] posiblesChoques() {
	
            //lista para meter los obstaculos que pueden chocar
        ArrayList<Obstaculo> chocan = new ArrayList<Obstaculo>();
            //recorrido para obtener los obstaculos que pueden chocar
        for (Obstaculo obs : lista) {
            boolean choca = false;
                /* consideramos que puede haber choque si los tiempos
                   de alcance y rebase estan entre 0 y 30s
                 */
            if (0 <= obs.tAlcance(vC) && obs.tAlcance(vC) <= 30 && 0 <= obs.tRebase(vC, L) && obs.tRebase(vC ,L) <= 30) {
                    /* el choque se produce si se da alguna de estas
                       tres circunstancias:
                     */
                if (Math.abs(obs.margenAlcance(vC)) <= obs.getRadio()+A) {
                    choca = true;
                } else if (Math.abs(obs.margenRebase(vC, L)) <= obs.getRadio()+A) {
                    choca = true;
                } else if (obs.margenAlcance(vC)*obs.margenRebase(vC, L)< 0) {
                        /* el margen de alcance y el de rebase
                           tienen distinto signo
                         */
                    choca = true;
                }
            }
            if (choca) {
                chocan.add(obs);
            }
        }
            //crear el array
        Obstaculo[] posibles = new Obstaculo[chocan.size()];
            // metemos los datos de la lista chocan en el array
        for (int i = 0; i < posibles.length; i++) {
            posibles[i] = chocan.get(i);
        }
        return posibles;
    }

        /**
         * Pone en pantalla un informe de todos los obstaculos
         */
    public void informe() {

            // se escriben los titulos de las graficas usando printf
        System.out.printf("%-9s  %15s  %15s  %15s %15s %n", "Id", "tiempoAlcance", "tiempoRebase", "margenAlcance", "margenRebase");
            // escribe por panatalla todos posibles choques
        for (Obstaculo crack : lista) {
            System.out.printf("%-8d  %15g %15g %15g %15g %n", crack.getId(), crack.tAlcance(vC), crack.tRebase(vC, L), crack.margenAlcance(vC), crack.margenRebase(vC, L));
        }
    }

        /**
         * Busca en la lista el primer Obstaculo cuyo margen de alcance en
         * valor absoluto es menor o iguar que r+A y lo retorna.  Si no lo
         * encuentra lanza NoEncontrado.
         */
    public Obstaculo pocoMargenAlcance() throws NoEncontrado {
            /* bucle que recorre todos los elementos de lista
               hasta encontrar el que se quiere
            */
	   for (Obstaculo pum : lista) {
                // condicional si el margen de alcance es menor o igual que r+A
           if (Math.abs(pum.margenAlcance(vC))<=pum.getRadio()+A) {
               return pum; // retorna el obstaculo
           }
       }
       throw new NoEncontrado(); // si no ha encontrado nada lanza NoEncontrado
    }

        /**
         * Metodo que hace un dibujo del coche (mediante un rectangulo) y de los
         * obstaculos (mediante circulos) dibujando en verde aquellos que no tengan
         * posibilidad de chocar y en rojo los posibles choques.
         */
    public void dibujo() {

        Dibujo parking = new Dibujo("que bonico"); // se crea un objeto de la clase Dibujo
            // coordenadas de los vertices del rectangulo del coche
        int x1 = (int) (300-A*15); 
        int x2 = (int) (300+A*15);
        int y2 = (int) (250+L*13);

            // se pinta el rectangulo
        parking.dibujaRectangulo(x1, 250, x2,y2) ;
        parking.pinta();

        /*
            // bucle que recorre el array de la lista de obstaculos
        for (Obstaculo peaton: lista) {
                // coordenadas (x,y) del objeto
            int x = 300 + (int) (Math.toRadians(Math.sin(peaton.getAlpha()))*(peaton.getDistancia()*150));
            int y = (int) (250+(L*13/2)) - (int) (Math.toRadians(Math.cos(peaton.getAlpha()))*(peaton.getDistancia()*100));
            parking.ponColorLapiz(ColorFig.verde); // se pinta de verde
            parking.ponRelleno(ColorFig.verde); // Se pone relleno 
            parking.dibujaElipse(x, y, (int) (x+peaton.getRadio()*5), (int) (y+peaton.getRadio()*5)); // se dibuja un circulo en el punto (x,y) de radio R
            parking.ponColorLapiz(ColorFig.negro); // color negro
            parking.dibujaTexto(String.valueOf(peaton.getId()), (int) (x+peaton.getRadio()*5), (int) (y+peaton.getRadio()*5)); // codigo Id 
            parking.pinta(); // se pinta el obstaculo
        }
            // bucle que recorre el array de la lista de obstaculos posibles
        for (Obstaculo bache: posiblesChoques()) {
               // coordenadas (x,y) del objeto
            int x = 300 + (int) (Math.toRadians(Math.sin(bache.getAlpha()))*(bache.getDistancia()*150));
            int y = (int) (250+(L*13/2)) - (int) (Math.toRadians(Math.cos(bache.getAlpha()))*(bache.getDistancia()*100));
            parking.ponColorLapiz(ColorFig.rojo); // se pinta de rojo
            parking.ponRelleno(ColorFig.rojo); // Se pone relleno 
            parking.dibujaElipse(x, y, (int) (x+bache.getRadio()*5), (int) (y+bache.getRadio()*5)); // se dibuja un circulo en el punto (x,y) de radio R
            parking.ponColorLapiz(ColorFig.negro); // color negro
            parking.dibujaTexto(String.valueOf(bache.getId()), (int) (x+bache.getRadio()*5), (int) (y+bache.getRadio()*5)); // codigo Id 
            parking.pinta(); // se pinta el obstaculo
        }*/

        int i = 0;

        for (Obstaculo peaton : lista) {
            if (peaton == posiblesChoques()[i]) {
                if (i+1 < posiblesChoques().length) {
                    i++;
                }
            } else {
                    // coordenadas (x,y) del objeto
                int x = 300 + (int) (Math.toRadians(Math.sin(peaton.getAlpha()))*(peaton.getDistancia()*150));
                int y = (int) (250+(L*13/2)) - (int) (Math.toRadians(Math.cos(peaton.getAlpha()))*(peaton.getDistancia()*100));
                parking.ponColorLapiz(ColorFig.verde); // se pinta de verde
                parking.ponRelleno(ColorFig.verde); // Se pone relleno 
                parking.dibujaElipse(x, y, (int) (x+peaton.getRadio()*5), (int) (y+peaton.getRadio()*5)); // se dibuja un circulo en el punto (x,y) de radio R
                parking.ponColorLapiz(ColorFig.negro); // color negro
                parking.dibujaTexto(String.valueOf(peaton.getId()), (int) (x+peaton.getRadio()*5), (int) (y+peaton.getRadio()*5)); // codigo Id 
                parking.pinta(); // se pinta el obstaculo
            }
        }

        for (Obstaculo bache: posiblesChoques()) {
               // coordenadas (x,y) del objeto
            int x = 300 + (int) (Math.toRadians(Math.sin(bache.getAlpha()))*(bache.getDistancia()*150));
            int y = (int) (250+(L*13/2)) - (int) (Math.toRadians(Math.cos(bache.getAlpha()))*(bache.getDistancia()*100));
            parking.ponColorLapiz(ColorFig.rojo); // se pinta de rojo
            parking.ponRelleno(ColorFig.rojo); // Se pone relleno 
            parking.dibujaElipse(x, y, (int) (x+bache.getRadio()*5), (int) (y+bache.getRadio()*5)); // se dibuja un circulo en el punto (x,y) de radio R
            parking.ponColorLapiz(ColorFig.negro); // color negro
            parking.dibujaTexto(String.valueOf(bache.getId()), (int) (x+bache.getRadio()*5), (int) (y+bache.getRadio()*5)); // codigo Id 
            parking.pinta(); // se pinta el obstaculo
        }
        parking.espera(); // Al pulsar Aceptar se cierra la pantalla
    }
}