
import java.util.Scanner;

public class Restaurant extends Location {


	private Scanner scan;

	public Restaurant() {
		super(2, "Restaurant", true, 3, 1, "Food");

	}

	@Override
	public boolean combatOrFlee(String chr, Battle battle) {

		if (chr.toLowerCase().equals("c")) {
			battle.getStatus(0);
			return hitOrFlee(battle);
		} else {
			return false;
		}
	}

	@Override
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
		int lenght = new Zombie().createObstacleCount();
		Zombie[] zombies = new Zombie[lenght];// new Zombie[new
												// Zombie().createObstacleCount()];

		for (int i = 0; i < lenght; i++) {
			zombies[i] = new Zombie();
		}
		System.out.println("You are in the RESTAURANT\n");
		System.out.print("!!Be Careful!! There are ");
		System.out.print(lenght);
		System.out.println(" Zombie(s) 	in the Restaurant!");
		System.out.print("(C)ombat or (F)lee?: ");
		System.out.println();

		return zombies;
	}



}
