package crackingCodingInterviews.mineSweeper;

public class Cell {
	boolean isHidden;
	
	public int x;
	public int y;
	public int value;
	private String strValue;
	
	// value: -1 (bomb), 0 (empty), 0 > (just a number)
	public Cell(int x, int y, int value) {
		this.x=x;
		this.y=y;
		this.isHidden=true;
		this.value = value;
		this.strValue = getStr(value);
	}
	
	private String getStr(int value) {
		if(value == -1) return "B";
		if(value == 0) return " ";
		return ""+value;
	}
	
	public void reveal() {
		this.isHidden = false;
	}
	
	public void display() {
//		if(isHidden)
//			System.out.print("|?|");
//		else
			System.out.print("|"+strValue+"|");
	}
}
