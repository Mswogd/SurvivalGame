
public class Weapon extends WarItems {

	private int damage;
	
	public Weapon(int ID, String name,int damage, int price) {
		super(ID, name, price);
		this.damage=damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	


	
	
}
