package personas;

public class Joven extends Persona {
	public final float RIESGO = (float) 0.02;

	public Joven(boolean contagio, Persona[] contactos, int problemasRespiratorios, int problemasCardiacos) {
		super(contagio, contactos, problemasRespiratorios, problemasCardiacos);
	}

	@Override
	public float getRiesgo() {
		return RIESGO;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\n\tRiesgo: ");
		sb.append(this.getRiesgo());
		return sb.toString();
	}
}
