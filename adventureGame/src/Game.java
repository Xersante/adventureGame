import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);
    private Player player;
    private Location location;
    public void start(){
        boolean isTrue = true;
        this.player = new Player();
        player.playerName();
        System.out.println(player.getName() + ", welcome to the Dark Jungle!!!");
        System.out.println("Here you will encounter terrible things.. ");
        System.out.println("You must be so careful.");
        System.out.println("If you want to escape the Dark Jungle you have to find:\n1-Food\n2-Firewood\n3-Water");
        System.out.println("Good Luck My Friend :)");
        System.out.println("*****************************************************");
        System.out.println();
        player.selectChar();
        while(isTrue){
            player.getPlayerInfo();
            switch (selectLocation()){
                case 1:
                    location = new SafeHouse(player);
                    location.onLocation();
                    if (isWin()){
                        System.out.println("You are the king of the DARK JUNGLE.");
                        System.out.println("YOU WIN!!");
                        System.exit(0);
                    }
                    break;
                case 2:
                    location = new Store(player);
                    location.onLocation();
                    break;
                case 3:
                    if(player.getInventory().isFood()){
                        System.out.println("You got the Prize. You cannot get in again!");
                        System.out.println();
                        break;
                    }
                    location = new Cave(player);
                    if(!location.onLocation()){
                        System.out.println("GAME OVER!!!");
                        System.exit(0);
                    }
                    break;
                case 4:
                    if(player.getInventory().isFirewood()){
                        System.out.println("You got the Prize. You cannot get in again!");
                        System.out.println();
                        break;
                    }
                    location = new Forest(player);
                    if(!location.onLocation()){
                        System.out.println("GAME OVER!!!");
                        System.exit(0);
                    }
                    break;
                case 5:
                    if(player.getInventory().isWater()){
                        System.out.println("You got the Prize. You cannot get in again!");
                        System.out.println();
                        break;
                    }
                    location = new River(player);
                    if(!location.onLocation()){
                        System.out.println("GAME OVER!!!");
                        System.exit(0);
                    }
                    break;
                case 6:
                    location = new Mine(player);
                    if(!location.onLocation()){
                        System.out.println("GAME OVER!!!");
                        System.exit(0);
                    }
                    break;
                case 0:
                    System.out.println("So you are running like a coward.");
                    System.out.println("GAME OVER!!!");
                    isTrue = false;
                    break;
                default:
                    System.out.println("You entered invalid number. Please try again!");
                    break;
            }
        }


    }
    public boolean isWin(){
        if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()){
            return true;
        }
        return false;
    }
    public int selectLocation() {
        System.out.println("***************AREAS***************");
        System.out.println("1- Safe House --> Enemies cannot get in here.");
        System.out.println("2- Store --> You can buy weapon or armor.");
        System.out.println("3- Cave --> Dark Cave.. You might encounter with zombies.");
        System.out.println("4- Forest --> Foggy Forest.. You might encounter with vampires.");
        System.out.println("5- River --> Mystic River.. You might encounter with bears.");
        System.out.println("6- Mine --> Dangerous Mine.. You might encounter with snakes but secret prizes wait you.");
        System.out.println("0- Exit");
        System.out.print("Choose where you want to go:");
        int select = input.nextInt();
        System.out.println();
        return select;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
