public class SafeHouse extends Location {

	public SafeHouse(WarriorClass warrior) {

		super(1, "Safe House", false, 0, 0, null);
		heal(warrior);
		

	}

	public void heal(WarriorClass warrior) {
		warrior.setHealth(warrior.getMaxHealth());
		System.out.println("You are healed!\n");
	}





	@Override
	public boolean combatOrFlee(String chr, Battle battle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void welcomeMessage() {
		
		System.out.println("You are in the SAFEHOUSE now!\n");

	}

	@Override
	public ObstacleClass[] getObstaclesByLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hitOrFlee(Battle battle) {
		// TODO Auto-generated method stub
		return false;
		
	}





	


}
