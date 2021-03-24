package personas;

public class Adulto extends Persona{
	private float factorRiesgo;
	public final float FACTOR_RIESGO_DEFAULT = (float) 0.5;

	public Adulto(boolean contagiado, Persona[] contactos, int problemasRespiratorios, int problemasCardiacos, float factorRiesgo) {
		super(contagiado, contactos, problemasRespiratorios, problemasCardiacos);
		this.setFactorRiesgo(factorRiesgo);
	}

	public void setFactorRiesgo(float factorRiesgo) {
		if (factorRiesgo != 0) {
			this.factorRiesgo = factorRiesgo;
		} else {
			this.factorRiesgo = FACTOR_RIESGO_DEFAULT;
		}
	}

	public float getFactorRiesgo() {
		return this.factorRiesgo;
	}

	@Override
	public float getRiesgo() {
		return super.getRiesgo() * this.factorRiesgo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\n\tRiesgo: ");
		sb.append(this.getRiesgo());
		return sb.toString();
	}
}
