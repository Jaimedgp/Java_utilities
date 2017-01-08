import fundamentos.*;

public class InstruccionBucle {

    public static void main(String[] args) {
        
        double num, anterior;
        double suma = 0;

        Lectura valor = new Lectura("Valor");
        valor.creaEntrada("Valor", 0.0);
        valor.espera();

        num = valor.leeDouble("Valor");

        do {
            anterior = num;
            valor.espera("Dame un numero nuevo");

            num = valor.leeDouble("Valor");
            
            if (num >= anterior) {
                suma += Math.pow((num-anterior), 2);
            }
        } while (num >= anterior);

        System.out.println(suma);
    }
}