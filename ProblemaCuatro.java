public class ProblemaCuatro {

        private double[] x;
        /**
         * Metodo que convierte todos los angulos en grados del array grados a radianes
         *
         * @param  grados array de numeros reales conteniendo angulos en grados 
         * @return array con todos los angulos convertidos a radianes
         */
    public static double[] cambioGrados(double[] grados) {

        double[] radians = new double[grados.length]; // Se crea un array radians del mismo tamaño que grados
        
            // bucle for que recorre todos los elementos del array grados
            // El i<grados.length es debido a que el ultimo elemento de grados no es igual al tamaño del array (1ºelemento=0)
        for (int i = 0; i<grados.length ; i++ ) {
            radians[i] = Math.toRadians(grados[i]); // Se pasan los elementos de grados a radianes en el mismo elemento del array radians
        }
        return radians; // Se retorna el array radians
    }

        /**
         * Método que calcula la máxima diferencia entre una casilla del array que se guarda como atributo de la clase y la anterior
         *
         * @return double maxDif
         */
    public double maximaDiferencia() {

        double[] x = {1,67,3,4,5,6};
        
        double maxDif = -Double.MAX_VALUE; // Se inicia maxDif por el menor numero real (mayor numero real pero negatico)
            
            // Bucle for que recorre todos los elementos del array x
        for (int i=1; i<x.length ; i++) {
            double dif = Math.abs(x[i]-x[i-1]); // Puesto que no se expecifica en el pseudocodigo, se entendera que dif es de tipo real
            
                // Si el valor obtenido es mayor que las otras diferencias obtenidas, esta sera la mayor diferencia
                // Al iniciar maxDiff con el menor numero real posible se asegura que cualquier diferencia inicial sea mayor
            if (dif>maxDif) {
                maxDif = dif;
            }
        }
        return maxDif; // Se retorna la mayor diferencia obtenida
    }


        /**
         * método busquedaArray(texto texto, texto palabra) retorna real
         *      texto[nº palabras en parametro texto] ray
         *      entero n=0
         *      Para i desde 0 hasta tamaño de ray
         *          si ray[i].indexOf(palabra) != -1
         *              n++
         *          fin si
         *      fin para
         *      retorna n
         *  fin del método
         */

        /**
         * Metodo que busca el numero de veces que se repite una palabra en un String
         *
         * @param String texto, String palabra
         * @return double n
         */
    public static double busquedaArray(String texto, String palabra) {

        String[] ray = texto.split("\\s+"); // Se separa texto en un array cada vez que se encuentre un espacio, 

        int n=0; // Se inicializa la variable de numero de veces que se encuentra palabra      

            // Bucle for que recorre todo el array ray
        for (int i = 0; i<(ray.length) ; i++) {

                // La condicion es que se encuentra 'palabra' en el elemento 
            if (ray[i].indexOf(palabra)!=-1) {  // palabra.equals(ray[i])
                n++; // se suma 1 a n cada vez que se encuentre 'palabra'
            }
        }
        
        return n; // se retorna el n` de veces que se ha encontrado 'palabra' 
    }
}