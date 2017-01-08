/**
 * Clase para manipular informacion del PIB anual de un pais
 */
public class DatosPIB {

    private int pib; // Millones de euros
    private double variacion; // En %
    private int fecha; // Anyo

    /**
     * Constructor que recibe el PIB (en millones de euros), su
     * variaciacion interanual (en %) y el anyo al que corresponden los datos
     * 
     * @param pib   Producto Interior Bruto, en millones de euros
     * @param variacion variacion interanual del PIB, en %
     * @param fecha anyo al que corresponden los datos
     */
    public DatosPIB(int pib, double variacion, int fecha) {
        this.pib = pib;
        this.variacion = variacion;
        this.fecha = fecha;
    }

    /**
     * Metodo observador del valor del PIB
     * 
     * @return     Producto Interior Bruto, en millones de euros
     */
    public int getPib() {
        return pib;
    }

    /**
     * Metodo observador de la tasa de variacion interanual del PIB
     * 
     * @return     variacion interanual del PIB, en %
     */
    public double getVariacion() {
        return variacion;
    }

    /**
     * Metodo que retorna el anyo al que corresponden los datos
     * que guarda el objeto sobre el que se aplica
     * 
     * @return     anyo al que corresponden los datos
     */
    public double getFecha() {
        return fecha;
    }
}
