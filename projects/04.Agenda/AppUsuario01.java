public class AppUsuario01 {
	public static void main(String args[]) {
		Usuario u1 = new Usuario("jgcardelus", "12345678X");
		Usuario u2 = new Usuario("jgcardelus", "12345678X", "Jorge", "González Cardelús", 19);

		List<Usuario> lista = new List<>();
		lista.push(u1);
		lista.push(u2, 0);

		System.out.println(lista.get(1).toString());
	}
}
