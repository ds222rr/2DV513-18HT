package entitysets;

public class DynastyCustom1 {
	String dynasty;
	int number;

	public DynastyCustom1(String dynasty, int number) {
		this.dynasty = dynasty;
		this.number = number;
	}

	public String getDynasty() {
		return dynasty;
	}

	public int getNumber() {
		return number;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
