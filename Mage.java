public class Mage extends Player {
    public Mage(String name) {
        super(name, "Mage", 100, 20,
              new Weapon("Apprentice Staff", "Staff", 8), 
              new Armor("Apprentice Robes", "Robe", 4), 1, 0);
    }
}