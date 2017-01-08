import java.util.*;
import fundamentos.Grafica;
import fundamentos.Dibujo;

/**
 * Clase para gestionar rutas almacenadas en un fichero GPX
 *
 *@author JaimeDGP
 *@version 2 Mayo 2016
 */
public class Ruta {

    private ArrayList<Trackpoint> lista;

    /**
     * Constructor que lee los datos de la ruta de un fichero
     * con formato GPX, cuyo nombre se pasa como argumento
     * 
     * @param fichero   nombre del fichero que contiene la ruta
     */
    public Ruta(String fichero) {
	
        this.lista = Trackpoint.parseGpx(fichero); // Se para al atributo un arraylist con los valores del fichero
    }
    
    /**
     * Metodo que representa el perfil de la ruta 
     */
    public void perfil() {
	
        double longitud = 0; //Se inicializa la longitud recorrida
        Grafica sendero = new Grafica("Perfil del camino", "Distancia recorrida", "Altitud"); // Se crea el objeto Grafica del paquete fundamentos

            // Bucle for que recorre todo el ArrayList
        for (int i = 0; i < lista.size()-1 ; i++) {
            longitud += lista.get(i+1).distancia(lista.get(i)); // se suma el nuevo valor de longitud para obtener la longitud total recorrida
            sendero.inserta(longitud/1000, lista.get(i).elevacion()); // se representa la longitud recorrida respecto la elevacion en ese
        }

        sendero.pinta(); // Se pinta la grafica
    }

    /**
     * Retorna un valor logico que indica si la ruta asciende por encima de un 
     * valor se pasa como parametro, en m
     * 
     * @param altitud  Cota de elevacion, en m
     * @return   valor logico que indica si la ruta ha superado la cota
     */
    public boolean cotaSuperada(double altitud){

        double maxValue = 0; // Se inicializa la maxima altitud

            // bucle que recorre los elementos del arraylist
        for (int x = 0; x < lista.size() ; x++) {

                // Si se encuentra un valor mayor que el anterior valor maximo de la elevacion 
            if (x>maxValue) { 
                maxValue = x; // El nuevo valor es el valor maximo de la elevacion
            }
        }

            // si el valor maximo es mayor que altitud
       if (maxValue > altitud) {
            return true; // retorna true
       } else { // si no
            return false; // retorna false
        } 
    }

    
    /**
     * Retorna la maxima latitud, en grados, encontrada a lo
     * largo de la ruta
     * 
     * @return maxima latitud alcanzada durante la ruta, en grados
     */
    public double latitudMax() {
        double max=-90.0;
        for (Trackpoint p:lista) {
            if (p.latitud()>max) {
                max = p.latitud();
            }
        }
        return max;
    }
    
    /**
     * Retorna la minima latitud, en grados, encontrada a lo
     * largo de la ruta
     * 
     * @return minima latitud alcanzada durante la ruta, en grados
     */
    public double latitudMin() {
        double min=90.0;
        for (Trackpoint p:lista) {
            if (p.latitud()<min) {
                min = p.latitud();
            }
        }
        return min;
    }
    
    /**
     * Retorna la maxima longitud, en grados, encontrada a lo
     * largo de la ruta
     * 
     * @return maxima longitud alcanzada durante la ruta, en grados
     */
    public double longitudMax() {
        double max=-180.0;
        for (Trackpoint p:lista) {
            if (p.longitud()>max) {
                max = p.longitud();
            }
        }
        return max;
    }
    
    /**
     * Retorna la minima longitud, en grados, encontrada a lo
     * largo de la ruta
     * 
     * @return minima longitud alcanzada durante la ruta, en grados
     */
    public double longitudMin() {
        double min=180.0;
        for (Trackpoint p:lista) {
            if (p.longitud()<min) {
                min = p.longitud();
            }
        }
        return min;
    }
        
    public void pinta(int size) {

        double lonMax = longitudMax(); // Se define la vaariable lonMax con el valor retornado de longitudMax()
        double latMax = latitudMax(); // Se define la vaariable latMax con el valor retornado de latitudMax()
        double lonMin = longitudMin(); // Se define la vaariable lonMin con el valor retornado de longitudMin()
        double latMin = latitudMin(); // Se define la vaariable latMin con el valor retornado de latitudMin()
        double escala = size/(1.1*Math.max(lonMax-lonMin, latMax-latMin)); // se calcula la escala que se utilizara
        int origenX = (int)((size - escala*(lonMax-lonMin))/2); // se calcula el pixel osigen en las coordenadas de las X
        int origenY = (int)((size - escala*(latMax-latMin))/2); // se calcula el pixel osigen en las coordenadas de las Y

        Dibujo d = new Dibujo("Caminata",size,size); // Se crea un objeto Dibujo del paquete fundamentos con el tamaño de ventana size (parametro)

            // bucle for que recorre todo el arraylist 
        for (int i = 1; i<lista.size()-1 ; i++) {
            int x1 = (int) (origenX + escala*(lista.get(i-1).longitud()-lonMin)); // coordenada X del primer punto
            int y1 = (int) (size-origenY-escala*(lista.get(i-1).latitud() - latMin)); // coordenada Y del primer punto
            int x2 = (int) (origenX + escala*(lista.get(i).longitud()-lonMin)); // coordenada X del segundo punto
            int y2 = (int) (size-origenY-escala*(lista.get(i).latitud() - latMin)); // coordenada Y del segundo punto
            d.dibujaLinea(x1, y1, x2, y2); // dibuja la linea que va desde 1 hasta 2
        }
        d.espera(); // printa por pantalla la figura final
    }
}


