import personas.*;

public class AppVirus01 {
	public static void main(String args[]) {
		Joven joven1 = new Joven(false, new Persona[0], 0,0);
		Adulto adulto1 = new Adulto(false, new Persona[0], 1, 2, (float) 0.5);
		Adulto adulto2 = new Adulto(true, new Persona[]{joven1, adulto1}, 1, 2, (float) 0.5);
		Anciano anciano1 = new Anciano(true, new Persona[]{joven1, adulto2}, 2, 4, (float) 0.75);
	
		Hospital hospital1 = new Hospital("1", 1);
		Hospital hospital2 = new Hospital("2", 1);

		Persona[] contagiados = {adulto2, anciano1};
		Persona[] personas = {joven1, adulto1, adulto2, anciano1};
		Hospital[] hospitales = {hospital1, hospital2};

		OSI osi = new OSI(hospitales, contagiados, personas);
		osi.ingresar(adulto2);
		osi.ingresar(anciano1);

		showPacientes(osi);
		System.out.println(osi.getContagiadosVsIngresados());
		System.out.println(osi.findPaciente(adulto2).toString());
		System.out.println(osi.getAverageRiesgo());
		showIndice(osi);
	}

	public static void showIndice(OSI osi) {
		Persona[] personas = osi.getPersonas();
		for (Persona persona : personas) {
			System.out.println(persona.getIndiceContagio());
		}
	}

	public static void showPacientes(OSI osi) {
		Hospital[] hospitales = osi.getHospitales();
		for (Hospital hospital : hospitales) {
			System.out.println(hospital.toString());
			
			Persona[] pacientes = hospital.getPacientes();
			for (Persona paciente : pacientes) {
				System.out.println(paciente.toString());
			}
		}
	}
}
