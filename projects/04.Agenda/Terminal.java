public class Terminal {
	public static void title(String title) {
		System.out.println("\n---------------------------------------------");
		System.out.println("                  " + title + " ");
		System.out.println("---------------------------------------------\n\n");
	}

	public static void separator() {
		System.out.println("---------------------------------------------");
	}

	public static void warn(String warning) {
		StringBuilder prettifiedWarning = new StringBuilder("\n!\tCuidado: ");
		prettifiedWarning.append(warning);
		System.out.println(prettifiedWarning.toString());
	}

	public static void notify(String notification) {
		StringBuilder prettifiedNotification = new StringBuilder("\n>\t");
		prettifiedNotification.append(notification);
		System.out.println(prettifiedNotification.toString());
	}

	public static String ask(String question) {
		System.out.print(question);
		System.out.print("  >>  ");
		return Leer.porTeclado();
	}

	public static void bye() {
		System.out.print("\n\nBye!\n");
	}

	public static int askApp(Menu menu) {
		System.out.print(menu.toString());
		System.out.print("\n*\n*\n*\t >> ");

		String response = Leer.porTeclado();
		int option = menu.getMenuOption(0).getIndex();
		try {
			option = Integer.parseInt(response);
		} catch (Exception e) {
			// If there is an error, ask again (with a little bit of recursion :) )
			option = askApp(menu);
		}

		return option;
	}
}
