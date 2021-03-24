import figuras.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.awt.*;
import javax.swing.JFrame;

public class Dibujo {
	private Map<String, LinkedList<Figura>> grupos = new HashMap<String, LinkedList<Figura>>();

	/* For now, drawings will have the same size as the canvas*/
	private int sizeX;
	private int sizeY;
	
	public final int MAX_SIZE_X = 1920;
	public final int MAX_SIZE_Y = 1080;
	public final int DEFAULT_SIZE = 600;

	public Dibujo(Map<String, LinkedList<Figura>> initGrupos) {
		this.setGrupos(initGrupos);
	}

	public Dibujo() {}

	public void setGrupos(Map<String, LinkedList<Figura>> grupos) {
		this.grupos = grupos;
	}

	public Map<String, LinkedList<Figura>> getGrupos() {
		return this.grupos;
	}

	public void pintar(String claveGrupo, Figura figura) {
		LinkedList<Figura> temp;
		if (this.grupos.containsKey(claveGrupo)) {
			temp = this.grupos.get(claveGrupo);
			
		} else {
			temp = new LinkedList<>();
		}

		temp.add(figura);
		this.grupos.put(claveGrupo, temp);
	}

	public void llenarGrupo(String claveGrupo) {
		this.setRellenoGrupo(claveGrupo, true);
	}

	public void vaciarGrupo(String claveGrupo) {
		this.setRellenoGrupo(claveGrupo, false);
	}

	public void setRellenoGrupo(String claveGrupo, boolean relleno) {
		Collection<Figura> grupo = this.grupos.get(claveGrupo);
		for (Figura figura : grupo)
			figura.setRelleno(relleno);
	}

	public void ocultarGrupo(String claveGrupo) {
		this.setMostrarGrupo(claveGrupo, false);
	}

	public void mostrarGrupo(String claveGrupo) {
		this.setMostrarGrupo(claveGrupo, true);
	}

	public void setMostrarGrupo(String claveGrupo, boolean mostrar) {
		Collection <Figura> grupo = this.grupos.get(claveGrupo);
		for (Figura figura : grupo)
			figura.setMostrar(mostrar);
	}

	public void setColorGrupo(String claveGrupo, Color color) {
		Collection <Figura> grupo = this.grupos.get(claveGrupo);
		for (Figura figura : grupo)
			figura.setColor(color);
	}
 }
