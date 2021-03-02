public class AppAgenda01 {
	public static void main(String args[]) {
		Agenda agenda = new Agenda();

		boolean running = true;

		while (running) {
			int option = Terminal.preguntarAplicacion();
			aplicacion(option, agenda);

			if (option == 9) {
				running = false;
			}
		}
	}

	public static void aplicacion(int option, Agenda agenda) {
		switch (option) {
			case 1:
				nuevoContacto(agenda);
				break;
			case 2: 
				buscarContactoMostrar(agenda);
				break;
			case 3:
				eliminarContacto(agenda);
				break;
			case 4:
				modificarContacto(agenda);
				break;
			case 5:
				mostrarTodos(agenda);
				break;
			default: break;
		}
	}

	public static void mostrarContacto(Contacto contacto) {
		if (contacto == null) {
			System.out.println("Ese contacto no existe");
		} else {
			System.out.println(contacto.toString());
		}
	}

	public static void nuevoContacto(Agenda agenda) {
		String dni = Terminal.preguntar("DNI");
		String nombre = Terminal.preguntar("Nombre");
		String apellidos = Terminal.preguntar("Apellidos");
		int edad = Integer.parseInt(Terminal.preguntar("Edad"));

		Contacto contacto = new Contacto(dni, nombre, apellidos, edad);
		boolean creado = agenda.nuevoContacto(contacto);
		if (!creado) {
			Terminal.avisar("Ese usuario ya ha sido creado");
			nuevoContacto(agenda);
		} else {
			mostrarContacto(contacto);
			Terminal.notificar("Hola " + nombre + "!");
		}
	}

	public static void modificarContacto(Agenda agenda) {
		Contacto contacto = buscarContacto(agenda);
		if (contacto != null) {
			int posicion = agenda.buscarContacto(contacto);

			String dni = Terminal.preguntar("DNI (" + contacto.getDni() + ")");
			String nombre = Terminal.preguntar("Nombre (" + contacto.getNombre() + ")");
			String apellidos = Terminal.preguntar("Apellidos (" + contacto.getApellidos() + ")");
			int edad = Integer.parseInt(Terminal.preguntar("Edad (" + contacto.getEdad() + ")"));

			if (!dni.equals(contacto.getDni())) {
				contacto.setDni(dni);
			}

			if (!nombre.equals(contacto.getNombre())) {
				contacto.setNombre(nombre);
			}

			if (!apellidos.equals(contacto.getApellidos())) {
				contacto.setApellidos(apellidos);
			}

			if (edad != contacto.getEdad()) {
				contacto.setEdad(edad);
			}

			boolean modificado = agenda.modificarContacto(posicion, contacto);
			if (modificado) {
				Terminal.avisar("Contacto modificado correctamente");
				mostrarContacto(contacto);
			} else {
				Terminal.avisar("Ha habido un error modificado el contacto");
			}
		} else {
			Terminal.avisar("Ese contacto no existe");
		}
	}

	public static void buscarContactoMostrar(Agenda agenda) {
		Contacto contacto = buscarContacto(agenda);
		mostrarContacto(contacto);
	}

	public static Contacto buscarContacto(Agenda agenda) {
		String dni = Terminal.preguntar("DNI");
		int posicion = agenda.buscarContacto(dni);
		return agenda.cogerContacto(posicion);
	}

	public static void eliminarContacto(Agenda agenda) {
		Contacto contacto = buscarContacto(agenda);
		if (contacto != null) {
			boolean eliminado = agenda.eliminarContacto(contacto);
			if (eliminado) {
				Terminal.notificar("Usuario eliminado");
			} else {
				Terminal.avisar("Ese usuario no existe");
			}
		} else {
			Terminal.avisar("Ese usuario no existe");
		}
	}

	public static void mostrarTodos(Agenda agenda) {
		for (Contacto contacto:agenda.cogerTodos()) {
			if (contacto != null)
				mostrarContacto(contacto);
		}
	}
}
