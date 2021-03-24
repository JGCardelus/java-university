# Collections

Son objectos, que permiten crear instancias. 

## Tipos de colecciones

Son estrucuturas que heredan de _Collecion_ (que es una interface).

Todas las colecciones tienen un prefijo y un sufijo. El prefijo indica cómo se comporta internamente. El sufijo indica la estrucutura interna de la collection. 

### ArrayList

Es una clase. Estructura de datos muy similar a un array. Genera espacio automáticamente para que siempre haya celdas para meter elementos (crea un array de tamaño 2*size()). 

#### Métodos y funcionalidad
```java
	ArrayList lista = new ArrayList();
	lista.add(); // Permite añadir objetos (o añadir en un índice)

	lista.get(indice); // Devuelve el objeto guardado en ese índice

	lista.remove(indice); // Elimina el objeto en ese índice
	lista.remove(new Objeto()); // Elimina el objeto que .equals(Objeto), más costoso

	lista.contains(new Objeto()); // Devuelve un boolean indicando si contiene el elemento o no
	lista.indexOf(new Objeto()); // Devuelve la posición del objeto si lo encuentra, si no, -1.

```

### LinkedList

Los objetos están conectados internamente a través de punteros. Añadir objetos es más eficiente. 

### List y Set

Son interfaces.

Definen como se comportan los ...List y los ...Set. Las listas permiten trabajar con un índice y respetan el orden de inserción. Las listas admiten duplicados. Los set, no admiten duplicados y no tienen índice (no se conoce el orden de inserción). Set no amplía el interfaz de _Collection_.

### HashSet

El contenido se inserta en la posición que indique el objeto. La posición del objeto es el _hashCode_ del objeto. Sabe llegar muy rápido a los objetos.

### TreeSet

Se ordenan en un árbol. La manera de ser ordenados viene dado por el método _compareTo_ del interface _Comparable_. Ese método devuelve un valor entero. Solo se pueden guardar elementos que implementen el interface _Comparable_.

```java
	public int compareTo(Objetc object) {
		// Devuelve < 0, 0 o > 0	
	}
```

Se recomienda que _compareTo_ e _equals_ tengan el mismo método de igualdad.

### Resumen

- ArrayList: Acceso directo
- LinkedList: Inserciones y borrados
- HashSet: Sin duplicados
- TreeSet: Ordenación

# Iterator
```java
	___.hasNext(); // ¿Hay más elementos?
	___.next(); // Dame el siguiente elemento
```

# Maps

(interface) Permiten asociar dos objetos. Siempre hay un objeto clave (k) que se asocia a un objeto valor (v). 

## Métodos
```java
	map.put(k,v); // El valor k, se asocia con v
	map.get(k); // Devuelve el valor
```

## HashMaps

k es el hashCode del objeto. Acceso casi directo a la información (muy rápidos). Es muy imporante la manera en la que definimos el método _hashCode_. Si intentamos guardar varios elementos en la misma clave, se va a crear un lista (LinkedList) con los elementos que estamos intentando guardar.