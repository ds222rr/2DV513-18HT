package entitysets;

public class War {
	String war;
	int start;
	int end;
	String result;
	String mainenemy;

	public War(String war, int start, int end, String result, String mainenemy) {
		this.war = war;
		this.start = start;
		this.end = end;
		this.result = result;
		this.mainenemy = mainenemy;
	}

	public String getWar() {
		return war;
	}

	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}

	public String getResult() {
		return result;
	}
	
	public String getMainenemy() {
		return mainenemy;
	}
	
	public void setWar(String war) {
		this.war = war;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public void setMain_enemy(String mainenemy) {
		this.mainenemy = mainenemy;
	}
}
