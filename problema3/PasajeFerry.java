import fundamentos.*;

public class PasajeFerry {

	public static final int ECONOMIE=1;
	public static final int CRUCERO=2;
	public static final int LUXURY=3;
	private int pasajeros;
	private double coste;

	public PasajeFerry(int pasajeros,int camarote) {

		this.pasajeros = pasajeros;

		switch (camarote) {
			
			case ECONOMIE:
				switch (pasajeros) {
					case 1:
						this.coste = 186.0;
						break;
					case 2:
						this.coste = 186.0 + 173.0;
						break;
					default:
						this.coste = 186.0 + 173.0 + 162.0*(pasajeros-2);
				}

			case CRUCERO:
				switch(pasajeros){
	                case 1:
                		this.coste=223.0;
                		break;
	                case 2:
                		this.coste=223.0+212.0;
                		break;
                	default:
                		this.coste=198.0*(pasajeros-2)+223.0+212.0;
           		}

           	case LUXURY:
            	switch(pasajeros){
                	case 1:
                		this.coste=330.0;
                		break;
                	case 2:
                		this.coste=330.0+310.0;
                		break;
                	default:
                		this.coste=291*(pasajeros-2)+330.0+310.0;
            }
		}

		////////////////////////////////////////////

		this.pasajeros = pasajeros;

		if (pasajeros == 1) {
			
			switch (camarote) {
				
				case ECONOMIE:
					this.coste = 186;
					break;
				case CRUCERO:
					this.coste = 223.0;
					break;
				default:
					this.coste = 330.0;
			}
		} else {

			switch (camarote) {
				
				case ECONOMIE:
					this.coste = 359 + 162*(pasajeros-2) // 359 = 186.0 + 173.0
					break;
				case CRUCERO:
					this.coste = ////////////........///////
			}
		}
	}
}