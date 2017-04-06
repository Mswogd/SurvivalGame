public class WarriorClass {
	// ID, Name, Damage, Money,
	// Health".

	private long ID;
	private String name;
	private int damage;
	private int money;
	private int health;
	private int maxHealth;
	private Weapon weapon;
	private Armor armor;

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		
	}

	public WarriorClass(int ID, String name, int damage, int money,	int maxHealth) {
		this.ID = ID;
		this.name = name;
		this.damage = damage;
		this.money = money;
		this.maxHealth = maxHealth;
		this.weapon = new Bat();
		this.armor = null;
		this.health = maxHealth;
		
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
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

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void heal() {
		setHealth(getMaxHealth());

	}
}
