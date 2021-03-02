public class Contacto {
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;

	Contacto(String dni, String nombre, String apellidos, int edad) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setEdad(edad);
	}

	Contacto(String dni) {
		this(dni, "", "", 0);
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public void setEdad(int edad) {
		if (edad >= 0) {
			this.edad = edad;
		}
	}

	public int getEdad() {
		return this.edad;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Contacto) {
			Contacto challengeContacto = (Contacto) object;
			if (this.getDni() == null || challengeContacto.getDni() == null)
				return false;
			
			if (challengeContacto.getDni().equals(this.getDni()))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder("/");
		info.append(this.getDni());
		
		String prefix = "\n/\t";
		if (!this.getNombre().equals("")) {
			info.append(prefix);
			info.append("Nombre: ");
			info.append(this.getNombre());
		}

		if (!this.getApellidos().equals("")) {
			info.append(prefix);
			info.append("Apellidos: ");
			info.append(this.getApellidos());
		}

		if (this.getEdad() > 0) {
			info.append(prefix);
			info.append("Edad: ");
			info.append(this.getEdad());
		}

		return info.toString();
	}
}
