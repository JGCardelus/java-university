public class AppAgenda01 {
	public static void main(String args[]) {
		Agenda agenda = new Agenda();

		// Create menu
		Menu menu = new Menu();
		menu.addMenuOption(new MenuOption(1, "Crear persona"));
		menu.addMenuOption(new MenuOption(2, "Buscar persona"));
		menu.addMenuOption(new MenuOption(3, "Eliminar persona"));
		menu.addMenuOption(new MenuOption(4, "Modificar persona"));
		menu.addMenuOption(new MenuOption(5, "Mostrar lista"));
		menu.addMenuOption(new MenuOption(9, "Salir"));

		
		boolean running = true;
		while (running) {
			int option = Terminal.askApp(menu);
			application(option, agenda);

			if (option == 9) {
				running = false;
			}
		}

		Terminal.bye();
	}

	public static void application(int option, Agenda agenda) {
		if (option == 1) {
			newUser(agenda);
		} else if (option == 2) {
			findAndShowUser(agenda);
		} else if (option == 3) {
			deleteUser(agenda);
		} else if (option == 4) {
			modifyUser(agenda);
		} else if (option == 5) {
			showAll(agenda);
		}
	}

	public static Usuario findUser(Agenda agenda) {
		String dni = Terminal.ask("DNI");
		return agenda.findUser(dni);
	}

	public static void deleteUser(Agenda agenda) {
		Terminal.title("Eliminar usuario");
		Usuario usuario = findUser(agenda);
		agenda.deleteUser(usuario);
		showUser(usuario);
		Terminal.notify("Ha sido eliminado");
	} 

	public static void showUser(Usuario usuario) {
		if (usuario == null) {
			Terminal.warn("Usuario no encontrado");
		} else {
			System.out.println("\n/ " + usuario.toString());
		}
	}

	public static void findAndShowUser(Agenda agenda) {
		Terminal.title("Buscar usuario");

		Usuario usuario = findUser(agenda);
		showUser(usuario);
	}

	public static void newUser(Agenda agenda) {
		Terminal.title("Nuevo usuario");

		String dni = "";
		while (!Usuario.checkDni(dni)) {
			dni = Terminal.ask("DNI");
			if (!Usuario.checkDni(dni))
				Terminal.warn("El DNI debe tener " + Usuario.DNI_LENGTH + " caracteres.");
		}
			
		
		String username = Terminal.ask("Usuario");
		String nombre = Terminal.ask("Nombre");
		String apellidos = Terminal.ask("Apellidos");
		int edad = 0;
		try {
			edad = Integer.parseInt(Terminal.ask("Edad"));
		} catch (Exception e) {
			Terminal.warn("La edad introducida es incorrecta. Dejando 0.");
		}

		Usuario newUser = new Usuario(dni, username, nombre, apellidos, edad);
		boolean result = agenda.newUser(newUser);

		if (!result) {
			Terminal.warn("Ese usuario ya existe");
			newUser(agenda);
		} else {
			Terminal.notify("Hello " + username + "!");
		}
	}

	public static void modifyUser(Agenda agenda) {
		Terminal.title("Modificar usuario");
		
		Usuario usuario = null;
		while (usuario == null) {
			usuario = findUser(agenda);
		}

		String username = Terminal.ask("Usuario -> " + usuario.getUsername());
		usuario.modifyUsername(username);
		String nombre = Terminal.ask("Nombre -> " + usuario.getNombre());
		usuario.modifyNombre(nombre);
		String apellidos = Terminal.ask("Apellidos -> " + usuario.getApellidos());
		usuario.modifyApellidos(apellidos);

		int edad = usuario.getEdad();
		try {
			edad = Integer.parseInt(Terminal.ask("Edad -> " + edad));
		} catch (Exception e) {
			Terminal.warn("La edad introducida es incorrecta. Dejando " + usuario.getEdad());
		}
		usuario.modifyEdad(edad);

		agenda.modifyUser(usuario);
	}

	public static void showAll(Agenda agenda) {
		Terminal.title("Todos los usuarios");
		
		Usuario usuarios[] = agenda.allUsuarios();
		for (Usuario usuario:usuarios)
			showUser(usuario);
	}
}
