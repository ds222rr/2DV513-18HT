package entitysets;

public class Age {
	String age;
	int start;
	int end;

	public Age(String age, int start, int end) {
		this.age = age;
		this.start = start;
		this.end = end;
	}

	public String getAge() {
		return age;
	}

	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
}
