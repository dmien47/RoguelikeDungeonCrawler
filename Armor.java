public class Armor extends Item {

    private double defense;

    public Armor(String name, String type, double defense) {
        super(name, type);
        this.defense = defense;
    }

    public Armor(Armor armor){
        super(armor.getName(), armor.getType());
        this.defense = armor.getDefense();
    }

    public double getDefense() {
        return defense;
    }

    /*public String toString() {
        return "Name: " + name + 
               "Type: " + type + 
               "Behavior: " + useBehavior + 
               "Defense: " + defense;
    }*/


}