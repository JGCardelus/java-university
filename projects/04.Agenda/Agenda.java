public class Agenda {
	private List<Usuario> usuarios;

	Agenda() {
		usuarios = new List<>();
	}

	public void setUsuarios(Usuario usuarios[]) {
		this.usuarios.clear();
		this.usuarios.push(usuarios);
	}

	public Usuario[] getUsuarios() {
		return (Usuario[]) this.usuarios.all();
	}

	/**
	 * State machine that runs program
	 */
	public void run() {
		boolean running = true;
		while (running) {
			int option = menu();
			this.application(option);

			if (option == 9) {
				running = false;
			}
		}

		System.out.print("\n\nBye!\n");
	}

	public void application(int option) {
		if (option == 1) {
			this.newUser();
		} else if (option == 2) {
			this.findAndShowUser();
		} else if (option == 3) {
			this.deleteUser();
		} else if (option == 4) {
			this.modifyUser();
		} else if (option == 5) {
			this.showAll();
		}
	}

	public void showAll() {
		this.title("Todos los usuarios");
		for (Object usuario:this.usuarios.all()) {
			// Problems with List class (cannot return generic class)
			if (usuario instanceof Usuario)
				this.showUser((Usuario) usuario);
		}
	}

	public void deleteUser() {
		this.title("Eliminar usuario");

		Usuario usuario = this.findUser();
		if (usuario != null) {
			Usuario deleted = this.usuarios.pop(usuario);
			this.showUser(deleted);
			System.out.println("Ha sido eliminado");
		}
	}

	public void findAndShowUser() {
		this.title("Buscar usuario");
		Usuario usuario = this.findUser();
		this.showUser(usuario);
	}

	public void showUser(Usuario usuario) {
		this.separator();
		if (usuario == null) {
			System.out.println("Usuario no encontrado");
		} else {
			System.out.println(" -> " + usuario.toString());
		}
	}

	public Usuario findUser() {
		String dni = this.ask("DNI");
		Usuario challengeUser = new Usuario(dni);

		int index = this.usuarios.indexOf(challengeUser);
		if (index < 0) {
			return null;
		} else {
			return this.usuarios.get(index);
		}
	}

	public void newUser() {
		this.title("Nuevo usuario");

		String dni = this.ask("DNI");
		String username = this.ask("Usuario");
		String nombre = this.ask("Nombre");
		String apellidos = this.ask("Apellidos");
		int edad = 0;
		try {
			edad = Integer.parseInt(this.ask("Edad"));
		} catch (Exception e) {
			System.out.println("La edad introducida es incorrecta. Dejando 0.");
		}
		
		Usuario newUser = new Usuario(dni, username, nombre, apellidos, edad);

		boolean dniOK = newUser.setDni(dni);
		if (dniOK) {
			if (!this.usuarios.includes(newUser)) {
				this.usuarios.push(newUser);
				System.out.println("Hola " + username + "!");
			} else {
				System.out.println("Este usuario ya existe.");
				this.newUser();
			}
		} else {
			System.out.println("El dni introducido es incorrecto. Debe tener " + Usuario.DNI_LENGTH + " caracteres");
			this.newUser();
		}
	}

	public void modifyUser() {
		this.title("Modificar usuario");
		
		Usuario usuario = null;
		while (usuario == null) {
			usuario = this.findUser();
		}

		boolean dniOK = false;
		while (!dniOK) {
			String dni = this.ask("DNI -> " + usuario.getDni());
			dniOK = usuario.modifyDni(dni);
		}
		

		String username = this.ask("Usuario -> " + usuario.getUsername());
		usuario.modifyUsername(username);
		String nombre = this.ask("Nombre -> " + usuario.getNombre());
		usuario.modifyNombre(nombre);
		String apellidos = this.ask("Apellidos -> " + usuario.getApellidos());
		usuario.modifyApellidos(apellidos);

		int edad = usuario.getEdad();
		try {
			edad = Integer.parseInt(this.ask("Edad -> " + edad));
		} catch (Exception e) {
			System.out.println("La edad introducida es incorrecta. Dejando " + usuario.getEdad());
		}
		usuario.modifyEdad(edad);
	}

	public int menu() {
		StringBuilder menu = new StringBuilder();
		menu.append("\n\n\n*********************");
		menu.append("\n*        MENU       *");
		menu.append("\n*********************");
		menu.append("\n\n");
		menu.append("\n\t1. Crear persona");
		menu.append("\n\t2. Buscar persona");
		menu.append("\n\t3. Eliminar persona");
		menu.append("\n\t4. Modificar persona");
		menu.append("\n\t5. Mostrar lista");
		menu.append("\n\t9. Salir");
		menu.append("\n\n\n\t >> ");
		System.out.print(menu.toString());

		String response = Leer.porTeclado();
		int option = 9;
		try {
			option = Integer.parseInt(response);
		} catch (Exception e) {
			// If there is an error, ask again
			option = menu();
		}

		return option;
	}

	public void title(String title) {
		System.out.println("\n-------------------");
		System.out.println("  " + title + " ");
		System.out.println("-------------------\n\n");
	}

	public void separator() {
		System.out.println("-------------------");
	}

	public String ask(String question) {
		System.out.print(question);
		System.out.print("  >>  ");
		return Leer.porTeclado();
	}
	
}
