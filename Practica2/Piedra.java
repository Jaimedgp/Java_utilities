/**
* Esta clase simula la caida de una piedra
*/

public class Piedra {

	// atributos que definen el movimiento 
	private double posX, posY; //posicion, metros
	private double velX, velY; //velocidad, m/s

	//constante que define la gravedad
	public final double g = 9.8; // m/s^2

	/**
	* Constructor que pone las condiciones
	*iniciales, copiandolas de los argumentos.
	*Unidades: m y m/s
	*/
	public Piedra (double posX, double posY, double velX, double velY) {

		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
	}

	/**
	* Retorna la posicion X (m)
	*/
	public double getPosX() {

		return posX;
	}

	public double getPosY() {

		return posY;
	}

	/**
	* Avanza el tiempo en la cantidad t (s)
	*actualiza las posiciones y las velocidades
	*/
	public void avanzaTiempo(double t) {

		posX = posX + velX*t;
		posY = posY + velY*t - g*t*t/2.0;
			// velX no cambia
		velY = velY - g*t;
	}

}