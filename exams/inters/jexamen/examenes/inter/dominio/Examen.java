package examenes.inter.dominio;

public abstract class Examen
{
	public final float DIFICULTAD_DEFECTO = 0.5F;

	private String nombre;
	private float dificultad; //del 0 al 1, expresa porcentaje de dificultad: 0.0 muy fácil, 1.0 muy difícil

	public Examen(String nombre, float dificultad)
	{
		this.setNombre(nombre);
		this.setDificultad(dificultad);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setDificultad(float dificultad) {
		if (dificultad >= 0.0F && dificultad <= 1.0F) {
			this.dificultad = dificultad;
		} else {
			this.dificultad = DIFICULTAD_DEFECTO;
		}
	}

	public float getDificultad() {
		return this.dificultad;
	}

	//NO se puede modificar la definición de este método
	private Object calcula()
	{
		int numero = 78;
		char temp = (char) numero;
		//Debe devolver temp 
		return Character.valueOf(temp); // Automatic upcasting
	}	

	/*
	Método a implementar para que devuelva al abreviatura de una asignatura, siempre 3 caracteres.
	Por ejemplo: de la asignatura programación orientada a objetos, deberá devolver: POO.
	De circuitos Electrónicos: CEL
	De Teoría de la Comunicación: TDL
	De Sistemas Digitales II: SDI
	De estadística: EST
	*/
	public String getAbreviatura()
	{
		// Diferenciar si tiene o no espacios
		String nombre = this.getNombre();
		StringBuilder abreviatura = new StringBuilder();
		if (nombre.contains(" ")) {
			// El nombre tiene más de una palabra
			// Vemos cuantas palabras tiene, dividimos por espacios
			String[] palabras = nombre.split(" ");

			// En función de cada caso aplicamos un método distinto
			if (palabras.length == 2) {
				// Cogemos la primera letra de la primera palabra
				abreviatura.append(palabras[0].substring(0,1).toUpperCase());
				// Cogemos las dos primeras letras de la segunda palabra
				abreviatura.append(palabras[1].substring(0,2).toUpperCase());
			} else {
				// Si tiene más palabras, cogemos la primera letra de las dos
				// primeras palabras y la letra de la última palabra
				abreviatura.append(palabras[0].substring(0,1).toUpperCase());
				abreviatura.append(palabras[1].substring(0,1).toUpperCase());
				abreviatura.append(palabras[palabras.length - 1].substring(0,1).toUpperCase());
			}
		} else {
			// El nombre solo es de un palabra
			// Coger 3 primeras letras y poner en mayúsculas
			abreviatura.append(nombre.substring(0, 3).toUpperCase());
		}

		return abreviatura.toString();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("\n");
		sb.append(this.nombre);
		return sb.toString();
	}
}