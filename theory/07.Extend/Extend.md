# Extend

Cuando extiendes PersonajePremium, PersonajePremium tiene todos los métodos de Personaje.

Personaje -> Clase Padre o Superclase
PersonajePremium -> Clase Hijo o Subclase

```java
	public class PersonajePremium extends Personaje {
	
	}
```

Cuando creamos un constructor personalizado el constructor por defecto (si no lo definimos) no se crea.

Los métodos y atributos de Personaje se heredan a PresonajePremium.

Cuando se instancia una clase extendida, automáticamente se llama al constructor (por defecto) de la superclase (recursivamente). 

## ¿Cómo llamamos al constructor de la superclase?

Por defecto llama al constructor vacío de la superclase. Para llamar a constructores de la superclase utilizamos la palabra clave "super()" (con los parámetros que sean necesarios).

```java
public class PersonajePremium extends Personaje {
	private String skins;

	public PersonajePremium(String skins) {
		this(100, 0, skins); // DRY
	}

	public PersonajePremium(int vida, int material, String skins) {
		super(vida, material); // Llama al constructor de la superclase	
		this.setSkins(skins); // Propia de la subclase
	}
}
```

Se recomienda coger todos los constructores de la superclase y extenderlos con los atributos que queramos de la subclase.

## super.método()

Para llamar a un método de la superclase (desde la subclase que se llama igual) usamos el prefijo "super.".

```java
	public class PersonajePremium extends Personaje {
		public void getInfo() {
			String coreInfo = super.getInfo(); // Llama al método getInfo de la superclase
			return coreInfo + atributos;
		}
	}
```

Resumen:
this. -> Coge un atributo/función de la instancia actual
super. -> Coge un atributo/función de la superclase de la instancia actual

## @Override (anotaciones)

Si hay dos métodos que se llaman igual (uno en la superclase y otro en subclase), cuando se ejecute subclase1.método() se llamara al método de la superclase.

Para poder llamar a un elemento de la subclase que se llama igual (y tiene los mismos parámetros) que uno de la superclase usamos la anotación @Override. Esto "redefine" el método.

```java
	public class Personaje {
		public String getInfo() {
			return ISLA + "-->" + vida + "-" + material;
		}
	}

	public class PersonajePremium extends Personaje {
		@Override
		public String getInfo() {
			return ISLA + "-->" + vida + "-" + material + "-" + this.skins;
		}
	}
```
## Upcasting, Downcasting

Una subclase es a la vez la subclase y la/las superclases. Por ejemplo, PersonajePremium es PersonajePremium pero también es un Personaje. Por eso a un objeto Personaje le podemos asignar un PersonajePremium (esto se llama upcasting). Lo único es que es objeto Personaje (al que le ha sido asignado un PersonajePremium) solo puede acceder a los métodos y atributos de Personaje. Los métodos y atributos de una clase se llaman interfaz.

Si queremos que extender la funcionalidad de un método cuando hacemos upcasting, tenemos que hacer un override del método en la subclase. De esta manera cuando hagamos la asignación, sobreescribimos el método de la superclase con el de la subclase. En resumen,

```java
	PersonajePremium pp1;
	Persona p1;

	pp1 = new PersonajePremium(10, 10, "Plátano");
	p1 = pp1; // Upcasting, p1 solo tiene acceso a la interfaz de Persona y no a la extendida
	p1.getInfo(); // Como está sobreescrita (override), tiene la funcionalidad declarada en PersonajePremium
	p1.getSkins(); // Como este método no está en la interfaz de Personaje, nos dá error
	// Si queremos recuperar la funcionalidad de pp1
	pp1 = p1; // Downcasting
```

## instanceof

To check if class of A == class of B
```java
	if (objeto instanceof Objeto) {
		System.out.println("Yes");
	}
```

