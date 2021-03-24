package examenes.inter.dominio;

public class ExamenClasico extends Examen {
	private static float FACTOR_CORRECCION = 1.0F;

	public ExamenClasico(String nombre, float dificultad)
	{
		super(nombre, dificultad);
	}

	public static void setFACTOR_CORRECCION(float factorCorreccion) {
		FACTOR_CORRECCION = factorCorreccion;
	}

	public static float getFACTOR_CORRECCION() {
		return FACTOR_CORRECCION;
	}

	public ExamenClasico()
	{
		this("Sin Nombre", 0.5F);
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
		return sb.toString();
	}
}