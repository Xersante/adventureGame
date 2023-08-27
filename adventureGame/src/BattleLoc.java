import java.util.Random;

public abstract class BattleLoc extends Location {
    Random randomNum = new Random();
    Enemy enemy;
    int enemyNumber;

    public BattleLoc(Player player) {
        super(player);
    }
    public boolean combat(int enemyNumber){
        int firstHit = randomNum.nextInt(0,2);
        int enemyDamage = enemy.getDamage() - player.getInventory().getArmor().getBlock();
        if (enemyDamage < 0){
            enemyDamage = 0;
        }
        input.nextLine();
        for (int i = 1; i <= enemyNumber; i++){
            enemy.setHealth(enemy.getOrjHealth());

            while(true){
                enemy.getEnemyInfo();
                player.getPlayerInfo();
                System.out.print("Press any key to continue: ");
                input.nextLine();
                System.out.println();


                // Start Player
                if (firstHit == 0){
                    System.out.println("You hit " + player.getDamage() + " damage.");
                    enemy.setHealth(enemy.getHealth() - player.getDamage());
                    if(enemy.getHealth() == 0){
                        enemyDead();
                        break;
                    }
                    System.out.println(enemy.getName() + " hit " + enemyDamage + " damage.");
                    player.getPlayerChar().setHealth(player.getPlayerChar().getHealth() - enemyDamage);
                    if(player.getPlayerChar().getHealth() == 0){
                        System.out.println("\nYOU DIED!!");
                        player.getPlayerInfo();
                        System.out.println("********************************************");
                        return false;
                    }
                    System.out.println();

                // Start Enemy
                } else if (firstHit == 1) {
                    System.out.println(enemy.getName() + " hit " + enemyDamage + " damage.");
                    player.getPlayerChar().setHealth(player.getPlayerChar().getHealth() - enemyDamage);
                    if(player.getPlayerChar().getHealth() == 0){
                        System.out.println("\nYOU DIED!!");
                        player.getPlayerInfo();
                        System.out.println("********************************************");
                        return false;
                    }

                    System.out.println("You hit " + player.getDamage() + " damage.");
                    enemy.setHealth(enemy.getHealth() - player.getDamage());
                    if(enemy.getHealth() == 0) {
                        enemyDead();
                        break;
                    }
                    System.out.println();
                }
            }
        }
        return true;
    }
    public int enemyNumber(int number){
        number = randomNum.nextInt(number) + 1 ;
        return number;
    }
    public void enemyDead(){
        player.getPlayerChar().setMoney(player.getPlayerChar().getMoney() + enemy.getPrize());
        System.out.println("\nYou killed the " + enemy.getName() + ".");
        System.out.println("********************************************");
    }

}
