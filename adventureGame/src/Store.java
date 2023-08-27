public class Store extends NormalLoc {
    Armor[] armors = {
            new Armor("Light", 1, 1, 15),
            new Armor("Medium", 2, 3, 25),
            new Armor("Heavy", 3, 5, 40)};
    Weapon[] weapons = {
            new Weapon("Pistol", 1, 2, 25),
            new Weapon("Sword", 2, 3, 35),
            new Weapon("Rifle", 3, 7, 45)};

    public Store(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {

        System.out.println("Welcome to the Store!");
        System.out.println("***************STORE***************");
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("0- Exit");
        System.out.print("What do you want to buy: ");
        int select = input.nextInt();
        System.out.println();
        switch (select) {
            case 1:
                buyWeapon();
                break;
            case 2:
                buyArmor();
                break;
            case 0:
                break;
            default:
                System.out.println("You entered invalid ID. Please try again!");
                break;
        }
        return true;
    }

    public void buyWeapon() {
        for (Weapon weapon : weapons) {
            System.out.println(weapon.getId() + "- " + weapon.getName() + " -->\tDamage: " + weapon.getDamage() + "\tPrice: " + weapon.getPrice());
        }
        System.out.print("Buy or Exit(0): ");
        int choice = input.nextInt();
        System.out.println();
        for (Weapon weapon : weapons) {
            if (choice == weapon.getId() && (player.getPlayerChar().getMoney() - weapon.getPrice()) >= 0) {
                player.getPlayerChar().setMoney(player.getPlayerChar().getMoney() - weapon.getPrice());
                System.out.println("You bought " + weapon.getName() + ".");
                System.out.println("Your money: " + player.getPlayerChar().getMoney());
                player.getInventory().setWeapon(weapon);
            } else if (choice == 0) {
                System.out.println("Good Luck My Friend. See you later..");
                break;
            } else if (choice == weapon.getId() && !((player.getPlayerChar().getMoney() - weapon.getPrice()) >= 0)) {
                System.out.println("You don't have enough money.");
            } else if (choice < 0 || choice > weapons.length) {
                System.out.println("You entered invalid ID. Please Try Again!");
            }
        }
        System.out.println();
    }

    public void buyArmor() {
        for (Armor armor : armors) {
            System.out.println(armor.getId() + "- " + armor.getName() + " -->\tBlock: " + armor.getBlock() + "\tPrice: " + armor.getPrice());
        }
        System.out.print("Buy or Exit(0): ");
        int choice = input.nextInt();
        System.out.println();
        for (Armor armor : armors) {
            if (choice == armor.getId() && (player.getPlayerChar().getMoney() - armor.getPrice()) >= 0) {
                player.getPlayerChar().setMoney(player.getPlayerChar().getMoney() - armor.getPrice());
                System.out.println("You bought " + armor.getName() + " Armor.");
                System.out.println("Your money: " + player.getPlayerChar().getMoney());
                player.getInventory().setArmor(armor);
            } else if (choice == 0) {
                System.out.println("Good Luck My Friend. See you later..");
            } else if (choice == armor.getId() && !((player.getPlayerChar().getMoney() - armor.getPrice()) >= 0)) {
                System.out.println("You don't have enough money.");
            } else if (choice < 0 || choice > armors.length){
                System.out.println("You entered invalid ID. Please Try Again!");
            }
        }
        System.out.println();
    }
}
