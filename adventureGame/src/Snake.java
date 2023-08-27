import java.util.Random;

public class Snake extends Enemy{
    private Armor[] armors = {
            new Armor("Light", 1, 1, 15),
            new Armor("Medium", 2, 3, 25),
            new Armor("Heavy", 3, 5, 40)};
    private Weapon[] weapons = {
            new Weapon("Pistol", 1, 2, 25),
            new Weapon("Sword", 2, 3, 35),
            new Weapon("Rifle", 3, 7, 45)};
    Random random = new Random();
    private Weapon weaponPrize = new Weapon("Punch", -1, 0, 0);
    private Armor armorPrize = new Armor("Torn Clothes  ", -1, 0,0);
    private int moneyPrize = 0;
    private int damage;
    private int prizeChance;
    private int chance;
    public Snake() {
        super("Snake", 0, 12, 0, 5, 12);
        damage = random.nextInt(3,7);
    }

    @Override
    public void getEnemyInfo() {
        if(getHealth() == getOrjHealth()){
            prizeChance = random.nextInt(1,101);
            if (prizeChance <= 15 && prizeChance >= 1){
                armorChance();
            }else if(prizeChance > 15 && prizeChance <= 30){
                weaponChance();
            }else if(prizeChance > 30 && prizeChance <= 55){
                moneyChance();
            }
        }
        System.out.println( getName() + " Stats:");
        System.out.print("Health: " + getHealth()
                + "\tDamage: " + getDamage());
        if(armorPrize.getId() > 0){
            System.out.println("\tPrize: " + armorPrize.getName() + " Armor");
        }else if(weaponPrize.getId() > 0){
            System.out.println("\tPrize: " + weaponPrize.getName());
        }else if(moneyPrize > 0){
            System.out.println("\tPrize: " + moneyPrize);
        }else {
            System.out.println("\tPrize: 0" );
        }
        System.out.println();

    }
    public int whichPrize(){
        if(armorPrize.getId() > 0){
            return 1;
        }else if(weaponPrize.getId() > 0){
            return 2;
        }else if(moneyPrize > 0){
            return 3;
        }
        return 0;
    }
    public void snakePrize(){
        prizeChance = random.nextInt(1,101);
        if (prizeChance <= 15 && prizeChance >= 1){
            armorChance();
        }else if(prizeChance > 15 && prizeChance <= 30){
            weaponChance();
        }else if(prizeChance > 30 && prizeChance <= 55){
            moneyChance();
        }
    }
    public int moneyChance(){
        chance = random.nextInt(1,11);
        if (chance <= 2){
            moneyPrize = 10;
        }else if (chance <=5){
            moneyPrize = 5;
        }else{
            moneyPrize = 1;
        }
        return moneyPrize;
    }
    public Armor armorChance(){
        chance = random.nextInt(1,11);
        if (chance <= 2){
            armorPrize = armors[2];
        }else if (chance <=5){
            armorPrize = armors[1];
        }else{
            armorPrize = armors[0];
        }
        return armorPrize;
    }
    public Weapon weaponChance(){
        chance = random.nextInt(1,11);
        if (chance <= 2){
            weaponPrize = weapons[2];
        }else if (chance <=5){
            weaponPrize = weapons[1];
        }else{
            weaponPrize = weapons[0];
        }
        return  weaponPrize;
    }

    public Weapon getWeaponPrize() {
        return weaponPrize;
    }

    public void setWeaponPrize(Weapon weaponPrize) {
        this.weaponPrize = weaponPrize;
    }

    public Armor getArmorPrize() {
        return armorPrize;
    }

    public void setArmorPrize(Armor armorPrize) {
        this.armorPrize = armorPrize;
    }

    public int getMoneyPrize() {
        return moneyPrize;
    }

    public void setMoneyPrize(int moneyPrize) {
        this.moneyPrize = moneyPrize;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
