public class App
{
	static Personaje lista[] = new Personaje[4];

	public static void main(String args[]) 
	{
		Personaje.setISLA("Mi Isla");

		Personaje personajes[] = new Personaje[10];
		personajes[0] = new Personaje(50,50);
		personajes[1] = new PersonajePremium(50, 50, "Platanito");
		personajes[2] = new Personaje(30,80);
		personajes[3] = new PersonajePremium(80,80, "Platanito 2");

		for (Personaje personaje:personajes)
			if (personaje!=null)
				System.out.println(personaje.getInfo());

		for (Personaje personaje:personajes) {
			if (personaje instanceof PersonajePremium&& p != null) {
				PersonajePreium downcastedPersonajePremium = (PersonajePremium) personaje;
				System.out.println(downcastedPersonajePremium.getSkins());
			}
			System.out.println(personaje.getInfo());
		}
	}

	public static void mostrarPersonajes()
	{
		for(Personaje p:lista)
			if(p!=null)
				System.out.println(p.getInfo());
	}

	public static void mostrarPersonaje(Personaje personaje)
	{
		System.out.println(personaje.getInfo());
	}	
}