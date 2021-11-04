package entitysets;

public class AgeWar {
	String age;
	String war;

	public AgeWar(String age, String war) {
		this.age = age;
		this.war = war;
	}

	public String getAge() {
		return age;
	}

	public String getWar() {
		return war;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

	public void setReignID(String war) {
		this.war = war;
	}
}
