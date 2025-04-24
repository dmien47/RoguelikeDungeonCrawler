public class Rogue extends Player {
    public Rogue(String name) {
        super(name, "Rogue", 80, 50,
              new Weapon("Theif's dagger", "Weapon", 6),
              new Armor("Theif's cloak", "Armor", 6), 1, 0);
    }
}