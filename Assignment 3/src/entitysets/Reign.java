package entitysets;

public class Reign {
	int reignID;
	String title;
	int ruler;
	String number;
	int start;
	int end;
	String area;

	public Reign(int reignID, String title, int ruler, String number, int start, int end, String area) {
		this.reignID = reignID;
		this.title = title;
		this.ruler = ruler;
		this.number = number;
		this.start = start;
		this.end = end;
		this.area = area;
	}

	public int getReignID() {
		return reignID;
	}

	public String getTitle() {
		return title;
	}
	
	public int getRuler() {
		return ruler;
	}

	public String getNumber() {
		return number;
	}
	
	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String getArea() {
		return area;
	}
	
	public void setReignID(int reignID) {
		this.reignID = reignID;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setRuler(int ruler) {
		this.ruler = ruler;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
