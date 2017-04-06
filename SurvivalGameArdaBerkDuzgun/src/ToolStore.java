public class ToolStore extends Location {


	public ToolStore() {

		super(5, "Tool Store", false, 0, 0, null);
	}

	Bat bat = new Bat();
	Pistol pistol = new Pistol();
	Sword sword = new Sword();
	Rifle rifle = new Rifle();
	Light light = new Light();
	Medium medium = new Medium();
	Heavy heavy = new Heavy();

	public void WeaponList() {

		System.out.println("1. " + pistol.getName() + "(Price: "
				+ pistol.getPrice() + " - " + "Damage: +" + pistol.getDamage()
				+ ")");
		System.out.println("2. " + sword.getName() + "(Price: "
				+ sword.getPrice() + " - " + "Damage: +" + sword.getDamage()
				+ ")");
		System.out.println("3. " + rifle.getName() + "(Price: "
				+ rifle.getPrice() + " - " + "Damage: +" + rifle.getDamage()
				+ ")");
		System.out.println("4. Cancel");

	}

	public void ArmorList() {
		System.out.println("1. " + light.getName() + "(Price: "
				+ light.getPrice() + " - " + "Avoid: +" + light.getAvoid()
				+ ")");
		System.out.println("2. " + medium.getName() + "(Price: "
				+ medium.getPrice() + " - " + "Avoid: +" + medium.getAvoid()
				+ ")");
		System.out.println("3. " + heavy.getName() + "(Price: "
				+ heavy.getPrice() + " - " + "Avoid: +" + heavy.getAvoid()
				+ ")");
		System.out.println("4. Cancel");
	}



	public void boughtAndEquip(WarriorClass warrior, WarItems waritem) {

		if (waritem.getName().equals("Heavy")
				|| waritem.getName().equals("Medium")
				|| waritem.getName().equals("Light")) {
			if (waritem.getName().equals(light)) {
				warrior.setArmor(light);
			}
			if (waritem.getName().equals(medium)) {
				warrior.setArmor(medium);
			}
			if (waritem.getName().equals(heavy)) {
				warrior.setArmor(heavy);
			}
		}
		if (waritem.getName().equals("Rifle")
				|| waritem.getName().equals("Pistol")
				|| waritem.getName().equals("Sword")) {
			if (waritem.getName().equals("Rifle")) {
				warrior.setWeapon(rifle);
			}
			if (waritem.getName().equals("Pistol")) {
				warrior.setWeapon(pistol);
			}
			if (waritem.getName().equals("Sword")) {
				warrior.setWeapon(sword);
			}
		}
		System.out.print("You have succesfully bought and equipped the item ");

	}

	@Override
	public boolean combatOrFlee(String chr, Battle battle) {
	
		return false;
	}
	//that method checks warrior's money to bought necessary items
	public void shopping(WarriorClass warrior, WarItems waritem) {
		if (warrior.getMoney() >= waritem.getPrice()) {
			boughtAndEquip(warrior, waritem);

			if (waritem.getName().equals("Heavy")
					|| waritem.getName().equals("Medium")
					|| waritem.getName().equals("Light")) {
				System.out.println(waritem.getName() + " Armor");

			} else {
				System.out.println(waritem.getName());
			}
		} else {
			expensive();
		}
	}

	@Override
	public void welcomeMessage() {
		System.out.println("Welcome to Tool Store!");
		System.out.println("What you want to purchase??");
		System.out.println("1. Weapon");
		System.out.println("2. Armor");
		System.out.println("3. Cancel");
		System.out.print("Your choice: ");

	}

	@Override
	public ObstacleClass[] getObstaclesByLocation() {
	
		return null;
	}

	@Override
	public boolean hitOrFlee(Battle battle) {
	
		return false;
	}

	public void expensive() {
		System.out
				.println("The item you want to purchase is TOO EXPENSIVE for you!");
	}

}
