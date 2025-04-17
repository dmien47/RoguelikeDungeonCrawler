public class Rogue extends Player {
    public Rogue(String name) {
        super(name, "Rogue", 80, 10, 10, 10, 0,
              new Weapon("Theif's dagger", "Dagger", 6),
              new Armor("Theif's cloak", "cloak", 6));
    }
}