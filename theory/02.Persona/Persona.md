# Persona (02)

## Operaciones aritméticas acortadas

```java
numero = numero + 1; -> numero++;
numero = numero - 1; -> numero--;
numero = numero + 2; -> numero += 2;
numero = numero - 2; -> numoer -= 2;
```

## Declaración de variables
No se puede declar una varaiable dos veces, pero si se puede reasignar su valor.

Para cocatenar se usa el operador más (strings). El operador += también es válido.

Evitar declarar variables intermedias.


## Constructor
Método especial de la clase, por que existe por defecto. Se llama igual que la clase. El constructor crea objetos y puede _inicializarlos_.

Intentar no usar el constructor por defecto. 

```java
public class Persona {
	String nombre;
	int edad;

	// Esto es el constructor
	Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
}
```

El constructor siempre devuelve el objecto, entonces, para evitar redundancia (el constructor se llama igual que la clase) solo ponemos el nombre una vez.

```java
public class Persona {
	String nombre;
	int edad;

	// Si lo hiciésemos como el resto de métodos
	// tipo nombre
	Persona Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	// Como siempre es redundante, lo omitimos
	// Esto es el constructor
	Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
}
```

Es una buena práctica llamar al setter desde el constructor.

## DRY
*Don't repeat yourself*