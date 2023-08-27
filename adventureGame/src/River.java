public class River extends BattleLoc{

    public River(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        enemy = new Bear();
        int enemyNumber = enemyNumber(enemy.getMaxNum());
        System.out.println("***************RIVER***************");
        if(enemyNumber == 1){
            System.out.println("There is " + enemyNumber + " Bear in River.");
        }else{
            System.out.println("There are " + enemyNumber + " Bears in River.");
        }
        while (true){
            System.out.print("1-Fight\n2-Run\nWhat will you do:");
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1 ){
                if(combat(enemyNumber)){
                    player.getInventory().setWater(true);
                }else{
                    return false;
                }
                break;
            }else if (choice == 2 ){
                System.out.println("You escaped the River.");
                break;
            }else{
                System.out.println("You entered invalid ID. Please try again!");
            }
        }

        return true;
    }
}
