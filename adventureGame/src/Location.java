import java.util.Scanner;

public abstract class Location {
    Player player;
    String name;
    public Scanner input = new Scanner(System.in);

    public Location(Player player) {
        this.player = player;
    }

    public abstract boolean onLocation();


}
