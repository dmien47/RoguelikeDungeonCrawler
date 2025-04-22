public class Rogue extends Player {
    public Rogue(String name) {
        super(name, "Rogue", 80, 50,
              new Weapon("Theif's dagger", "Dagger", 6),
              new Armor("Theif's cloak", "cloak", 6), 1, 0);
    }
}