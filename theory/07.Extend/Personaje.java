public class Personaje
{
	//Atributo de CLASE
	public final static int VIDA_MINIMA = 0;
	public final static int VIDA_MAXIMA = 100;

	private static String ISLA;

	//Atributo de Instancia
	private int vida;
	private int material;

	public Personaje()
	{
		this(100, 0);
	}

	public Personaje(int vida)
	{
		this.setVida(vida);
	}

	public Personaje(int vida, int material)
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

	public int getMaterial()
	{
		return material;
	}

	public void setVida(int vida)
	{
		if(vida > VIDA_MINIMA && vida <= VIDA_MAXIMA)
			this.vida = vida;
	}

	public void setMaterial(int material)
	{
		this.material = material;
	}	

	public void herir(int herida)
	{
		vida -= herida;
	}

	public void picar(int material)
	{
		this.setMaterial(material);
	}

	public boolean isVivo()
	{
		//return (vida > 0);
		if(vida > VIDA_MINIMA)
			return true;
		else
			return false;
	}

	public String getInfo()
	{
		return ISLA + "-->" + vida + "-" + material;
	}
}