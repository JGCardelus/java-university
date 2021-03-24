package practicas.p5.dominio;

public class Personaje
{
	//Atributo de CLASE
	public static final int VIDA_MINIMA = 0;
	public static final int VIDA_MAXIMA = 100;

	static String ISLA;

	//Atributo de Instancia
	private int vida;
	private Material material;
	protected int prueba;

	public Personaje()
	{
		this(100, new Material("Madera", 100));
	}

	public Personaje(int vida)
	{
		this.setVida(vida);
	}

	public Personaje(int vida, Material material)
	{
		this.setVida(vida);
		this.material = material;
	}

	public static void setISLA(String isla)
	{
		ISLA = isla;
		//ERROR: vida = 99;
	}

	public static String getISLA()
	{
		return ISLA;
	}

	public int getVida()
	{
		return vida;
	}

	public Material getMaterial()
	{
		return material;
	}

	public void setVida(int vida)
	{
		if(vida > VIDA_MINIMA && vida <= VIDA_MAXIMA)
			this.vida = vida;
	}

	public void setMaterial(Material material)
	{
		this.material = material;
	}	

	public void herir(int herida)
	{
		vida -= herida;
	}

	public void picar(int cantidadMaterial)
	{
		material.picar(cantidadMaterial);
	}

	public boolean isVivo()
	{
		if(vida > VIDA_MINIMA)
			return true;
		else
			return false;
	}

	@Override
	public String toString()
	{
		return "Isla: " + ISLA + " Vida: " + vida + " - " + material + " - ";
	}
}