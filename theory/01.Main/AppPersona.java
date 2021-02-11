public class AppPersona {
	public static void main(String args[]) {
		Persona persona = new Persona();
		// Set nombre
		if (args.length == 2) {
			String nombre = args[0];
			int edad = Integer.parseInt(args[1]);
			persona.setNombre(nombre);
			persona.setEdad(edad);
		}

		persona.print();
	}	
}
