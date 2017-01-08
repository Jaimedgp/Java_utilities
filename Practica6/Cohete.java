/**
 * Clase que contiene los datos de un pequeno cohete que se eleva verticalmente 
 * desde el suelo y metodos para cacular su movimiento
 * 
 * @author Jaime Diez Gonzalez-Pardo
 * @version 4 Abril 2016
 */
public class Cohete {
    
    private double u;  // velocidad de salida de los gases, m/s
    private double d;  // combustible quemado por segundo, Kg/s
    private double m0; // masa inicial del cohete y su combustible inicial, Kg
    private double c;  // masa de combustible inicial, Kg
    
    private static final double g=9.8; //gravedad, m/s^2

    /**
     * Constructor al que se pasan los valores iniciales de los atributos
     * @param   u   velocidad de salida de los gases, m/s
     * @param   d   combustible quemado por segundo, Kg/s
     * @param   m0  masa inicial del cohete y su combustible inicial, Kg
     * @param   c   masa de combustible inicial, Kg
     */
    public Cohete(double u, double d, double m0, double c)   {
	
		this.u = u;
		this.d = d;
		this.m0 = m0;
		this.c = c;
    }
    
    /**
     * Tiempo hasta que el cohete despega, cando el empuje supera al peso
     * @return    tiempo en segundos
     */
    public double t0() {
	
		if ((m0-u*d/g)/d < 0){
			return 0;
		}
		else {
			return (m0-u*d/g)/d;
		}


    }    
       
    /**
     * Tiempo hasta que se agota el combustible
     * @return    tiempo en segundos
     */
    public double tmax() {
		
		return c/d; 
    }    
    
    /**
     * Velocidad al agotarse el combustible
     * @return   velocidad en m/s
     */
    public double vmax() {
	
		return v(tmax()); // g*(tmax()-t0())+u*Math.log((m0-d*t0())/(m0-d*tmax()));
    }

    /**
     * Velocidad del cohete, dado el tiempo
     * @param  t  tiempo en segundos
     * @return    velocidad en m/s
     */
    public double v(double t) {
	
		if (t0()<t && t<=tmax()) {

			return -g*(t-t0())+u*Math.log((m0-d*t0())/(m0-d*t));
		} 

		else if (t>tmax()) {
			
			return vmax()-g*(t-tmax());
		}
		else {return 0.0;}
		
    }

    /**
     * Altura del cohete, dado el tiempo
     * @param  t  tiempo en segundos
     * @return    altura en m
     */
    public double x(double t) {
	
		if (t0()<t && t<=tmax()) {
			
			double dt = t - t0(); // Se asigna una variable del incremento de t 
			double d0 = m0 - d*t0(); // Se asigna una variable con la operacion m0 - d*t0()
			double dd = m0 - d*t;

			return -0.5*g*dt*dt + u*dt*Math.log(d0) + (u/d)*(  dd*Math.log(dd) + d*dt - d0*Math.log(d0)  );

		} else if (t>tmax()) {
			
			return x(tmax()) + vmax()*(t-tmax()) - 0.5*g*(t-tmax())*(t-tmax());
		}
		else{return 0.0;}
    }
    
    /**
     * Altura maxima alcanzada por el cohete
     * @return    altura en m
     */
    public double altmax() {
	
		double taltmax = tmax() + (vmax()/g);

		return x(taltmax);
    }
}
