public class Acuatica extends AreaProtegida {
	private int numeroLagos;

	Acuatica(String nombre, int km, int numeroEspecies, int subvencion, String ong, int numeroLagos) {
		super(nombre, km, numeroEspecies, subvencion, ong);
		this.setNumeroLagos(numeroLagos);

	}

	public void setNumeroLagos(int numeroLagos) {
		if (numeroLagos >= 0) {
			this.numeroLagos = numeroLagos;
		}
	}

	public int getNumeroLagos() {
		return this.numeroLagos;
	}

	@Override
	public String getInfo() {
		String superInfo = super.getInfo();
		return
			superInfo + 
			"\n\tNumero de lagos: " + this.getNumeroLagos();
	}
}
