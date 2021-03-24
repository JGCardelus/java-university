import personas.*;

public class OSI {
	private Persona personas[];
	private Persona contagiados[];
	private Hospital hospitales[];

	OSI(Hospital[] hospitales, Persona[] contagiados, Persona[] personas) {
		this.setHospitales(hospitales);
		this.setContagiados(contagiados);
		this.setPersonas(personas);
	}

	public boolean ingresar(Persona paciente) {
		for (Hospital hospital : this.hospitales) {
			if (!hospital.isLleno()) {
				hospital.ingresar(paciente);
				return true;
			}
		}
		return false;
	}

	public void setPersonas(Persona[] personas) {
		this.personas = personas;
	}

	public Persona[] getPersonas() {
		return this.personas;
	}

	public void setContagiados(Persona[] contagiados) {
		this.contagiados = contagiados;
	}

	public Persona[] getContagiados() {
		return this.contagiados;
	}

	public void setHospitales(Hospital[] hospitales) {
		this.hospitales = hospitales;
	}

	public Hospital[] getHospitales() {
		return this.hospitales;
	}

	public Hospital findPaciente(Persona paciente) {
		for (Hospital hospital : this.hospitales) {
			if (hospital.includes(paciente)) {
				return hospital;
			}
		}
		return null;
	}

	public float getContagiadosVsIngresados() {
		float contagiados = (float) this.contagiados.length;
		float ingresados = (float) 0;
		for (Hospital hospital : this.hospitales)
			ingresados += (float) hospital.getNumeroPacientes();

		return ingresados / contagiados * 100;
	}

	public float getAverageRiesgo() {
		float sumador = 0;
		for (Persona contagiado : this.contagiados)
			sumador += contagiado.getRiesgo();
		
		float media = 0;
		if (this.contagiados.length > 0)
			media = sumador / this.contagiados.length;

		return media;
	}
}
