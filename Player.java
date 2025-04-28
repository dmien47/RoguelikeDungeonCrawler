import java.util.Random;

public abstract class Player {
    protected String name;
    protected String characterClass;
    protected int hp, maxHp;
    protected double criticalStrike;
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected int lvl;
    protected double xp;
    private double xpNeededForLvlUp = 1000;
    private String statusAffliction = null;

    public Player(String name, String characterClass, int hp, int maxHp, double criticalStrike,
                  Weapon equippedWeapon, Armor equippedArmor, int lvl, int xp, String statusAffliction) {
        this.name = name;
        this.characterClass = characterClass;
        this.hp = hp;
        this.maxHp = maxHp;
        this.criticalStrike = criticalStrike;
        this.equippedWeapon = equippedWeapon;
        this.equippedArmor = equippedArmor;
        this.lvl = lvl;
        this.xp = xp;
        this.statusAffliction = statusAffliction;
    }

    public void showStats() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + characterClass);
        System.out.println("Level: " + lvl);
        System.out.println("HP: " + hp);
        System.out.println("Crit: " + criticalStrike);
        if (equippedWeapon != null) {
            System.out.println("Equipped Weapon: " + equippedWeapon.getName());
        }
        if (equippedArmor != null) {
            System.out.println("Equipped Armor: " + equippedArmor.getName());
        }
    }

    public String getStatusAffliction() {
        return statusAffliction;
    }
    
    public void setStatusAffliction(String status) {
        this.statusAffliction = status;
    }
    
    public boolean isAfflicted() {
        return statusAffliction != null;
    }

    public String getCharacterClass(){
        return characterClass;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public int getHp() {
        return hp;
    }
    public int getLvl() { return lvl; }

    public double getXp() {
        return xp;
    }
    
    public boolean isAlive() {
        return hp > 0;
    }

    public int attack() {
        Random r = new Random(); 
        if(r.nextDouble() < criticalStrike){
            System.out.println("\nCritical Strike!\n");
            return equippedWeapon.getDmg() * 2;
        }else{
            return equippedWeapon.getDmg();
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println("You received " + damage + " damage!");
        System.out.println("You now have " + Math.max(0, hp) + " HP left.");
    }
    
    public void heal(Potion potion) {
        System.out.println("You have " + hp + " hp.");
        System.out.println("You used the " + potion.getName() + "!");
        int oldHp = hp;
        hp += potion.getHealAmount();
        if(hp > maxHp){
            System.out.println("HP: " + oldHp + " -> " + maxHp + "!");
            hp = maxHp;
        } else {
            System.out.println("HP: " + oldHp + " -> " + hp + "!"); 
        }
    }

    //Player initialy needs 1000 xp to lvl up, each lvl after requires 20% more xp
    public boolean lvlUp() {
        if(xp >= xpNeededForLvlUp) {
            System.out.println("\nYou leveled up from " + lvl + " to " + (lvl+1) + "!");
            System.out.println("Hp:          " + maxHp + " -> " + (maxHp *= 1.1) + "!");
            System.out.println("Crit Chance: " + criticalStrike + " -> " + (criticalStrike *= 1.05) + "!"); 
            lvl++;
            hp += 10;
            criticalStrike *= 1.05;
            xp = xp - xpNeededForLvlUp; //reset player xp after leveling up
            xpNeededForLvlUp *= 1.2; //next level takes 20% more xp
            maxHp *= 1.1;
            hp = maxHp;
            return true;
        } else {
            return false;
        }
    }

    public void equipArmor(Armor armor) {
        if(equippedArmor.getName().equals(armor.getName())) {
            System.out.println(armor + " is already equipped!");
            return;
        }
        System.out.println("\nYou unequipped the " + equippedArmor + " with " + equippedArmor.getDefense() + " defense.");
        System.out.println("You equipped the " + armor.getName() + " with " + armor.getDefense() + " defense.");
        equippedArmor = armor;
    }

    public void equipWeapon(Weapon weapon) {
        if(equippedWeapon.getName().equals(weapon.getName())) {
            System.out.println(weapon + " is already equipped!");
            return;
        }
        System.out.println("\nYou unequipped the " + equippedWeapon + " with " + equippedWeapon.getDmg() + " damage.");
        System.out.println("You equipped the " + weapon.getName() + " with " + weapon.getDmg() + " damage.");
        equippedWeapon = weapon;
    }

    public void unlockSkill(String skillName) {
        System.out.println(name + " unlocked the skill: " + skillName);
    }
}