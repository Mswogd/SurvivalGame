public class Battle {

	WarriorClass warrior;
	ObstacleClass[] obstacles;
	Location location;
	int obstacleIndex;
	boolean isCompleted;
	
	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	Player player = Player.getInstance();
	
	
	public Battle() {
		obstacleIndex = 0;
	}

	public void getStatus(int obstacleIndex) {
		if (warrior != null && obstacles != null
				&& obstacles[obstacleIndex] != null) {
			System.out.println("Player Stats--------------");
			System.out.println("Health: " + warrior.getHealth());
			System.out.println("Damage: " + warrior.getDamage());
			System.out.println("Weapon: " + warrior.getWeapon().getName()
					+ " +" + warrior.getWeapon().getDamage() + " damage");
			System.out.println("Money: " + warrior.getMoney());
			System.out.println("Enemy Stats--------------");
			System.out.println("Name: " + obstacles[obstacleIndex].getName());
			System.out.println("Health: "
					+ obstacles[obstacleIndex].getHealth());
			System.out.println("Damage: "
					+ obstacles[obstacleIndex].getDamage());
		}
	}
/*
 * 
 */
	public int war() {
		if (warrior != null && obstacles != null) {
			
			int obstacleCount = obstacles.length;
			
			for (ObstacleClass obstacle : obstacles) {
				//weapon damage set
				if (warrior.getHealth() > 0 && obstacle.getHealth() > 0) {
					if (warrior.getWeapon() != null) {
						warrior.setDamage(warrior.getDamage()
								+ warrior.getWeapon().getDamage());
					}
				//armor avoid set
					if (warrior.getArmor() != null) {
						obstacle.setDamage(obstacle.getDamage()
								- warrior.getArmor().getAvoid());
					}
					//player hit to obstacle
					hitToObstacle(obstacleIndex);
					//obstacle hit to player
					hitToPlayer(obstacleIndex);

					if (obstacle.getHealth() > 0) {
						return 0;
					}
				}
				if (obstacle.getHealth() <= 0 && !obstacle.getKilled()) {
					obstacle.setKilled(true);//check for obstacle killed
					moneyTransfer(obstacleIndex);//earned money from obstacle
					obstacleIndex++;//next obstacle
					
					if(obstacleIndex >= obstacleCount){
						obstacleIndex = 0;
						//checking obstacle type to find which place cleared from obstacles
						System.out.print("\nYou KILLED all the enemies in the ");
						if(obstacle.getName().toLowerCase().equals("zombie")){
							System.out.println("RESTAURANT");}
						else if(obstacle.getName().toLowerCase().equals("vampire")){
							System.out.println("FOREST");}
						else if(obstacle.getName().toLowerCase().equals("bear")){
							System.out.println("RIVER");}
						//when a place cleared it will return 3 to the hitOrFlee method
						return 3;
					}//these return statements are very important because hitOrFlee method calls that method in every locations you can fight
					return 1;
				}
				if (warrior.getHealth() <= 0) {
					return 2;
				}
			}
		}
		return 3;
	}

	public void hitToObstacle(int obstacleIndex) {
		if (warrior.getHealth() > 0 && obstacles[obstacleIndex].getHealth() > 0) {
			obstacles[obstacleIndex].setHealth(obstacles[obstacleIndex]
					.getHealth() - warrior.getDamage());
			System.out.println("You hit the enemy!!!");
			System.out.println("Player Health: "+warrior.getHealth());
			System.out.println("Enemy Health: "
					+ obstacles[obstacleIndex].getHealth());
		}
		if (obstacles[obstacleIndex].getHealth() < 0) {
			System.out.println("You KILLED an enemy  :" + obstacleIndex);
		

		}

	}

	public void hitToPlayer(int obstacleIndex) {
		if (obstacles[obstacleIndex].getHealth() > 0) {
			warrior.setHealth(warrior.getHealth() - obstacles[obstacleIndex].getDamage());
			System.out.println("Enemy hits you!!!");
			System.out.println("Player Health: " + warrior.getHealth());
			System.out.println("Enemy Health: "+obstacles[obstacleIndex].getHealth());
		}

	}

	public void moneyTransfer(int obstacleIndex) {

		warrior.setMoney(warrior.getMoney()
				+ obstacles[obstacleIndex].getMoney());
		System.out.println("Your current money: " + warrior.getMoney());

	}
	public void killedTheObstacle(){
		
	}
	public boolean itemCheck(){
		
		return false;
	}

}
