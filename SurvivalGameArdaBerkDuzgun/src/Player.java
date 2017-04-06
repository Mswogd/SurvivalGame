public class Player {
	private int ID;
	private WarriorClass warriorClass;

	private Location currentLocation;
	private Inventory inventory;
	private Battle battle;
	private Level levelType;
	private static Player instance = new Player();

	private Player(int playerId, String playerName) {
		newCharacter(playerId);
		this.inventory = new Inventory();
		this.setLevelType(Level.LEVEL0);
	}

	private Player() {
		this.inventory = new Inventory();
		this.setLevelType(Level.LEVEL0);
	}

	public static Player getInstance() {
		return instance;
	}

	public void newCharacter(int ID) {

		switch (ID) {
		case 1:

			setWarriorClass(new Samurai());
			break;
		case 2:
			setWarriorClass(new Sniper());
			break;
		case 3:
			setWarriorClass(new Knight());
			break;
		default:

		}
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public WarriorClass getWarriorClass() {
		return warriorClass;
	}

	public void setWarriorClass(WarriorClass warriorClass) {
		this.warriorClass = warriorClass;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public boolean setCurrentLocation(Location currentLocation) {
		if (this.getCurrentLocation() != null
				&& this.getCurrentLocation().getLocationType()
						.equals(currentLocation.getLocationType())) {
			System.out.println("You are already in the "
					+ currentLocation.getLocationType()
					+ " Please select another location!!");
			return false;
		} else {

			this.currentLocation = currentLocation;
			this.currentLocation.welcomeMessage();

			return true;
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public Level getLevelType() {
		return levelType;
	}

	public void setLevelType(Level levelType) {
		this.levelType = levelType;
	}

}
