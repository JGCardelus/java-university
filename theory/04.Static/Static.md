# Static

Permite guardar atributos y métodos comunes a una clase. Es una información que aplica a *todos* los objetos. Si en un momento dado un atributo de clase tiene que ser cambiado para una instancia, hemos definido un mal atributo de clase. Los vamos a declarar en mayúscula para que sea más fácil leer
el código.

## Acceder a atributos de instancia

Los atributos de clase pueden ser accedidos por instancias. Los atributos de clase, por otra parte, no pueden acceder a atributos de instancias (por razones obvias).

Para acceder a una atributo/método de clase no es necesario el _this._ porque no estamos modificando algo de la instancia, sino de la clase.

```java
	static String PLANETA;

	...

	static void setPLANETA(String planeta)
	{
		PLANETA = planeta;
	}
```

Para acceder a un método/atributo de clase.

```java
	// No es necesario instanciar la clase
	// Usar este formato para operar con atributos de clase
	Persona.getPLANETA();

	// Pero puedes modificarlo desde una instancia
	// Esto no se recomienda
	Persona p1 = new Persona();
	p1.setPLANETA("La Tierra");
	p1.getPLANETA();
```

Para poder operar con atributos de clase necesitamos que los métodos tengan el prefijo _static_ para indicar que están operando a nivel de clase.

## Constantes

Para declarar constantes usar el método _static_ (esto si la constante es común a todas las instancias) con el prefijo _final_ (esto lo hace una constante).

## Public

El prefijo _public_ permite que todo el mundo pueda accerder a un atributo/variable sin necesidad de un método intermedio (quedan expuestos). Se recomienda usar este prefijo para todos los métodos _final_, pues no tenemos miedo de que alguien modifique estos values (no pueden).
