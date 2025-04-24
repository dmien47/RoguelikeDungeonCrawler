public class Warrior extends Player {
    public Warrior(String name) {
        super(name, "Warrior", 100, 100, 30,
              new Weapon("Short sword", "Weapon", 7), 
              new Armor("Knights armor", "Armor", 10), 1, 0);
    }
}