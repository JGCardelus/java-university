package examenes.inter.ui;

import examenes.inter.dominio.*;

public class App {
	public static void main(String[] args) {
		// Exámenes de prueba
		ExamenClasico examenClasico1 = new ExamenClasico("Teoria de la Comunicacion", 0.4F);
		ExamenClasico examenClasico2 = new ExamenClasico("Estadistica", 0.6F);
		ExamenHibrido examenHibrido1 = new ExamenHibrido("Campos", 1.0F, "Moodle");
		ExamenHibrido examenHibrido2 = new ExamenHibrido("Contabilidad", 0.2F, "Excel");
		ExamenOnline examenOnline1 = new ExamenOnline("Sistemas Digitales II", 0.9F, "Quartus", "LockdownBrowser");
		ExamenOnline examenOnline2 = new ExamenOnline("Programacion Orientada a Objetos", 0.4F, "VIM / VSCODE", "Teams");

		Examen[] examenes = {examenClasico1, examenClasico2, examenHibrido1, examenHibrido2, examenOnline1, examenOnline2};
		GestorExamenes gestorExamenes = new GestorExamenes(examenes);


		printTitle("Rango");
		printExamenes(gestorExamenes.getDificultadRange(30, 90));
		printTitle("Mayor que");
		printExamenes(gestorExamenes.getDificultadMayor(20));
		printTitle("Examen aleatorio");
		printExamen(gestorExamenes.getRandomExamen());
		printTitle("Dificultad media");
		System.out.println(gestorExamenes.getAverageDificultad());
	}

	public static void printTitle(String title) {
		System.out.println("\n\n******************************");
		System.out.println(title);
		System.out.println("\n\n******************************");
	}

	public static void printExamen(Examen examen) {
		// JIC
		if (examen != null) {
			System.out.println("-------------------------");
			System.out.println(examen.getAbreviatura()); // Tests abv
			System.out.println("-------------------------");
			System.out.println(examen.toString());
			System.out.println("\n");
		}
		
	}

	public static void printExamenes(Examen[] examenes) {
		for (Examen examen : examenes)
			printExamen(examen);
	}
}