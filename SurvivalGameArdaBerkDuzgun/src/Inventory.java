public class Inventory {

	private long ID;
	private int weaponId;
	private int armorId;
	private boolean water;
	private boolean food;
	private boolean firewood;
	private Level levelType;

	public Inventory() {

		water = false;// 3.
		food = false;// 1.
		firewood = false;// 2.

	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
		if (this.water == true) {
			System.out.println("You win the WATER item :) :)");
			setLevelType(Level.LEVEL3);
		}
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
		if (this.food) {
			System.out.println("You win the FOOD item :) :)");
			setLevelType(Level.LEVEL1);
		}
	}

	public boolean isFirewood() {
		return firewood;
	}

	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
		if (this.firewood) {
			System.out.println("You win the FIREWOOD item :) :)");
			setLevelType(Level.LEVEL2);
		}
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public int getArmorId() {
		return armorId;
	}

	public void setArmorId(int armorId) {
		this.armorId = armorId;
	}

	public boolean finishGame() {
		if (isFirewood() == true && isFood() == true && isWater() == true) {
			System.out.println("YOU WON");
			return false;
		}
		return true;
	}

	public Level getLevelType() {
		return levelType;
	}

	public void setLevelType(Level levelType) {
		this.levelType = levelType;
	}

}
