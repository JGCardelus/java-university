package examenes.inter.dominio;

public class ExamenHibrido extends Examen {
	private static float FACTOR_CORRECCION = 1.1F;

	private String herramienta;

	public ExamenHibrido(String nombre, float dificultad, String herramienta)
	{
		super(nombre, dificultad);
		this.setHerramienta(herramienta);
	}

	public ExamenHibrido()
	{
		this("Sin Nombre", 0.5F, "Moodle");
	}

	public static void setFACTOR_CORRECCION(float factorCorreccion) {
		FACTOR_CORRECCION = factorCorreccion;
	}

	public static float getFACTOR_CORRECCION() {
		return FACTOR_CORRECCION;
	}

	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}

	public String getHerramienta() {
		return this.herramienta;
	}

	@Override
	public float getDificultad() {
		return super.getDificultad() * FACTOR_CORRECCION;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\n\tDificultad: ");
		sb.append(this.getDificultad());
		sb.append("\n\tHerramienta: ");
		sb.append(this.herramienta);
		return sb.toString();
	}
}