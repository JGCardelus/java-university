package practicas.p5.dominio;

public class Material
{
	private String tipo;
	private int cantidad;

	public Material(String tipo, int cantidad)
	{
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public void picar(int material)
	{
		cantidad -= material;
	}

	@Override
	public String toString()
	{
		return tipo + "(" + cantidad + ")";
	}
}