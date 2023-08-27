public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        enemy = new Zombie();
        int enemyNumber = enemyNumber(enemy.getMaxNum());
        System.out.println("***************CAVE***************");
        if(enemyNumber == 1){
            System.out.println("There is " + enemyNumber + " Zombie in Cave.");
        }else{
            System.out.println("There are " + enemyNumber + " Zombies in Cave.");
        }
        while (true){
            System.out.print("1-Fight\n2-Run\nWhat will you do:");
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1 ){
                if(combat(enemyNumber)){
                    player.getInventory().setFood(true);
                }else{
                    return false;
                }
                break;
            }else if (choice == 2 ){
                System.out.println("You escaped the Cave.");
                break;
            }else{
                System.out.println("You entered invalid ID. Please try again!");
            }
        }
        return true;
    }
}
