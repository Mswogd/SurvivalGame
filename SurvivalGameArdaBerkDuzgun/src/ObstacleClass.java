import java.util.Random;

public class ObstacleClass {

	private long ID;
	private String name;
	private int damage;
	private int money;
	private int health;
	private int count;
	private boolean isKilled;

	public boolean getKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int createObstacleCount() {
		Random rnd = new Random();

		if (this.getName().toLowerCase().equals("vampire")
				|| this.getName().toLowerCase().equals("zombie")) {
			count = Math.abs(rnd.nextInt(3) + 1);
			return count;
		} else if (this.getName().toLowerCase().equals("bear")) {
			count = Math.abs(rnd.nextInt(2) + 1);
			return count;
		}

		return count;

	}

	public ObstacleClass(int ID, String name, int damage, int money,
			int maxHealth) {
		this.ID = ID;
		this.name = name;
		this.damage = damage;
		this.money = money;
		this.health = maxHealth;
		createObstacleCount();

	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
