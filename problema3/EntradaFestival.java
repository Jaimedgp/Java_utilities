import fundamentos.*;

public class EntradaFestival {

	private String festival;
	private double precio;

	public EntradaFestival(String descripcion) {


		String separador = "precio="
		int a = descripcion.indexOf("precio=");

		if (a==-1) {

			this.festival = "XXX";
			this.precio = Double.NaN;
			
		} else {

			String valor = descripcion.substring(a+7,descripcion.length());

			this.festival = descripcion.substring(0,a).trim();
			this.precio = Double.parseDouble(valor);
		}
	}
}