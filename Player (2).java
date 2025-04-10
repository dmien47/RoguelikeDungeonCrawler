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
    
    public boolean isAlive() {
        return hp > 0;
    }

    public int attack() {
        return strength + 5; 
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " has " + Math.max(0, hp) + " HP left.");
    }
    
    public void heal(int amount) {
        this.hp += amount;
        System.out.println(name + " healed for " + amount + " HP. Current HP: " + hp);
    }

    public void boostAttribute(String attr, int value) {
        switch (attr.toLowerCase()) {
            case "strength":
                this.strength += value;
                break;
            case "intelligence":
                this.intelligence += value;
                break;
           
        }
        System.out.println(name + "'s " + attr + " increased by " + value);
    }

    public void unlockSkill(String skillName) {
        System.out.println(name + " unlocked the skill: " + skillName);
    
    }


}