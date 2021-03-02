public class Terminal {
	public static String preguntar(String pregunta) {
		System.out.print(pregunta + ": ");
		return Leer.porTeclado();
	}

	public static void avisar(String aviso) {
		System.out.println("\n!\t" + aviso);
	}

	public static void notificar(String notificacion) {
		System.out.println("\n>\t" + notificacion);
	}


	public static int preguntarAplicacion() {
		StringBuilder menu = new StringBuilder();
		menu.append("\n*********************************");
		menu.append("\n*           MENU                 ");
		menu.append("\n*********************************");
		menu.append("\n*\t1. Crear persona");
		menu.append("\n*\t2. Buscar persona");
		menu.append("\n*\t3. Eliminar persona");
		menu.append("\n*\t4. Modificar persona");
		menu.append("\n*\t5. Mostrar todos");
		menu.append("\n*********************************");
		menu.append("\n*\t9. Salir");
		menu.append("\n*\n*\n*\t>> ");

		System.out.print(menu.toString());

		int option = Integer.parseInt(Leer.porTeclado());
		return option;
	}
}
