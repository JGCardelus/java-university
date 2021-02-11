public class AppPersona {
	public static void main(String args[]) {
		// Objectos, ocurrencias o instancias de la clase persona
		Persona persona1 = new Persona("Jorge", 15);
		Persona persona2 = new Persona(15, "Jorge");

		persona1.print();
		persona2.print();
	}	
}
