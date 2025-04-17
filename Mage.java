public class Mage extends Player {
    public Mage(String name) {
        super(name, "Mage", 60, 5, 20, 0, 100, 
              new Weapon("Apprentice Staff", "Staff", 8), 
              new Armor("Apprentice Robes", "Robe", 4));
    }
}