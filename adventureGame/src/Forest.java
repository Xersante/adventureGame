public class Forest extends BattleLoc{

    public Forest(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        enemy = new Vampire();
        int enemyNumber = enemyNumber(enemy.getMaxNum());
        System.out.println("***************FOREST***************");
        if(enemyNumber == 1){
            System.out.println("There is " + enemyNumber + " Vampire in Forest.");
        }else{
            System.out.println("There are " + enemyNumber + " Vampire in Forest.");
        }
        while (true){
            System.out.print("1-Fight\n2-Run\nWhat will you do:");
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1 ){
                if(combat(enemyNumber)){
                    player.getInventory().setFirewood(true);
                }else{
                    return false;
                }
                break;
            }else if (choice == 2 ){
                System.out.println("You escaped the Forest.");
                break;
            }else{
                System.out.println("You entered invalid ID. Please try again!");
            }
        }

        return true;
    }
}
