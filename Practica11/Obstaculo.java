
/**
 * Clase que representa un obstaculo que puede encontrarse un coche
 * mientras avanza por la carretera.  Es parte del software de un
 * sistema para evitar colisiones
 */
public class Obstaculo {

    private int id;      // entero que identifica al obstaculo
    private double vT;   // velocidad tangencial, en m/s
    private double vN;   // velocidad normal, en m/s
    private double d;    // distancia al obstaculo en m
    private double alfa; // angulo al obstaculo, en radianes
    private double r;    // radio del obstaculo, en m

    /**
     * Recibe como parametros los valores iniciales de 
     * id: entero que identifica al obstaculo
     * r: radio del obstaculo en m
     */
    public Obstaculo(int id, double r) {
        this.id = id;
        this.r = r;
    }

    /**
     * Recibe como parametros los valores de 
     * vT: velocidad tangencial, en m/s
     * vN: velocidad normal, en m/s
     * d: distancia al obstaculo en m
     * alfa: angulo al obstaculo, en grados
     */
    public void set(double vT, double vN, double d, double alfa) {
        this.vT = vT;
        this.vN = vN;
        this.d = d;
        this.alfa = Math.toRadians(alfa);
    }
    
    /**
     *  Calcula y retorna el tiempo (en s) hasta alcanzar el obstaculo en la 
     *  direccion del coche, dada la velocidad del coche (vC) en m/s
     */
    public double tAlcance(double vC) {
        return (d*Math.cos(alfa)-r)/(vC-vN);
    }
    
    /**
     * Calcula y retorna el tiempo (en s) hasta rebasar el obstaculo en la 
     * direccion del coche, dada la velocidad del coche (vC) en m/s 
     * y la longitud del coche (l) en m
     */
    public double tRebase(double vC, double l) {
        return (d*Math.cos(alfa)+r+l)/(vC-vN);
    }
    
    /**
     * Calcula y retorna el margen de distancia tangencial (en m)
     * entre el coche y el obstaculo cuando transcurra el tiempo de
     * alcance dada la velocidad del coche (vC) en m/s
     */
    public double margenAlcance(double vC) {
        return d*Math.sin(alfa)+vT*tAlcance(vC);
    }
    
    /**
     * Calcula y retorna el margen de distancia tangencial (en m)
     * entre el coche y el obstaculo cuando transcurra el tiempo de
     * rebase dada la velocidad del coche (vC) en m/s y la longitud
     * del coche (l) en m
     */
    public double margenRebase(double vC, double l) {
        return d*Math.sin(alfa)+vT*tRebase(vC,l);
    } 
    
    /**
     * Retorna el entero que identifica al obstaculo
     */
    public int getId() {
        return id;
    }
    
    /**
     * Retorna el radio del obstaculo, en m
     */
    public double getRadio() {
        return r;
    }

        /**
         * Retorna el angulo alpha en grados
         */
    public double getAlpha() {
        return alfa;
    }

        /**
         * Retorna la distancia d en m
         */
    public double getDistancia() {
        return d;
    }
    
}
