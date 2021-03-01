public class MenuOption {
	private int index;
	private String appName;

	MenuOption(int index, String appName) {
		this.setIndex(index);
		this.setAppName(appName);
	}

	public void setIndex(int index) {
		if (index >= 0) {
			this.index = index;
		}
	}

	public int getIndex() {
		return this.index;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return this.appName;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof MenuOption) {
			MenuOption challenge = (MenuOption) object;
			if (challenge.getIndex() == this.getIndex()) {
				return true;
			}
		}
		return false;
	}
}
