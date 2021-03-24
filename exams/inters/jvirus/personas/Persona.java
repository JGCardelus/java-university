package personas;

public abstract class Persona {
	private int problemasRespiratorios;
	private int problemasCardiacos;

	private boolean contagiado;
	private Persona contactos[];

	Persona(boolean contagiado, Persona contactos[], int problemasRespiratorios, int problemasCardiacos) {
		this.setContagiado(contagiado);
		this.setContactos(contactos);
		this.setProblemasCardiacos(problemasCardiacos);
		this.setProblemasRespiratorios(problemasRespiratorios);
	}

	Persona() {
		this(false, new Persona[0], 0, 0);
	}

	public void setProblemasCardiacos(int problemasCardiacos) {
		this.problemasCardiacos = problemasCardiacos;
	}

	public int getProblemasCardiacos() {
		return this.problemasCardiacos;
	}

	public void setProblemasRespiratorios(int problemasRespiratorios) {
		this.problemasRespiratorios = problemasRespiratorios;
	}

	public int getProblemasRespiratorios() {
		return this.problemasRespiratorios;
	}

	public void setContactos(Persona contactos[]) {
		this.contactos = contactos;
	}

	public Persona[] getContactos() {
		return this.contactos;
	}

	public void setContagiado(boolean contagiado) {
		this.contagiado = contagiado;
	}

	public boolean getContagiado() {
		return this.contagiado;
	}

	public boolean isContagiado() {
		return this.getContagiado();
	}

	public float getRiesgo() {
		float problemasRespiratorios = (float) this.problemasRespiratorios;
		float problemasCardiacos = (float) this.problemasRespiratorios;

		return (problemasRespiratorios / 8) + (problemasCardiacos / 10);
	}

	public float getIndiceContagio() {
		float indiceContagio = -1;
		if (this.isContagiado()) {
			float contactosContagiados = (float) 0;
			for (Persona contacto : this.contactos) {
				if (contacto.isContagiado()) {
					contactosContagiados++;
				}
			}
			float contactosLength = (float) this.contactos.length;
			indiceContagio = contactosContagiados / contactosLength;
		}

		return indiceContagio;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nPersona: ");
		sb.append("\n\tProblemas respiratorios: ");
		sb.append(this.getProblemasRespiratorios());
		sb.append("\n\tProblemas cardiacos: ");
		sb.append(this.getProblemasCardiacos());
		sb.append("\n\tContagiado: ");
		sb.append(this.isContagiado());
		sb.append("\n\tIndice contagio: ");
		sb.append(this.getIndiceContagio());
		return sb.toString();
	}
}
