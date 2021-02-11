public class App
{
	static Personaje lista[] = new Personaje[4];

	public static void main(String args[]) 
	{
		Personaje.setISLA("Mi Isla");

		Personaje personaje1 = new Personaje();
		lista[0] = personaje1;
		lista[1] = new Personaje(90);

		App.mostrarPersonaje(lista[1]);

		lista[2] = new Personaje(100, 100);
		lista[3] = new Personaje(100, 30);
		//MAL: if(lista[0].getVidad()<=0)
		//ERROR: lista[0].vida = -66;

		App.mostrarPersonajes();
		App.ordenarPersonajes();
		//Si no se quisiese definir como atributo de clase, se puede pasar como argumento
		App.filtrarPersonajes(lista);
	}

	public static void ordenarPersonajes()
	{

	}

	public static void filtrarPersonajes(Personaje lista[])
	{
		
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