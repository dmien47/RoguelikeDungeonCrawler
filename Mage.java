public class Mage extends Player {
    public Mage(String name) {
        super(name, "Mage", 100, 100, 20,
              new Weapon("Apprentice Staff", "Weapon", 8), 
              new Armor("Apprentice Robes", "Armor", 4), 1, 0);
    }
}