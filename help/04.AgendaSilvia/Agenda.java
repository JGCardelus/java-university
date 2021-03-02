public class Agenda {
	private Contacto contactos[];

	Agenda() {
		// Te permito 10 contactos
		this.contactos = new Contacto[10];
	}

	public int buscarContacto(Contacto contacto) {
		int posicion = -1;
		for (int i = 0; i < this.contactos.length; i++) {
			Contacto challengeContacto = this.contactos[i];
			if (challengeContacto != null) {
				if (contacto.equals(challengeContacto)) {
					// Donde está el contacto que estamos buscando
					posicion = i;
					// Obligo al for a detenerse
					i = this.contactos.length;
				}
			}
		}
		
		return posicion;
	}

	public int buscarContacto(String dni) {
		Contacto contacto = new Contacto(dni);
		return this.buscarContacto(contacto);
	} 

	public boolean nuevoContacto(Contacto contacto) {
		int posicion = this.buscarContacto(contacto);
		if (posicion < 0) {
			// No lo hemos añadido
			for (int i = 0; i < this.contactos.length; i++) {
				if (this.contactos[i] == null) {
					// Lo añadimos
					this.contactos[i] = contacto;
					// Avisamos de que hemos añadido el contacto
					return true;
				}
			}
			// La lista tiene que estar llena, no hemos podido añadir el contacto
			return false;
		}
		// Avisamos de que no lo hemos podido añadir
		return false;
	}

	public boolean eliminarContacto(Contacto contacto) {
		int posicion = this.buscarContacto(contacto);
		if (posicion >= 0) {
			this.contactos[posicion] = null; // Liberamos ese contacto
			return true;
		}
		return false;
	}

	public Contacto[] cogerTodos() {
		return this.contactos;
	}

	public Contacto cogerContacto(int posicion) {
		if (posicion >= 0 && posicion < this.contactos.length) {
			return this.contactos[posicion];
		}
		return null;
	}

	public boolean modificarContacto(int posicion, Contacto contacto) {
		if (posicion >= 0 && posicion < this.contactos.length) {
			this.contactos[posicion] = contacto;
			return true;
		}
		return false;
	}
}
