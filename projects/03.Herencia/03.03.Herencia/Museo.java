public class Museo implements Visitable{
	private String nombre;
	private String direccion;
	private int precio;

	Museo(String nombre, String direccion, int precio) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setPrecio(precio);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setPrecio(int precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
	}

	public int getPrecio() {
		return this.precio;
	}

	public String visitar(String guia) {
		return
			"-> Vistando museo " + this.getNombre() +
			" con el guía " + guia + " a un precio de " +
			this.getPrecio() + "."; 
	}
}
