# This

Los datos básicos no son objetos. String no es un dato básico, es un objeto. En JAVA, todo lo que no tenga la primera letra mayúscula no es un objeto.

## this.

this. es una referencia a él mismo (estando en un objeto te llamas a ti mismo). Java, si no lo pones, lo pone por defecto, pero es una buena práctica ponerlo siempre. Hacerlo también para variables.

## Múltiples constructores - Sobrecarga de constructores

Puedes escribir múltiples constructores. En función de los parámetros que pases se invoca a un constructor o a otro.

```java

public class Persona {
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
		// DRY, para no hacer algo redundante
		this(nombre, edad); // Esto llama al otro constructor
	}
}


////
Persona("Jorge", 15) // Llama al primer constructor
Persona(15, "Jorge") // Llama al segundo constructor
```

Es importante notar que, como el constructor es una método especial e inherente a la clase, para invocarlo simplemente tenemos que escribir this(argumentos). 

La práctica de definir varios métodos con el mismo nombre pero diferentes argumentos se llama sobrecargar un método. Puedes pasar diferentes numero de argumentos. No se permite definir dos métodos iguales. 

## Múltiples métodos - Sobrecarga de métodos

Al igual que con los constructores también se pueden sobrecargar métodos.

## KISS
*Keep it simple stupid*

## Atributos comunes a un conjunto de objetos

Los atributos de clase son atributos que son comunes a la clase y no particulares a la instancia. La palabra clave para declararlos es *static* y las variables estáticas las declararemos en mayúsculas.