public class Armor extends Item {

    private int defense;

    public Armor(String name, String type, int defense) {
        super(name, type);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    /*public void equipArmor(Player player, Armor armor) {
        System.out.println("You are now wearing the " + armor.getType() + ", " + armor.getName() +
                           " which defends for  " + defense + "damage.");
        player.equippedArmor = armor;
    }*/

    /*public String toString() {
        return "Name: " + name + 
               "Type: " + type + 
               "Behavior: " + useBehavior + 
               "Defense: " + defense;
    }*/


}