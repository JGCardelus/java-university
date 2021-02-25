public class Usuario {
	public static final int DNI_LENGTH = 9;
	public static final int MAX_EDAD = 120;

	private String dni;
	private String nombre;
	private String apellidos;
	private String username;
	private int edad;

	Usuario(String username, String dni, String nombre, String apellidos, int edad) {
		this.setUsername(username);
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setEdad(edad);
	}

	Usuario(String username, String dni) {
		this.setUsername(username);
		this.setDni(dni);
	}

	public void setDni(String dni) {
		if (dni.length() == DNI_LENGTH) {
			this.dni = dni;
		}
	}

	public String getDni() {
		return this.dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setUsername(String username) {
		if (!username.equals("")) {
			this.username = username;
		}
	}

	public String getUsername() {
		return this.username;
	}

	public void setEdad(int edad) {
		if (edad > 0 && edad < MAX_EDAD) {
			this.edad = edad;
		}
	}

	public int getEdad() {
		return this.edad;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario comp = (Usuario) obj;
			if (comp.getDni().equals(this.getDni())) 
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder information = new StringBuilder(this.getUsername());
		if (this.getNombre() != null) {
			information.append("\n\tNombre: ");
			information.append(this.getNombre());
		}
		if (this.getApellidos() != null) {
			information.append("\n\tApellidos: ");
			information.append(this.getApellidos());
		}
		if (this.getEdad() != 0) {
			information.append("\n\tEdad: ");
			information.append(this.getEdad());
		}
		information.append("\n\tDNI: ");
		information.append(this.getDni());

		return information.toString();
	}
}
