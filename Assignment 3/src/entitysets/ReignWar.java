package entitysets;

public class ReignWar {
	int reignID;
	String war;

	public ReignWar(int reignID, String war) {
		this.reignID = reignID;
		this.war = war;
	}

	public int getReignID() {
		return reignID;
	}

	public String getWar() {
		return war;
	}
	
	public void setReignID(int reignID) {
		this.reignID = reignID;
	}

	public void setWar(String war) {
		this.war = war;
	}
}
