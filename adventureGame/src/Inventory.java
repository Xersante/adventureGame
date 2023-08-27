public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;
    private Weapon weapon = new Weapon("Punch", -1, 0, 0);
    private Armor armor = new Armor("Torn Clothes  ", -1, 0,0);


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        if (weapon.getId() > this.weapon.getId()){
            this.weapon = weapon;
        }
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        if (armor.getId() > this.armor.getId()){
            this.armor = armor;
        }
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }


}
