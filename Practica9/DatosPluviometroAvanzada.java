import java.io.*;
import java.util.*;

/**
 * Clase que almacena una lista (ArrayLists) de medidas realizadas por un pluviometro y 
 * contiene metodos para gestionar esta lista
 * 
 * @author Jaime Diez G-P 
 * @version 1 · Mayo · 2016
 */
public class DatosPluviometroAvanzada
{
    // instance variables - replace the example below with your own
    private ArrayList<MedidaPrecip> lista;

    /**
     * Constructor que lee los datos del fichero indicado y simula las
     * precipitaciones horarias. Si el fichero no existe crea el array
     * de tamano cero.
     * @param nomFich   nombre del fichero del que se leen los datos
     */
    public DatosPluviometroAvanzada(String nomFich) {
        Scanner in = null;

        try {
            // abre el fichero
            in = new Scanner(new FileReader(nomFich));

            // configura el formato de numeros
            in.useLocale(Locale.ENGLISH);

            // Contador de lineas
            int linea=0;
            
            // precipitacion en el dia 
            double lluvia;
            
            // Fecha
            String fecha[];

            // lista temporal
            ArrayList<MedidaPrecip> listaTemporal=new ArrayList<MedidaPrecip>();
            
            // lee el fichero palabra a palabra
            while (in.hasNext()) {
                linea++;
                // lee primera palabra que contiene la fecha
                String palabra = in.next();
                fecha=palabra.trim().split("-");
                if (fecha.length!=3) {
                    System.out.println("Formto de linea incorrecto. Linea:"+
                        linea+" fecha="+palabra);
                }
                
                // lee numero
                if (in.hasNextDouble()) {
                    // lee un double
                    lluvia = in.nextDouble();
                } else {
                    lluvia=0;
                    System.out.println("No encontrado numero en linea:"+linea);
                }
                
                //Simula que la lluvia ocurre entre las horas 3 a 19
                for (int hora=3; hora<=19; hora++) {
                    // crea un objeto de la clase MedidaPrecip 
		            // y lo anade a un ArrayList
                    listaTemporal.add(new MedidaPrecip(
                       lluvia*hora/187.0,  // se simula la lluvia 
		                           // en las distintas horas
                       Integer.parseInt(fecha[0]),
                       Integer.parseInt(fecha[1]),
                       Integer.parseInt(fecha[2]),
                       hora));
                }
            } // while (in.hasNext())
            
            //Pasamos la lista temporal a la final
            lista=listaTemporal;

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero " + nomFich);
            lista=new ArrayList<MedidaPrecip>(); // creamos el array vacio
        } finally {
            if (in != null)
                in.close();  // cierra el fichero
        } // try
    }
    
    
    /**
     * Recorre la lista identificando medidas de precipitacion
     * correspondientes al dia, mes y anyo indicados por los
     * parametros. Suma las precipitaciones de todas estas medidas
     * (que corresponden a diferentes horas) y retorna esa suma
     * @param   dia  el dia
     * @param   mes  el mes
     * @param   year  el anyo
     * @return   la precipitacion total del dia mes y anyo indicados, en l/m2
     */
    public double precipitacionDia(int dia, int mes, int year) {

        double precip = 0;
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getYear()==year && lista.get(i).getMes()==mes && lista.get(i).getDia() == dia) {
                precip += lista.get(i).getPrecipHora();
            }           
        } 
        return precip;
    }
    
    /**
     * Escribe en la pantalla una lista de las precipitaciones de cada
     * dia correspondiente al mes y anyo indicados obtenidas con
     * sucesivas llamadas al metodo precipitacionDia().
     * @param   mes  el mes
     * @param   year  el anyo
     */
    public void listarMes(int mes, int year) {

        System.out.println("Precipitación del mes: " + mes + ", year: " + year);
        System.out.println("Día" + "\t" + "Precipitación (l/m2)");        

        for (int i = 0; i<lista.size() ; i++) {
            
            if (lista.get(i).getYear()==year && lista.get(i).getMes()==mes) {
                System.out.println(lista.get(i).getDia() + "\t" + precipitacionDia(lista.get(i).getDia(), mes, year));
                i += 17;
            }           
        } 
    }
    
    /**
     * Calcula y retorna la precipitacion por hora maxima de todos los
     * datos de la lista que correspondan al mes indicado en el
     * parametro (para todos los anyos). Si no hay ningun dato para ese
     * mes retorna Double.NaN
     * @param   mes  el mes
     * @return      la precipitacion por hora maxima, en l/m2     
     */
    public double precipitacionMaxEnMes(int mes) {

        double precipitacion = 0;
        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getMes()==mes && lista.get(i).getPrecipHora()>precipitacion) {
                precipitacion = lista.get(i).getPrecipHora();
            }          
        } 

        if (precipitacion == 0) {
            return Double.NaN;
        } else {
            return precipitacion;
        }
    }
    
    /**
     * Muestra en pantalla todos los datos almacenados
     */
    private void listarTodo(){
         if (lista.size()==0) {
            System.out.println("La lista esta vacia");
        } else {
            for (MedidaPrecip m:lista) {
                System.out.println(m);
            }
        }
    }
}