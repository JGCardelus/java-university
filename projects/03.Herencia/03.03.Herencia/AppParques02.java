public class AppParques02 {
	public static void main(String args[]) {
		AreaProtegida gamusinoArea = new AreaProtegida("Area del Gamusino", 250, 1, 10000, "Dreamworks");
		Acuatica atlantis = new Acuatica("Atlantis", 120, 314, 23421, "Aquaman ORG", 103422);
		Terrestre wakanda = new Terrestre("Wakanda", 240, 20, 1000000000, "Wakanda Forevah", "Seleniumnita");

		Museo helloWorldMuseum = new Museo("printf('HelloWorldMuseum');", "0xffffff", 0);

		System.out.println(gamusinoArea.visitar("Carl Fredricksen"));
		System.out.println(atlantis.visitar("Aquaman"));
		System.out.println(wakanda.visitar("Black Panther"));
		System.out.println(helloWorldMuseum.visitar("GCC"));

	}
}
