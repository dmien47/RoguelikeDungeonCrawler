public class Warrior extends Player {
    public Warrior(String name) {
        super(name, "Warrior", 100, 20, 5, 0, 0, 
              new Weapon("Short sword", "Sword", 7), 
              new Armor("Knights armor", "Heavy", 10));
    }
}