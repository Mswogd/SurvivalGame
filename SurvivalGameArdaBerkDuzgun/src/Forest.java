import java.util.Scanner;

public class Forest extends Location {

	private Scanner scan;

	public Forest() {
		super(3, "Forest", true, 3, 2, "Wood");

	}

	public boolean combatOrFlee(String chr, Battle battle) {

		if (chr.toLowerCase().equals("c")) {
			battle.getStatus(0);
			return hitOrFlee(battle);
		} else {
			return false;
		}
	}

	public boolean hitOrFlee(Battle battle) {

		System.out.println("(H)it or (F)lee? ");
		scan = new Scanner(System.in);

		String chr = scan.next();
		if (chr.toLowerCase().equals("h")) {
			int warStatus = battle.war();

			if (warStatus == 0) {
				hitOrFlee(battle);
			}
			if (warStatus == 1) {
				hitOrFlee(battle);
			}
			if (warStatus == 3) {
				battle.setCompleted(true);
			}
		}
		if (battle.isCompleted()) {
			return true;
		}
		return false;
	}

	@Override
	public void welcomeMessage() {

	}

	@Override
	public ObstacleClass[] getObstaclesByLocation() {
		int lenght = new Vampire().createObstacleCount();

		Vampire[] vampires = new Vampire[lenght];

		for (int i = 0; i < lenght; i++) {
			vampires[i] = new Vampire();
		}

		System.out.println("You are in the FOREST\n");
		System.out.print("!!Be Careful!! There are ");
		System.out.print(lenght);
		System.out.println(" Vampire(s) in the Forest!");
		System.out.println("(C)ombat or (F)lee?: \n");
		return vampires;
	}

}
