# Casting y herencia

## Clases abastractas

Son clases que no tienen correspondencia física. Nos ayudan a agrupar clases con características comunes. Como no tienen correspondencia física (abastractas) no permitimos instanciarlas. Para definirlas usamos el modificador _abstract_

```java
	public abstract class Object {
		// No se puede hacer new, pero puede (y suelen ser necesarios)
		// constructores
	}
```

## Métodos abstractos

En las clases abstractas o en las interfaces se pueden definir métodos abstractos pero no en las clases normales (pues pueden ser instanciadas e invocadas).

```java
	public abstract class Object {
		abstract m1(); // Hay que expresarlo explícitamente
	}

	interface A {
		m1();
	}
```

# Interface

Solo pueden definir métodos, no los implementa (no define su función).

```java
	interface I {
		m(); // Estos métodos (definidos pero no implementados) se llaman métodos abstractos
		m1();
	}
```

Los interfaces permiten herencias múltiples. El interface dice *qué* tienen que hacer las clases fijas pero no como hacerlo. La implementación de las funciones tienen que hacerlo las sublcases. Las subclases *están* obligados a implementarlos.

Se puede tener herencia múltiple de varias interfaces y una clase. Pero no pueden ser varias clases.

```java
	class HombreLobo extends A implements Hombre, Lobo {
		// extends es para clases
		// implements es para interfaces
	}
```

Los interfaces se suelen llamar nombre + able.