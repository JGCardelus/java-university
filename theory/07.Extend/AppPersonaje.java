public class AppPersonajeje {
	public static void main(String args[]) {
		Personaje.setPLANETA("La Tierra");
		// Objectos, ocurrencias o instancias de la clase Personaje
		Personaje personaje1 = new Personaje("Jorge", 15);
		Personaje personaje2 = new Personaje(15, "Jorge");

		personaje1.print();
		personaje2.print();
	}	
}
