# Access Modifiers

## One-liners

Si tenemos un for, if, while de solo una línea se puede no poner las llaves.

```java
	if (true)
		object.doSomething();
```

La tabulación no es necesaria. Lo podemos poner en la misma línea. Se recomienda poner la tabulación y la sentencia en la siguiente línea. 

### Nested one-liners

```java
	for (int i; i < length; i++)
		if (true)
			object.doSomething();
```



## Hide attributes and methods from user

To hide a attribute and method use *private*. Por defecto los atributos son *public*. Para mejorar nuestro código poner todos los atributos *private*.  Por otra parte, todos los métodos que queramos que sean públicos (aunque por defecto sean públicos) poner el modificador *public*.

```java
	int a;
	// Allows
	object.a = 5;
	
	private int a;
	// Does not allow
	object.a = 5; // Throws errors
```

## Boolean operators

To reduce code you can use boolean operators.
```java
	return condition;
```

## One return per method

Avoid multiple return, for example to exit code.
```java
	void method(boolean args) {
		if (args == false)
			return false; // Avoid this

		// Others sentences
		return true;
	}
```

