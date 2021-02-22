public class AreaProtegida extends ParqueNacional implements Visitable {
	private int subvencion;
	private String ong;

	AreaProtegida(String nombre, int km, int numeroEspecies, int subvencion, String ong) {
		super(nombre, km, numeroEspecies);
		this.setSubvencion(subvencion);
		this.setOng(ong);
	}

	public void setSubvencion(int subvencion) {
		if (subvencion > 0) {
			this.subvencion = subvencion;
		}
	}

	public int getSubvencion() {
		return this.subvencion;
	}

	public void setOng(String ong) {
		this.ong = ong;
	}

	public String getOng() {
		return this.ong;
	}

	@Override
	public String getInfo() {
		String superInfo = super.getInfo();
		return
			superInfo + 
			"\n\tSubvencion: " + this.getSubvencion() +
			"\n\tONG: " + this.getOng();
	}

	public String visitar(String guia) {
		return
			"-> Vistando área protegida " + this.getNombre() +
			" con el guía " + guia; 
	}
}
