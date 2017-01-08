/**
* 
*
* @author Jaime Diez Gonzalez-Pardo
*
* @version 4 Abril 2016
*
*/

public class MainCohete {

	public static void main(String[] args) {
		
		Cohete apolo11 = new Cohete(1000, 0.1, 3, 1);

		System.out.println("      " +  "APOLO 11");

		System.out.println("" + apolo11.t0() + "\n" + apolo11.tmax() + "\n" + apolo11.vmax() + "\n" + apolo11.altmax() + "\n" + "\n");
		
		System.out.println("" + apolo11.v(apolo11.t0()/2.0) + "\n" + apolo11.v(apolo11.tmax()/2.0) + "\n" + apolo11.v(apolo11.tmax()*1.1) + "\n" + "\n");

		System.out.println("" + apolo11.x(apolo11.t0()/2.0) + "\n" + apolo11.x(apolo11.tmax()/2.0) + "\n" + apolo11.x(apolo11.tmax()*1.1) + "\n" + apolo11.x(apolo11.tmax()) + "\n" + "\n");

		Cohete apolo12 = new Cohete(1000, 0.11, 12, 3);

		System.out.println("     " + "APOLO 12");

		System.out.println("" + apolo12.t0() + "\n" + apolo12.tmax() + "\n" + apolo12.vmax() + "\n" + apolo12.altmax() + "\n" + "\n");
		
		System.out.println("" + apolo12.v(apolo12.t0()/2.0) + "\n" + apolo12.v(apolo12.tmax()/2.0) + "\n" + apolo12.v(apolo12.tmax()*1.1) + "\n" + "\n");

		System.out.println("" + apolo12.x(apolo12.t0()/2.0) + "\n" + apolo12.x(apolo12.tmax()/2.0) + "\n" + apolo12.x(apolo12.tmax()*1.1) + "\n" + apolo12.x(apolo12.tmax()) + "\n" + "\n");

	}
}
