import java.util.Scanner;

public class River extends Location {

	private Scanner scan;

	public River() {
		super(4, "River", true, 3, 3, "Water");

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
		} else {
			return false;
		}

	}

	@Override
	public void welcomeMessage() {

	}

	@Override
	public ObstacleClass[] getObstaclesByLocation() {
		int lenght = new Bear().createObstacleCount();
		Bear[] bears = new Bear[lenght];

		for (int i = 0; i < lenght; i++) {
			bears[i] = new Bear();
		}
		System.out.println("You are in the RIVER\n");
		System.out.print("!!Be Careful!! There are ");
		System.out.print(lenght);
		System.out.println(" Bear(s) around the River side!");
		System.out.print("(C)ombat or (F)lee?: \n");

		return bears;
	}

}
