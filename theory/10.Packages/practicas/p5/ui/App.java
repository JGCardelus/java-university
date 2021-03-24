package practicas.p5.ui;

import practicas.p5.dominio.Personaje;
import practicas.p5.dominio.PersonajePremium;
import practicas.p5.dominio.PersonajePromocion;
import practicas.p5.dominio.Material;

public class App
{
	static Personaje lista[] = new Personaje[4];

	public static void main(String args[]) 
	{
		practicas.p5.dominio.Material m = new practicas.p5.dominio.Material("a", 1);

		Personaje.setISLA("Mi Isla");

		Personaje personajes[] = new Personaje[10];

		personajes[0] = new Personaje(50, new Material("Madera", 50));
		personajes[1] = new PersonajePremium(10, new Material("Madera", 10), "Platanito");
		personajes[2] = new PersonajePromocion(10, new Material("Madera", 10), "20-jun-2021", 100);
 
		for(Personaje p:personajes)
			if(p != null)
				System.out.println(p);

		for(Personaje p:personajes)
			if(p instanceof PersonajePremium)
			{
				PersonajePremium personajePremium2 = (PersonajePremium) p; //DOWNCASTING
				System.out.println("La skin del objeto del tipo Premium es " + personajePremium2.getSkins());
			}	
	}
}