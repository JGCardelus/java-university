# Packages

## Modificadores
Todos los atributos tienen que ser _private_ menos los _final_ (que como no se pueden modificar pueden ser _public_). Una clase hija no debería poder acceder a los atributos de la superclase. 


La clase, el constructor y setters/getters tienen que ser _public_.

Cuando se hace un override (en una clase hija) no se puede reducir la visibilidad de un método/atributo. Por ejemplo:

```java
	public class A {
		protected m();
	}

	public class B extends A {
		private m(); // Esto no se puede hacer, private reduce la visibilidad
	}

	public class B extends A {
		public m(); // Esto sí se puede hacer por que extiende la visibilidad
	}
```

