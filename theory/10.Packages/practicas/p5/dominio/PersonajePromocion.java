package practicas.p5.dominio;

public class PersonajePromocion extends Personaje
{
	private String fechaCaducidad;
	private int pavosExtras;

	public PersonajePromocion(String fechaCaducidad, int pavosExtras)
	{
		this.fechaCaducidad = fechaCaducidad;
		this.pavosExtras = pavosExtras;
	}

	public PersonajePromocion(int vida, String fechaCaducidad, int pavosExtras)
	{
		super(vida);
		this.fechaCaducidad = fechaCaducidad;
		this.pavosExtras = pavosExtras;		
	}

	public PersonajePromocion(int vida, Material material, String fechaCaducidad, int pavosExtras)
	{
		super(vida, material);	
		this.fechaCaducidad = fechaCaducidad;
		this.pavosExtras = pavosExtras;		
	}

	public String getFechaCaducidad()
	{
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad)
	{
		this.fechaCaducidad = fechaCaducidad;
	}	

	@Override
	public String toString()
	{
		return super.toString() + " Fin: " + fechaCaducidad + " & " + pavosExtras + " euros";
	}	
}