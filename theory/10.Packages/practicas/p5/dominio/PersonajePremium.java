package practicas.p5.dominio;

public class PersonajePremium extends Personaje
{
	private String skins;

	public PersonajePremium(String skins)
	{
		this.skins = skins;
	}

	public PersonajePremium(int vida, String skins)
	{
		super(vida);
		this.skins = skins;
	}

	public PersonajePremium(int vida, Material material, String skins)
	{
		super(vida, material);
		this.skins = skins;
	}

	public String getSkins()
	{
		return skins;
	}

	public void setSkins(String skins)
	{
		this.skins = skins;
	}	

	@Override
	public String toString()
	{
		return super.toString() + " Skins: " + skins;
	}	
}