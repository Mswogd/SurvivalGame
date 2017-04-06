
import java.util.Scanner;

public class Game {
	private Scanner scan;

	public Game() {
	}

	public void startGame() {
		
		Battle battle = new Battle();
		Samurai samurai = new Samurai();
		Sniper sniper = new Sniper();
		Knight knight = new Knight();

		scan = new Scanner(System.in);
		Player player;
		String selectedPlayer;

		System.out.println("***Welcome to SURVIVE THE VILLAGE***");
		System.out.print("\nPlease enter your name: ");

		String playerName = scan.next();

		System.out.println("\n\n***Welcome " + playerName + "***");
		System.out.println("\nPlease select your character!");

		while (true) {

			System.out.println(samurai.getID() + ". " + samurai.getName()
					+ "  -->  " + "Health:" + samurai.getMaxHealth()
					+ "  Damage:" + samurai.getDamage() + "  Money:"
					+ samurai.getMoney());
			System.out.println(sniper.getID() + ". " + sniper.getName()
					+ "  -->  " + "Health:" + sniper.getMaxHealth()
					+ "  Damage:" + sniper.getDamage() + "  Money:"
					+ sniper.getMoney());
			System.out.println(knight.getID() + ". " + knight.getName()
					+ "  -->  " + "Health:" + knight.getMaxHealth()
					+ "  Damage:" + knight.getDamage() + "  Money:"
					+ knight.getMoney());
			System.out.print("Your Choose: ");

			selectedPlayer = scan.next();

			int playerId;

			try {
				playerId = Integer.parseInt(selectedPlayer);
			} catch (Exception ex) {
				System.out.println("Please enter a valid info ");
				continue;
			}

			player = Player.getInstance();

			if (playerId == 1) {
				player.setWarriorClass(samurai);
			}
			if (playerId == 2) {
				player.setWarriorClass(sniper);
			}
			if (playerId == 3) {
				player.setWarriorClass(knight);
			}

			System.out.println("\nWarrior created succesfully! ID: "
					+ player.getWarriorClass().getID() + ", NAME: "
					+ player.getWarriorClass().getName() + ", HEALTH: "
					+ player.getWarriorClass().getMaxHealth() + ", DAMAGE: "
					+ player.getWarriorClass().getDamage() + ", MONEY: "
					+ player.getWarriorClass().getMoney());

			SafeHouse enterSafeHouse = new SafeHouse(player.getWarriorClass());

			player.setCurrentLocation(enterSafeHouse);

			break;
		}
		boolean run = true;
		while (run == true) {

			System.out.println("\nPlease select location you want to go!");
			System.out.println("1. Safehouse	--> Your village, no enemies!");
			System.out.println("2. Restaurant	--> There will be zombies!");
			System.out.println("3. Forest	--> There will be vampires!");
			System.out.println("4. River	--> There will be bears!");
			System.out.println("5. Toolstore	--> You can buy stuff!");
			System.out.println("0. Need help?");
			System.out.print("\nYour choice: ");

			String selection = scan.next();
			int selectedLocation;

			try {
				selectedLocation = Integer.parseInt(selection);
			} catch (Exception ex) {
				System.out.println("Please enter a valid info ");
				continue;
			}
			if (selectedLocation == 0) {
				Needhelp h = new Needhelp();
				h.help();
			} else if (selectedLocation == 1) {
				SafeHouse safeHouse = new SafeHouse(player.getWarriorClass());
				player.setCurrentLocation(safeHouse);
				run = player.getInventory().finishGame();//the method which checks for food-firewood and water
			} else if (selectedLocation == 2) {
				Restaurant restaurant = new Restaurant();
				if (player.setCurrentLocation(restaurant)) {
					battle.obstacles = restaurant.getObstaclesByLocation();
					battle.warrior = player.getWarriorClass();
					selection = scan.next();
					boolean isSucceed = restaurant.combatOrFlee(selection,
							battle);
					player.getInventory().setFood(isSucceed);//the method which checks for food
				}

			} else if (selectedLocation == 3) {
				Forest forest = new Forest();
				if (player.setCurrentLocation(forest)) {
					battle.obstacles = forest.getObstaclesByLocation();
					battle.warrior = player.getWarriorClass();
					selection = scan.next();
					boolean isSucceed = forest.combatOrFlee(selection, battle);
					player.getInventory().setFirewood(isSucceed);//the method which checks for firewood
				}
				//getObstaclesByLocation method creates random obstacle numbers which we will fight
				//combatOrFlee() calls hitOrFlee() and hitOrFlee() calls war() from Battle class and that is the order of our fight
			} else if (selectedLocation == 4) {
				River river = new River();
				if (player.setCurrentLocation(river)) {
					battle.obstacles = river.getObstaclesByLocation();
					battle.warrior = player.getWarriorClass();
					selection = scan.next();
					boolean isSucceed = river.combatOrFlee(selection, battle);
					player.getInventory().setWater(isSucceed);//the method which checks for water
				}

			} else if (selectedLocation == 5) {
				ToolStore toolstore = new ToolStore();
				if (player.getCurrentLocation().equals("Tool Store")) {
					System.out.println("You are already in the Toolstore");
				}

				player.setCurrentLocation(toolstore);
				int selection5 = scan.nextInt();

				switch (selection5) {
				case 1:
					toolstore.WeaponList();
					int selection2 = scan.nextInt();
					switch (selection2) {
					case 1:
						toolstore.shopping(player.getWarriorClass(),
								toolstore.pistol);
						break;
					case 2:
						toolstore.shopping(player.getWarriorClass(),
								toolstore.sword);
						break;
					case 3:
						toolstore.shopping(player.getWarriorClass(),
								toolstore.rifle);
						break;
					case 4:
						break;
					}
					break;
				case 2:
					toolstore.ArmorList();
					int selection3 = scan.nextInt();
					switch (selection3) {
					case 1:
						toolstore.shopping(player.getWarriorClass(),
								toolstore.light);
						break;
					case 2:
						toolstore.shopping(player.getWarriorClass(),
								toolstore.medium);
						break;
					case 3:
						toolstore.shopping(player.getWarriorClass(),
								toolstore.heavy);
						break;
					case 4:
						break;

					}
					break;
				case 3:
					break;
				}

			} else {
				System.out.println(selection);
			}
			if (player.getWarriorClass().getHealth() < 0) {
				System.out.println("\nYou have been killed!");
				System.out.print("YOU LOST!\n\n");
				System.out.println("GAME OVER");
				run = false;
				break;

			}
		}
	}
}