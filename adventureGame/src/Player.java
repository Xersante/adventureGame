import java.util.Scanner;

public class Player {
    public Scanner input = new Scanner(System.in);
    private Inventory inventory = new Inventory() ;
    private GameChar playerChar;
    private int damage;
    private String name;



    public void selectChar(){
        GameChar[] chars = {new Samurai(), new Archer(), new Knight()};
        boolean isTrue = true;
        while (isTrue){
            for(GameChar c : chars){
                System.out.println(c.getId() + "- " + c.getName()
                        + " -->\tDamage: " + c.getDamage()
                        + "\tHealth: " + c.getHealth()
                        + "\tMoney: " + c.getMoney());
            }
            System.out.print("Choose your character: ");
            int select = input.nextInt();
            for(GameChar c: chars){
                if(c.getId() == select){
                    playerChar = c;
                    isTrue = false;
                    System.out.println();
                    break;
                }else if(select <= 0 || select > chars.length){
                    System.out.println("You entered invalid ID. Please try again!");
                    System.out.println();
                    break;
                }
            }
        }

    }

    public void playerName(){
        System.out.print("Enter your name: ");
        String playerName = input.nextLine();
        this.name = playerName;
    }
    public void getPlayerInfo(){
        System.out.println("Your Stats:");
        System.out.println("Health: " + playerChar.getHealth()
                + "\tWeapon: " + inventory.getWeapon().getName()
                + "\tDamage: " + getDamage()
                + "\tArmor: " + inventory.getArmor().getName()
                + "\tBlock: " + inventory.getArmor().getBlock()
                + "\tMoney: " + playerChar.getMoney() );
        System.out.println();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameChar getPlayerChar() {
        return playerChar;
    }

    public void setPlayerChar(GameChar playerChar) {
        this.playerChar = playerChar;
    }

    public int getDamage() {
        return playerChar.getDamage() + inventory.getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
