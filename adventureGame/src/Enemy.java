public abstract class Enemy {
    private String name;
    private int damage;
    private int health;
    private int prize;
    private int maxNum;
    private int orjHealth;

    public Enemy(String name, int damage, int health, int prize, int maxNum, int orjHealth) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.prize = prize;
        this.maxNum = maxNum;
        this.orjHealth = orjHealth;
    }
    public void getEnemyInfo(){
        System.out.println( name + " Stats:");
        System.out.println("Health: " + getHealth()
                + "\tDamage: " + getDamage()
                + "\tPrize: " + getPrize() );
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (health < 0){
            this.health = 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
