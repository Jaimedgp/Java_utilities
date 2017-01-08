
import fundamentos.*;

/**
 * Clase que representa un cuadrado que se pinta en una ventana de la clase Dibujo
 */
public class Linea extends Figura
{
    // coordenadas del cuadrado
    private int x1,y1,x2,y2;
    static private int x;

    /**
     * Constructor al que se le pasan los extremos de la linea en pixels
     */
    public Linea (int x1, int y1, int x2, int y2)
    {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        Figura.lista.anadeFigura(this);
        Figura.lista.pinta();
    }

    /**
     * Pinta la linea
     */
    protected void pinta(Dibujo dib)
    {
        dib.dibujaLinea(x1,y1,x2,y2);
    }

    /**
     * Mueve la linea en la cantidad relativa indicada en Pixels
     */
    public  void mueve(int deltaX, int deltaY) { //Se ha cambiado los argumentos por datos double en vez de int
        x1=x1+deltaX;
        y1=y1+deltaY;
        x2=x2+deltaX;
        y2=y2+deltaY;
        Figura.lista.pinta();
    }

    public static void main(String[] args) {


        Imagen ImgEdificio = new Imagen(500, 100, "edificio.jpg");

        Linea A = new Linea(150, 710, 30, 740);
        Linea B = new Linea(150, 710, 50, 750);
        Linea C = new Linea(30, 740, 50, 750);
        Linea D = new Linea(50, 750, 60, 770);
        Linea F = new Linea(60, 770, 65, 755);
        Linea G = new Linea(65, 755, 150, 710);
        Linea H = new Linea(65, 755, 85, 775);
        Linea W = new Linea(85, 775, 150, 710);
        Linea Y = new Linea(60, 770, 75, 765);

        int z = -35;


        while (z < -20) {

            double u1 = (z + 35)/20.0;
            double o1 = ((-1.0 / z)*60.0);

            int o = (int) o1;
            int u = (int) u1;

            A.espera(20);

            A.mueve(u, -o);
            B.mueve(u, -o);
            C.mueve(u, -o);
            D.mueve(u, -o);
            F.mueve(u, -o);
            G.mueve(u, -o);
            H.mueve(u, -o);
            W.mueve(u, -o);
            Y.mueve(u, -o);

            z += 1;
        }

        while (z < -1) {

            double u1 = (z + 35)/2.0;
            double o1 = ((-1.0 / z)*80.0);

            int o = (int) o1;
            int u = (int) u1;

            A.espera(80);

            A.mueve(u, -o);
            B.mueve(u, -o);
            C.mueve(u, -o);
            D.mueve(u, -o);
            F.mueve(u, -o);
            G.mueve(u, -o);
            H.mueve(u, -o);
            W.mueve(u, -o);
            Y.mueve(u, -o);

            z = z + 1;
        }

        double k = 0;

        while (k < 30) {

            double e1 = k/2;
            double e2 = Math.log((10*k)+1)*2.2;

            int f = (int) e1;
            int e = (int) e2;

            A.espera(8);

            A.mueve(f, -e);
            B.mueve(f, -e);
            C.mueve(f, -e);
            D.mueve(f, -e);
            F.mueve(f, -e);
            G.mueve(f, -e);
            H.mueve(f, -e);
            W.mueve(f, -e);
            Y.mueve(f, -e);

            k = k + 1;

        }
       
            A.mueve(50, 0);
            B.mueve(50, 0);
            C.mueve(50, 0);
            D.mueve(50, 0);
            F.mueve(50, 0);
            G.mueve(50, 0);
            H.mueve(50, 0);
            W.mueve(50, 0);
            Y.mueve(50, 0);


        Imagen ImgEdificio1 = new Imagen(500, 100, "edificio.jpg");

        /////////////////////////////////////////////
        Linea A1 = new Linea(577, 203, 480, 230);
        Linea B1 = new Linea(582, 205, 500, 240);
        Linea G1 = new Linea(585, 208, 515, 245);
        Linea W1 = new Linea(587, 215, 535, 265);
        Linea H1 = new Linea(515, 245, 535, 265);
        Linea C1 = new Linea(480, 230, 500, 240);
        Linea D1 = new Linea(500, 240, 510, 260);
        Linea F1 = new Linea(510, 260, 515, 245);
        Linea Y1 = new Linea(510, 260, 525, 255);


        Linea W2 = new Linea(587, 215, 590, 220);
        Linea W3 = new Linea(590, 220, 592, 212);
        Linea W4 = new Linea(592, 212, 595, 215);
        Linea W5 = new Linea(595, 215, 602, 198);

        Linea G2 = new Linea(585, 208, 588, 213);
        Linea G3 = new Linea(588, 213, 590, 205);
        Linea G4 = new Linea(590, 205, 593, 208);
        Linea G5 = new Linea(593, 208, 602, 198);

        Linea B2 = new Linea(582, 205, 585, 210);
        Linea B3 = new Linea(585, 210, 587, 202);
        Linea B4 = new Linea(587, 202, 590, 205);
        Linea B5 = new Linea(590, 205, 602, 198);

        Linea A2 = new Linea(577, 203, 580, 208);
        Linea A3 = new Linea(580, 208, 582, 200);
        Linea A4 = new Linea(582, 200, 585, 203);
        Linea A5 = new Linea(585, 203, 602, 198);

    }
}
