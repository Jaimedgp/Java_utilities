public class Main1 {

	public static void main(String[] args) {
		
		 Imagen ImgEdificio = new Imagen(500, 100, "edificio.jpg"); // Se inserta la imagen del edificio del fichero

		Figura.AvionPapel();

		Figura.mueve2();

		Figura.espera(200);

                // Coordenadas finales del avion

            int i = 800 - (70 * (y-1)); 

            int j = 100 + (70 * (x-2));

        Imagen ImgBoom = new Imagen(j, i, "boom.png"); // Se inserta la imagen  del boom
	}
}