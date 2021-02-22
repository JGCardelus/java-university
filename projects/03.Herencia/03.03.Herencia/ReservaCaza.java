public class ReservaCaza extends ParqueNacional {
	private int costeLicencia;
	private String tipoArma;

	ReservaCaza(String nombre, int km, int numeroEspecies, int costeLicencia, String tipoArma) {
		super(nombre, km, numeroEspecies);
		this.setCosteLicencia(costeLicencia);
		this.setTipoArma(tipoArma);
	}

	public void setCosteLicencia(int costeLicencia) {
		if (costeLicencia > 0) {
			this.costeLicencia = costeLicencia;
		}
	}

	public int getCosteLicencia() {
		return this.costeLicencia;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	public String getTipoArma() {
		return this.tipoArma;
	}

	@Override
	public String getInfo() {
		String superInfo = super.getInfo();
		return
			superInfo + 
			"\n\tCoste de Licencia (Chelines): " + this.getCosteLicencia() +
			"\n\tTipo Arma: " + this.getTipoArma();
	}
}
