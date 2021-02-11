public class AppMultiplePersonas {
	public static void main(String args[]) {
		if ((args.length + 1) % 2 == 0) {
			int numeroPersonas = Integer.parseInt(args[0]);
			Persona[] personas = new Persona[numeroPersonas];
			for (int i = 0; i < numeroPersonas; i++) {
				personas[i] = parsePersona(i, args);
				// Print saved parsona
				personas[i].print();
			}
		} else {
			System.out.println("Not enough arguments");
		}
	}

	private static Persona parsePersona(int level, String args[]) {
		Persona nuevaPersona = new Persona();
		String nombre = args[level * 2 + 1];
		int edad = Integer.parseInt(args[level * 2 + 2]);

		nuevaPersona.setNombre(nombre);
		nuevaPersona.setEdad(edad);

		return nuevaPersona;
	}
}
