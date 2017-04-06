
public class Armor extends WarItems{

	
	
	
	public Armor(int ID, String name,int avoid, int price) {
		super(ID, name, price);
		this.avoid=avoid;
	}


	private int avoid;



	
	public int getAvoid() {
		return avoid;
	}


	public void setAvoid(int avoid) {
		this.avoid = avoid;
	}



}
