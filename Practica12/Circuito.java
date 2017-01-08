
/**
 * Clase que contiene un circuito electrico. Se puede medir la tension
 * e intensidad de cada nudo del circuito; los nudos se identifican
 * por un numero entero entre 1 y el maximo numero de nudos
 */
public class Circuito
{
    // maximo numero de nudos
    public final int MAX_NUDOS;
    
    // contador para simular las medidas
    private int contador;

    /**
     * Constructor del circuito que hace las inicializaciones necesarias
     * @param  numNudo  el numero maximo de nudos del circuito
     */
    public Circuito(int maxNudos) {
        this.MAX_NUDOS=maxNudos;
        this.contador=0;
    }

    /**
     * Mide la tension y la intensidad de un nudo del circuido, en el
     * instante actual y las retorna en un objeto de la clase
     * MedidaElectrica
     * @param  numNudo  el numero de nudo que se desea medir
     * @return La medida electrica con tiempo, voltaje e intensidad
     * @throws IndexOutOfBoundsException: Si el nudo es incorrecto 
     * @throws FueraRango: si la medida es incorrecta por estar furra de rango
     */
    public MedidaElectrica mide(int numNudo) 
    throws FueraRango, IndexOutOfBoundsException
    {
        // si el indide es negativo o supera el numero de nudos lanza excepcion
        if (numNudo<0 || numNudo>=MAX_NUDOS) {
            throw new IndexOutOfBoundsException();
        }
        
        // Cada 4000 medidas simulamos la excepcion FueraRango
        if((contador+1)%4000==0) {
            throw new FueraRango();
        }
        
        // Creamos una medida electrica, simulando la medida 
        // mediante funciones trigonometricas
        MedidaElectrica medida=new MedidaElectrica(5.0*Math.sin(contador/(16.0*Math.PI)),
            0.2*Math.cos(contador/(14.0*Math.PI)),contador*1.0e-3);

        // incrementamos el contador
        contador++;
        
        // retornamos la medida
        return medida;
            

    }
}
