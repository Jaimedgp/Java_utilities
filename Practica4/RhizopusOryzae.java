/**
*
* Esta clase representa el medio en el que crece el hongo Rhizopus Oryzae
* Para crear un objeto correspondiente al medio
*
* Programa escrito por Jaime Diez Gonzalez-Pardo
*
* Version 1.0
*
*/

public class RhizopusOryzae {

    private double y0;  // Diametro inicial de las colonias en mm
    private double yMax; // Diametro maximo de las colonias en mm
    private double velMax; // Velocidad de crecimiento en mm/h
    private double m; // parámetro de curvatura de transición de la fase exponencial en 1/mm
    private double v; // parámetro de curvatura de transición a la fase exponencial en 1/s
    private double h0; // estado fisiológico inicial de las células sin dimensiones
    private String condiciones; // texto que contiene las condiciones de Temperatura en C, pH y actividad del agua


    	/**
    	* Se crea un metodo constructor que convierte los atributos en parametros del metodo
    	* No retorna nada
    	*/

    public RhizopusOryzae(double y0, double yMax, double velMax, double m, double v, double h0, String condiciones) {

        this.y0 = y0;
        this.yMax = yMax;
        this.velMax = velMax;
        this.m = m;
        this.v = v;
        this.h0 = h0;
        this.condiciones = condiciones; 


    }

    	/**
    	* Se obtiene el valor de A(t) a partir de los parametros del constructor y el parametro t del metodo 
    	* Las ecuaciones se sacan del guion de la practica
    	* Se retorna el valor de A(t)
    	* El metodo es privado
    	*/

    private double ajuste(double t) {

    	double q0 = 1 / (Math.exp(h0) - 1); // Variable local utilizada para calcular A(t)

    	double At = t + Math.log((Math.exp(-v*t)+q0)/(1+q0))/v; 

    	return At;

    }

    	/**
    	* Se calcula el valor del diametro de la colonia de Hongos respecto del parametro t tiempo en h
		* Retorna el valor del diametro
    	*/

    public double diametro(double t) {

    	double Yt = y0+velMax*ajuste(t)-(Math.log(1+(Math.exp(m*velMax*ajuste(t))-1)/(Math.exp(m*(yMax-y0)))))/m;

    	return Yt;
    	 
    }

    	/**
    	* Retorna el valor de la variable String condiciones
    	*/

    public String getCondiciones() {

    	return condiciones;

    }

}