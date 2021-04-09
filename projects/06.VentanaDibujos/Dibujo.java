import java.util.Collection;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

import java.awt.Color;

// Project imports
import figuras.*;

public class Dibujo {

	private Map<String, LinkedList<Figura>> groups;

	public Dibujo() {
		this.clear();
	}

	public Map<String, LinkedList<Figura>> getGroups() {
		return this.groups;
	}

	public void getGroups(Map<String, LinkedList<Figura>> groups) {
		this.groups = groups;
	}

	public void paint(String group, Figura figura) {
		LinkedList<Figura> helper;
		if (!this.groups.containsKey(group)) {
			helper = new LinkedList<Figura>();
		} else {
			helper = this.groups.get(group);
		}
		helper.add(figura);
		this.groups.put(group, helper);
	}

	public void clear() {
		this.groups = new HashMap<String, LinkedList<Figura>>();
	}

	public void fillGroup(String group) {
		Collection<Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setFill(true);
	}

	public void unfillGroup(String group) {
		Collection <Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setFill(false);
	}

	public void hideGroup(String group) {
		Collection<Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setVisibility(false);
	}

	public void showGroup(String group) {
		Collection<Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setVisibility(true);
	}

	public void changeGroupVisibility(String group) {
		Collection<Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setVisibility(!figura.getVisibility());
	}

	public void changeGroupFill(String group) {
		Collection <Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setFill(!figura.getFill());
	}

	public void setGroupColor(String group, Color color) {
		Collection <Figura> figuras = this.groups.get(group);
		for (Figura figura : figuras)
			figura.setColor(color);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, LinkedList<Figura>> group : this.groups.entrySet()) {
			sb.append("\nGrupo: ").append(group.getKey());
			sb.append("\n");
			for (Figura figura : group.getValue()) {
				sb.append(figura.toString()).append("\n");
			}
		}
		return sb.toString();
	}
}