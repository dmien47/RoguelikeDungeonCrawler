public class Weapon extends Item {

    private int dmg;

    public Weapon(String name, String type, int dmg) {
        super(name, type);
        this.dmg = dmg;
    }

    public Weapon(Weapon weapon){
        super(weapon.getName(), weapon.getType());
        this.dmg = weapon.getDmg();
    }

    public int getDmg() {
        return dmg;
    }


    /*public void equipWeapon(Player player, Weapon weapon) {
        System.out.println("You are now wielding the " + weapon.getType() + ", " + weapon.getName() + " which deals " + dmg + "damage.");
        player.equippedWeapon = weapon;
    }*/

}