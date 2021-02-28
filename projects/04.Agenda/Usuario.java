public class Usuario {
	public static final int DNI_LENGTH = 2;
	public static final int MAX_EDAD = 120;

	private String dni;
	private String nombre;
	private String apellidos;
	private String username;
	private int edad;

	Usuario(String dni, String username, String nombre, String apellidos, int edad) {
		this.setUsername(username);
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setEdad(edad);
	}

	Usuario(String dni, String username) {
		this(dni, username, "", "", 0);
	}

	Usuario(String dni) {
		this(dni, "", "", "", 0);
	}

	public boolean setDni(String dni) {
		if (dni.length() == DNI_LENGTH) {
			this.dni = dni;
			return true;
		} 
		return false;
	}

	public boolean modifyDni(String dni) {
		if (!this.dni.equals(dni) && !dni.equals("")) {
			return this.setDni(dni);
		}
		return true;
	}

	public String getDni() {
		return this.dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void modifyNombre(String nombre) {
		if (!this.nombre.equals(nombre) && !nombre.equals("")) {
			this.setNombre(nombre);
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void modifyApellidos(String apellidos) {
		if (!this.apellidos.equals(apellidos) && !apellidos.equals("")) {
			this.setApellidos(apellidos);
		}
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setUsername(String username) {
		if (!username.equals("")) {
			this.username = username;
		} else {
			this.username = "";
		}
	}

	public void modifyUsername(String username) {
		if (!this.username.equals(username) && !username.equals("")) {
			this.setUsername(username);
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

	public void modifyEdad(int edad) {
		if (this.edad != edad) {
			this.setEdad(edad);
		}
	}
	
	public int getEdad() {
		return this.edad;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario comp = (Usuario) obj;

			String compDni = comp.getDni();
			if (compDni == null) {
				return false;
			}

			String thisDni = this.getDni();
			if (thisDni == null) {
				return false;
			}

			if (compDni.equals(thisDni)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder information = new StringBuilder(this.getDni());
		if (!this.getUsername().equals("")) {
			information.append("\n\tUsuario: ");
			information.append(this.getUsername());
		}
		if (!this.getNombre().equals("")) {
			information.append("\n\tNombre: ");
			information.append(this.getNombre());
		}
		if (!this.getApellidos().equals("")) {
			information.append("\n\tApellidos: ");
			information.append(this.getApellidos());
		}
		if (this.getEdad() != 0) {
			information.append("\n\tEdad: ");
			information.append(this.getEdad());
		}

		return information.toString();
	}
}
