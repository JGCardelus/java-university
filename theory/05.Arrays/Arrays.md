# Arrays (constant size)

Para crear un array hay que usar *[]* para indicar que múltiples objetos están guardados.

```java
	Object object[] = new Object[size];
```

Los objetos que no estén definidos en la lista serán *null*.

## Foreach-loops

Te permite iterar por los elementos de una lista.
```java
	// Por cada objeto en lista
	for (Objeto objeto:lista) {
		objeto.metodo();
	}
```

## For-loops

La manera clásica. Solo usar cuando el índice sea clave.
```java
	for (int i = 0; i < list.length; i++) {
		Objeto objeto = lista[i];
	}
```