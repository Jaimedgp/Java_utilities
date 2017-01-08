import fundamentos.*;
public class Grafica {
       public static void main(String[] args) {

         Piedra p = new Piedra(0.0,0.0,20.0,10.0);
        
        Grafica g = new Grafica (String"Piedra",String"x",String"y");

            g.inserta(p.getPosX(),p.getPosY());

            p.avanzaTiempo(0.5);

            g.inserta(p.getPosX(),p.getPosY());

            g.pinta();
    }
    
}