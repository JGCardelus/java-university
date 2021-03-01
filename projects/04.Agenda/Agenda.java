public class Agenda {
	private List<Usuario> usuarios;

	Agenda() {
		usuarios = new List<>();
	}

	public void setUsuarios(Usuario usuarios[]) {
		this.usuarios.clear();
		this.usuarios.push(usuarios);
	}

	public Usuario getUsuario(int index) {
		return this.usuarios.get(index);
	}

	public Usuario[] allUsuarios() {
		Usuario[] usuarios = new Usuario[this.usuarios.length()];
		// Current limitations in the List class don't allow me to return
		// the array as Usuario
		for (int i = 0; i < this.usuarios.length(); i++) {
			usuarios[i] = this.usuarios.get(i);
		}
		return usuarios;
	}

	public void deleteUser(Usuario usuario) {
		if (usuario != null) {
			this.usuarios.pop(usuario);
		}
	}

	public Usuario findUser(String dni) {
		Usuario challengeUser = new Usuario(dni);

		int index = this.usuarios.indexOf(challengeUser);
		if (index < 0) {
			return null;
		} else {
			return this.usuarios.get(index);
		}
	}

	public boolean newUser(Usuario user) {
		boolean dniOK = Usuario.checkDni(user.getDni());
		if (dniOK) {
			if (!this.usuarios.includes(user)) {
				this.usuarios.push(user);
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public void modifyUser(Usuario usuario) {
		int index = this.usuarios.indexOf(usuario);
		this.usuarios.set(index, usuario);
	}
}
