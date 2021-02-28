public class KeyboardInterface {
	private List<String> prompts;

	KeyboardInterface(String prompts[]) {
		this.setPrompts(prompts);
	}

	public void setPrompts(String prompts[]) {
		this.prompts.push(prompts);
	}

	public String[] getPrompts() {
		return (String[]) this.prompts.all();
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		for (String prompt:this.getPrompts()) {
			output.append("\n");
			output.append(prompt);
		}
		return output.toString();
	}

	public String ask() {
		System.out.println(this.toString());
		System.out.println("\n\n\t>> ");

		return Leer.porTeclado();
	}
}
