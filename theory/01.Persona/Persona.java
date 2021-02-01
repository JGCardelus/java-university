public class Persona {
	String nombre;
	int edad;

	void print() {
		System.out.println("Name: " + nombre);
		System.out.println("Edad: " + edad);
	}

	void setNombre(String nombre) {
		// Since nombre is a local and global variable
		// we need to add the "this."  to differenciate both variables
		this.nombre = nombre;
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
			System.out.println("¡Oye! Tu nombre es biologicamente imposible.");	
		}
	} 

	int getEdad() {
		return this.edad;
	}
}
