public class Terrestre extends AreaProtegida {
	private String tipoTerreno;

	Terrestre(String nombre, int km, int numeroEspecies, int subvencion, String ong, String tipoTerreno) {
		super(nombre, km, numeroEspecies, subvencion, ong);
		this.setTipoTerreno(tipoTerreno);
	}

	public void setTipoTerreno(String tipoTerreno) {
		this.tipoTerreno = tipoTerreno;
	}

	public String getTipoTerreno() {
		return this.tipoTerreno;
	}

	@Override
	public String getInfo() {
		String superInfo = super.getInfo();
		return
			superInfo + 
			"\n\tTipo de terreno: " + this.getTipoTerreno();
	}
}
