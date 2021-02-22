public class PersonajePremium extends Personaje {
	private String skins;

	public PersonajePremium(String skins) {
		this(100, 0, skins);
	}

	public PersonajePremium(int vida, String skins)
	{
		this(vida, 0, skins);
	}

	public PersonajePremium(int vida, int material, String skins)
	{
		this.setVida(vida);
		this.material = material;
		this.setSkins(skins);
	}

	public String getSkins() {
		return skins;
	}

	public void setSkins(String skins) {
		this.skins = skins;
	}

	@Override
	public String getInfo() {
		return ISLA + "-->" + vida + "-" + material + "-" + this.skins;
	}
}
