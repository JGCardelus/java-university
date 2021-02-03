# HelloWorld

The most basic block in java is the class. It must be named as the file name.

```java
public class HelloWorld {

}
```

A project file may contain multiple classes. The class that is executed first is the one that contains the method *main*.

```java
public class HelloWorld {
	public static void main(String args[]) {

	}
}
```
``public void`` Defines that the method (which wont return anything) is available to everyone. ``static`` means that the method/variable is global to all instances of the class. ``String args[]`` are a list of possible parameters entered in the console.

Let's dive in a bit more into ``static``. This keyword allows to create variables/methods that are instance agnostic. This means that the method/variable is shared (and it's memory) across all instances.

Once we know what everything is we can add some spice to our program. So let's make a program that prints the keywords entered by the user. So if the user types into the console

```shell
java HelloWorld hello there
```

The output should be
``` shell
hello
there
```
So here it is
```java
public class HelloWorld {
	public static void main(String args[]) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
```

## Methods
void -> No devuelve nada
constructor -> Devuelve la clase creada
_resto_ -> Estás obligado a devolver algo con ese tipo