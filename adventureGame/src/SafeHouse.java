public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        player.getPlayerChar().setHealth(player.getPlayerChar().getOrjHealth());
        System.out.println("You are in Safe House.");
        System.out.println("You are safe and your health was fulled.");
        return true;
    }
}
