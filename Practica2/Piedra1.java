
/**
 * Write a description of class Piedra2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piedra1{

    public static void main(String[] args) {
        Piedra p = new Piedra(0.0,0.0,20.0,10.0);
        // los parametros indican la pos. y vel. iniciales
        System.out.println(p.getPosX());
        System.out.println(p.getPosY());
        
        p.avanzaTiempo(0.5);

        System.out.println(p.getPosX());
        System.out.println(p.getPosY());
    }
}