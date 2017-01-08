public class Suma {

	public static double sumaFila(double m[][], int i) {
		double suma = 0;
		for (double element : m[i]) {
			suma += element;
		}
		return suma;
	}
}