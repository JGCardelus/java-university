public class Menu {
	private List<MenuOption> menuOptions;

	Menu(MenuOption menuOption) {
		// Convert to list and initialize
		this(new MenuOption[]{menuOption});
	}

	Menu(MenuOption menuOptions[]) {
		this.menuOptions = new List<>();
		this.addMenuOptions(menuOptions);
	}

	Menu() {
		// Initialize empty menu
		this(new MenuOption[]{});		
	}

	public MenuOption getMenuOption(int index) {
		return this.menuOptions.get(index);
	}

	public void addMenuOptions(MenuOption menuOptions[]) {
		for (MenuOption menuOption:menuOptions) {
			this.addMenuOption(menuOption);
		}
	}

	public void addMenuOption(MenuOption menuOption) {
		if (!this.menuOptions.includes(menuOption)) {
			this.menuOptions.push(menuOption);
		} else {
			// Finds index for menuOption
			while (this.menuOptions.includes(menuOption)) {
				int newIndex = menuOption.getIndex() + 1;
				menuOption.setIndex(newIndex);
			}
			this.menuOptions.push(menuOption);
		}
	}

	@Override
	public String toString() {
		StringBuilder menu = new StringBuilder();
		menu.append("\n\n\n*******************************************");
		menu.append("\n*                   MENU                  *");
		menu.append("\n*******************************************");
		menu.append("\n*\n*");

		for (Object possibleOption:this.menuOptions.all()) {
			if (possibleOption instanceof MenuOption) { // Which they all are
				MenuOption menuOption = (MenuOption) possibleOption;
				menu.append("\n*\t");
				menu.append(menuOption.getIndex());
				menu.append(". ");
				menu.append(menuOption.getAppName());
			}
		}
		return menu.toString();
	}
}
