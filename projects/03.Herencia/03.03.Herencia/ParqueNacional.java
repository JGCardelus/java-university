public abstract class ParqueNacional {
	private int km;
	private int numeroEspecies;
	private String nombre;

	ParqueNacional(String nombre, int km, int numeroEspecies) {
		this.setNombre(nombre);
		this.setKm(km);
		this.setNumeroEspecies(numeroEspecies);
	}

	public void setKm(int km) {
		if (km > 0) {
			this.km = km;
		}
	}

	public int getKm() {
		return this.km;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNumeroEspecies(int numeroEspecies) {
		if (numeroEspecies >= 0) {
			this.numeroEspecies = numeroEspecies;
		}
	}

	public int getNumeroEspecies() {
		return this.numeroEspecies;
	}

	public String getInfo() {
		return 
				"\n\n" + this.getNombre() +
				"\n\tKM: " + this.getKm() +
				"\n\tNumero de especies: " + this.getNumeroEspecies();
	}
}
