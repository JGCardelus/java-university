package examenes.inter.dominio;

public class ExamenOnline extends Examen
{
	private static float FACTOR_CORRECCION = 1.2F;

	private String herramienta;
	private String plataforma;

	public ExamenOnline(String nombre, float dificultad, String herramienta, String plataforma)
	{
		super(nombre, dificultad);
		this.setHerramienta(herramienta);
		this.setPlataforma(plataforma);
	}

	public ExamenOnline()
	{
		this("Sin Nombre", 0.5F, "Moodle", "LockdownBrowser");
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

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return this.plataforma;
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
		sb.append("\n\tVigilancia: ");
		sb.append(this.plataforma);
		return sb.toString();
	}
}