import personas.*;

public class Hospital {
	private String nombre;
	private int capacidad;
	
	private int numeroPacientes;
	private Persona pacientes[];

	Hospital(String nombre, int capacidad) {
		this.setNombre(nombre);
		this.setCapacidad(capacidad);
	}

	public int getNumeroPacientes() {
		return this.numeroPacientes;
	}

	public void ingresar(Persona paciente) {
		if (!this.isLleno()) {
			for (int i = 0; i < this.pacientes.length; i++) {
				if (this.pacientes[i] == null) {
					this.pacientes[i] = paciente;
					this.numeroPacientes++; // New paciente
					i = this.pacientes.length; // Stop loop
				}
			}
		}
	}

	public boolean includes(Persona paciente) {
		for (Persona challengePaciente : this.pacientes) {
			if (challengePaciente.equals(paciente)) {
				return true;
			}
		}
		return false;
	}

	public Persona[] getPacientes() {
		return this.pacientes;
	}

	public boolean isLleno() {
		boolean lleno = true;
		if (this.numeroPacientes < this.pacientes.length)
			lleno = false;
		return lleno;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
		this.pacientes = new Persona[capacidad];
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Hospital: ");
		sb.append(this.getNombre());
		sb.append("\n\tCapacidad: ");
		sb.append(this.getCapacidad());
		sb.append("\n\tPacientes ingresados: ");
		sb.append(this.numeroPacientes);
		return sb.toString();
	}
}
