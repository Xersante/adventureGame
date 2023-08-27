public class Mine extends BattleLoc{
    public Mine(Player player) {
        super(player);
    }
    Snake snake = new Snake();
    @Override
    public boolean onLocation() {
        enemy = snake;

        int enemyNumber = enemyNumber(enemy.getMaxNum());
        System.out.println("***************MINE***************");
        if(enemyNumber == 1){
            System.out.println("There is " + enemyNumber + " Snake in Mine.");
        }else{
            System.out.println("There are " + enemyNumber + " Snakes in Mine.");
        }
        while (true){
            System.out.print("1-Fight\n2-Run\nWhat will you do:");
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1 ){
                if(combat(enemyNumber)){

                }else{
                    return false;
                }
                break;
            }else if (choice == 2 ){
                System.out.println("You escaped the Mine.");
                break;
            }else{
                System.out.println("You entered invalid ID. Please try again!");
            }
        }
        return true;
    }

    @Override
    public void enemyDead() {
        if(snake.whichPrize() == 1){
            player.getInventory().setArmor(snake.getArmorPrize());
        }
        if(snake.whichPrize() == 2){
            player.getInventory().setWeapon(snake.getWeaponPrize());
        }
        if (snake.whichPrize() == 3) {
            player.getPlayerChar().setMoney(snake.getMoneyPrize() + player.getPlayerChar().getMoney());
        }
        System.out.println("\nYou killed the " + enemy.getName() + ".");
        System.out.println("********************************************");
    }
}
