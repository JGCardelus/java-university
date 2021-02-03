public class AppPersona {
	public static void main(String args[]) {
		// Objectos, ocurrencias o instancias de la clase persona
		Persona persona;
		// Set nombre
		if (args.length == 2) {
			String nombre = args[0];
			int edad = Integer.parseInt(args[1]);
			persona = new Persona(nombre, edad);
		}

		persona.print();
	}	
}
