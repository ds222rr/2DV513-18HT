package entitysets;

public class WarCustom1 {
	String mainenemy;
	String result;
	int number;

	public WarCustom1(String mainenemy, String result, int number) {
		this.mainenemy = mainenemy;
		this.result = result;
		this.number = number;
	}

	public String getMainenemy() {
		return mainenemy;
	}
	
	public String getResult() {
		return result;
	}

	public int getNumber() {
		return number;
	}
	
	public void setMainenemy(String mainenemy) {
		this.mainenemy = mainenemy;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
