
/**
 * Clase que contiene los datos de una medida de parametros electricos
 */
public class MedidaElectrica
{
    // atributos privados
    private double voltaje; //V
    private double intensidad; //A
    private double tiempo; //s

    /**
     * Constructor, al que se pasan la tension (V), intensidad(A) y tiempo(s)
     */
    public MedidaElectrica(double voltaje, double intensidad, double tiempo) {
        this.voltaje=voltaje;   
        this.intensidad=intensidad;   
        this.tiempo=tiempo;   
    }
    
    /**
     * Voltaje de la medida, en V
     */
    public double getVoltaje() {
        return voltaje;
    }

    /**
     * Intensidad de la medida, en A
     */
    public double getIntensidad() {
        return intensidad;
    }

    /**
     * Instante de la medida, en s
     */
    public double getTiempo() {
        return tiempo;
    }
}
