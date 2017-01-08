public class CrarCirculo {

	public static void main(String[] args) {
		
		Circulo mercurio = new Circulo(20, 10, 50, 1);
		Circulo venus = new Circulo(80, 70, 60, 1);
		Circulo tierra = new Circulo(150, 150, 70, 1);

		int colorMercurio = mercurio.color;
		int colorTierra = tierra.color;
		int colorVenus = venus.color;

		int corteza = mercurio.grosorLapiz;
		int numPlanetas = Circulo.dameCirculosCreados();

		mercurio.pintaCirculo();
		venus.pintaCirculo();
		tierra.pintaCirculo();
	}
}