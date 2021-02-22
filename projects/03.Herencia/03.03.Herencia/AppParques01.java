public class AppParques01 {
	public static void main(String args[]) {
		ReservaCaza bigFourSafari = new ReservaCaza("Safari de los 4 Grandes", 200, 4, 40000, "Rifle");
		ReservaCaza familyFriendlySafari = new ReservaCaza("Safari Familiar", 350, 90, 10, "Pistola de agua");

		AreaProtegida gamusinoArea = new AreaProtegida("Area del Gamusino", 250, 1, 10000, "Dreamworks");
		Acuatica atlantis = new Acuatica("Atlantis", 120, 314, 23421, "Aquaman ORG", 103422);
		Terrestre wakanda = new Terrestre("Wakanda", 240, 20, 1000000000, "Wakanda Forevah", "Seleniumnita");

		ParqueNacional parquesNacionalKenia[] = {bigFourSafari, familyFriendlySafari, gamusinoArea, atlantis, wakanda};
		for (ParqueNacional parqueNacional:parquesNacionalKenia) {
			System.out.println(parqueNacional.getInfo());
		}

		String nombres = "";
		for (ParqueNacional parqueNacional:parquesNacionalKenia) {
			nombres += parqueNacional.getNombre() + ", ";
		}
		System.out.println(nombres);
	}
}
