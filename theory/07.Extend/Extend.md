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

## Override de funciones de la superclase

Si hay dos métodos que se llaman igual (uno en la superclase y otro en subclase), cuando se ejecute subclase1.método() se llamara al método de la subclase, esta práctica se llama polimorfismo. Para llamar a un método de la superclase (que se llama igual que uno de la subclase) usamos el prefijo "super.".

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