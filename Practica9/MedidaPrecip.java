/**
 * Clase que contiene una medida de precipitacion obtenida por un pluviometro
 * 
 * @author (Michael) 
 * @version (abr 2016)
 */
public class MedidaPrecip
{
    // fecha
    private int dia, mes, year, hora;
    // precipitacion en l/m2
    private double precipHora;

    /**
     * Constructor al que se le pasa la precipitacion en una hora asi
     * como el dia, mes, anyo y hora
     * @param   precipHora  la precipitacion en una hora en l/m/2
     * @param   dia         el dia (1-31)
     * @param   mes         el mes (1-12)
     * @param   year        el anyo
     * @param   hora        la hora (0-23)
     */
    public MedidaPrecip(double precipHora, int dia, int mes, int year, int hora)
    {
        this.precipHora=precipHora;
        this.dia=dia;
        this.mes=mes;
        this.year=year;
        this.hora=hora;
    }

    /**
     * Retorna la precipitacion en una hora
     * @return     la precipitacion en una hora en l/m2
     */
    public double getPrecipHora()
    {
        return precipHora;
    }

    /**
     * Retorna el dia
     * @return     el dia del mes
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * Retorna el mes
     * @return     el mes (1-12)
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * Retorna el anyo
     * @return     el anyo
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Retorna la hora del dia
     * @return     la hora (0-23)
     */
    public int getHora()
    {
        return hora;
    }
    
    /**
     * Retorna un string con los datos de fecha y precipitacion
     * @return    texto con la hora, fecha y precipitacion
     */
    public String toString() {
        return (hora+"h "+dia+"/"+mes+"/"+year+"   "+precipHora);
    }
}
