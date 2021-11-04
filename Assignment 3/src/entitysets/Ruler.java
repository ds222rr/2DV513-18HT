package entitysets;

public class Ruler {
	int rulerID;
	String firstname;
	String secondname;
	String surname;
	String epithet;
	String nickname;
	String gender;
	String dynasty;

	public Ruler(int rulerID, String firstname, String secondname, String surname, String epithet, String nickname, String gender, String dynasty) {
		this.rulerID = rulerID;
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
		this.epithet = epithet;
		this.nickname = nickname;
		this.gender = gender;
		this.dynasty = dynasty;
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

	public String getGender() {
		return gender;
	}
	
	public String getDynasty() {
		return dynasty;
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

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
}
