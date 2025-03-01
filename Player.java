public abstract class Player {
    protected String name;
    protected String characterClass;
    protected int hp, mana, strength, intelligence, resource;
    protected double criticalStrike;

    public Player(String name, String characterClass, int hp, int strength, int intelligence, double criticalStrike, int resource) {
        this.name = name;
        this.characterClass = characterClass;
        this.hp = hp;
        this.strength = strength;
        this.intelligence = intelligence;
        this.criticalStrike = criticalStrike;
        this.resource = resource;
    }

    public void showStats() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + characterClass);
        System.out.println("HP: " + hp);
        System.out.println("Strength: " + strength + " | Intelligence: " + intelligence);
        System.out.println("Crit: " + criticalStrike);
    }
}