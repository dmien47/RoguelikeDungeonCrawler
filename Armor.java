public class Armor extends Item {

    private int defense;

    public Armor(String name, String type, int defense) {
        super(name, type);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    /*public String toString() {
        return "Name: " + name + 
               "Type: " + type + 
               "Behavior: " + useBehavior + 
               "Defense: " + defense;
    }*/


}