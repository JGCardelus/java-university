package examenes.inter.dominio;

public class GestorExamenes {
	private Examen[] examenes;

	public GestorExamenes(Examen[] examenes) {
		this.setExamenes(examenes);
	}

	public void setExamenes(Examen[] examenes) {
		this.examenes = examenes;
	}

	public Examen[] getExamenes() {
		return this.examenes;
	}

	public Examen[] deleteNulls(Examen[] examenes, int size) {
		// Quito los espacios en blanco
		Examen[] examenesAjustados = new Examen[size];
		for (int i = 0; i < size; i++) 
			examenesAjustados[i] = examenes[i];

		return examenesAjustados;
	}

	// Si supiésemos dificultad máximo podríamos usar getDifucultadRange(start, max_dificultad)
	// para obtener el resultado
	public Examen[] getDificultadMayor(int start) {
		// Como máximo va a haber this.examenes.length exámenes en ese rango
		Examen[] examenesEnRango = new Examen[this.examenes.length];
		int contadorExamenesEnRango = 0;

		for (Examen examen : this.examenes) {
			int dificultad = (int) (examen.getDificultad() * 100);
			if (dificultad > start) {
				// Está dentro del rango
				for (int i = 0; i < examenesEnRango.length; i++) {
					if (examenesEnRango[i] == null) {
						examenesEnRango[i] = examen;
						contadorExamenesEnRango++;
						i = examenesEnRango.length; // Break loop
					}
				}
			}
		}

		return this.deleteNulls(examenesEnRango, contadorExamenesEnRango);
	}

	public Examen[] getDificultadRange(int start, int end) {
		// Como máximo va a haber this.examenes.length exámenes en ese rango
		Examen[] examenesEnRango = new Examen[this.examenes.length];
		int contadorExamenesEnRango = 0;
		for (Examen examen : this.examenes) {
			int dificultad = (int) (examen.getDificultad() * 100);
			if (dificultad > start && dificultad <= end) {
				// Está dentro del rango
				for (int i = 0; i < examenesEnRango.length; i++) {
					if (examenesEnRango[i] == null) {
						examenesEnRango[i] = examen;
						contadorExamenesEnRango++;
						i = examenesEnRango.length; // Break loop
					}
				}
			}
		}

		return this.deleteNulls(examenesEnRango, contadorExamenesEnRango);
	}

	public Examen getRandomExamen() {
		// Asumo que voy a tener pérdidas en la conversión, pero no puede
		// acceder a la lista con un double
		int indexExamen = (int) (Math.random() * (this.examenes.length - 1));
		return this.examenes[indexExamen];
	}

	public float getAverageDificultad() {
		float dificultadSum = 0.0F;
		for (Examen examen : this.examenes)
			dificultadSum += examen.getDificultad();

		float average = dificultadSum / ((float) this.examenes.length);
		return average;
	}
}