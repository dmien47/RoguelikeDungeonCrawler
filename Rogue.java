public class Rogue extends Player {
    public Rogue(String name) {
        super(name, "Rogue", 100, 100, 50,
              new Weapon("Theif's dagger", "Weapon", 6),
              new Armor("Theif's cloak", "Armor", .06), 1, 0, null);
    }
}