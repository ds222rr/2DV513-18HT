package entitysets;

public class Custom {
	int rulerID;
	String firstname;
	String secondname;
	String surname;
	String epithet;
	String nickname;
	int time;

	public Custom(int rulerID, String firstname, String secondname, String surname, String epithet, String nickname, int time) {
		this.rulerID = rulerID;
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
		this.epithet = epithet;
		this.nickname = nickname;
		this.time = time;
	}

	public int getRulerID() {
		return rulerID;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public String getSecondname() {
		return secondname;
	}

	public String getSurname() {
		return surname;
	}
	
	public String getEpithet() {
		return epithet;
	}

	public String getNickname() {
		return nickname;
	}

	public int getTime() {
		return time;
	}
	
	public void setRulerID(int rulerID) {
		this.rulerID = rulerID;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setEpithet(String epithet) {
		this.epithet = epithet;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void settime(int time) {
		this.time = time;
	}
	
}
