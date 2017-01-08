public class Mouse extends Rodentia {

	String name;

	public Mouse(String name) {

		this.name = name;

	}

	public void eat() {

		System.out.println(name + " ate some cheese pizza!");

	}

	public void solveMaze(int minutes) {

		System.out.println(name + " solved the maze in " + minutes + " minutes!");

	}

	public static void main(String[] args) {

		Mouse ratly = new Mouse("Ratly");
		ratly.eat();
		ratly.solveMaze(3);
		ratly.order();

	}

}

  ///////////////////////////////////////////////////////////////////////
 ///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////

public class Bicicleta {

	public void color(String color) {

		System.out.println(color);

	}

	public void ruedas() {

		System.out.println("Como todas las bicicletas tiene dos ruedas");

	}

	public static void main(String[] args) {
		
		Bicicleta Mountain = new Bicicleta("Mountain");

		Mountain.ruedas();
		Mountain.color("red");

	}

}
