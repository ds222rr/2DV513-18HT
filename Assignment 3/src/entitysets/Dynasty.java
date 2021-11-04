package entitysets;

public class Dynasty {
	String name;
	String ethnicity;

	public Dynasty(String name, String ethnicity) {
		this.name = name;
		this.ethnicity = ethnicity;
	}

	public String getName() {
		return name;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setEthnicity(String newEthnicity) {
		ethnicity = newEthnicity;
	}
}
