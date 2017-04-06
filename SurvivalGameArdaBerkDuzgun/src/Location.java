public abstract class Location {
	private int locationId;
	private String locationType;
	private boolean haveEnemy;
	private int maxEnemies;
	private int enemyId;
	private String item;

	public Location(int locationId, String locationType, boolean haveEnemy,
			int maxEnemies, int enemyId, String item) {

		this.locationId = locationId;
		this.locationType = locationType;
		this.haveEnemy = haveEnemy;
		this.maxEnemies = maxEnemies;
		this.enemyId = enemyId;
		this.item = item;

	}
	
	public abstract void welcomeMessage();


	public abstract boolean combatOrFlee(String chr, Battle battle);

	public abstract ObstacleClass[] getObstaclesByLocation();
	
	public abstract boolean hitOrFlee( Battle battle);

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public boolean isHaveEnemy() {
		return haveEnemy;
	}

	public void setHaveEnemy(boolean haveEnemy) {
		this.haveEnemy = haveEnemy;
	}

	public int getMaxEnemies() {
		return maxEnemies;
	}

	public void setMaxEnemies(int maxEnemies) {
		this.maxEnemies = maxEnemies;
	}

	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	

}
