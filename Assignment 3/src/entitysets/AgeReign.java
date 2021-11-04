package entitysets;

public class AgeReign {
	String age;
	int reignID;

	public AgeReign(String age, int reignID) {
		this.age = age;
		this.reignID = reignID;
	}

	public String getAge() {
		return age;
	}

	public int getReignID() {
		return reignID;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

	public void setReignID(int reignID) {
		this.reignID = reignID;
	}
}
