public class Persona {
	// Planeta es común para todas las personas
	static String PLANETA;
	// Atributos
	String nombre;
	int edad;

	// Constructor
	Persona(String nombre, int edad) {
		// DRY
		this.setNombre(nombre); 
		this.setEdad(edad);
	}

	// Constructor
	Persona(int edad, String nombre) {
		// DRY
		this.setNombre(nombre); 
		this.setEdad(edad);
	}

	// Métodos
	void print() {
		if (PLANETA != null) {
			System.out.println("Planeta: " + PLANETA);
		}
		System.out.println("Name: " + nombre);
		System.out.println("Edad: " + edad);
	}

	static void setPLANETA(String planeta)
	{
		PLANETA = planeta;
	}

	static String getPLANETA() {
		return PLANETA;
	}

	void setNombre(String nombre) {
		// Since nombre is a local and global variable
		// we need to add the "this."  to differenciate both variables
		this.nombre = nombre.toUpperCase();
	}

	String getNombre() {
		// Here "this." is not necessary since there is only one
		// variable with that name in this scope
		return nombre;
	}

	void setEdad(int edad) {
		if (edad >= 0 && edad <= 120) {
			this.edad = edad;
		} else {
			System.out.println("¡Oye! Tu edad es biologicamente imposible.");	
		}
	} 

	int getEdad() {
		return this.edad;
	}
}
