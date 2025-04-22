import java.util.Random;

public abstract class Player {
    protected String name;
    protected String characterClass;
    protected int hp, mana, strength, intelligence, resource;
    protected double criticalStrike;
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected int lvl;
    protected double xp;
    private double xpNeededForLvlUp = 1000;

    public Player(String name, String characterClass, int hp,
                  double criticalStrike, Weapon equippedWeapon, Armor equippedArmor, int lvl, int xp) {
        this.name = name;
        this.characterClass = characterClass;
        this.hp = hp;
        this.criticalStrike = criticalStrike;
        this.equippedWeapon = equippedWeapon;
        this.equippedArmor = equippedArmor;
        this.lvl = lvl;
        this.xp = xp;
    }

    public void showStats() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + characterClass);
        System.out.println("Level: " + lvl);
        System.out.println("HP: " + hp);
        System.out.println("Strength: " + strength + " | Intelligence: " + intelligence);
        System.out.println("Crit: " + criticalStrike);
        if (equippedWeapon != null) {
            System.out.println("Equipped Weapon: " + equippedWeapon.getName());
        }
        if (equippedArmor != null) {
            System.out.println("Equipped Armor: " + equippedArmor.getName());
        }
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
            System.out.println("Critical Strike!");
            return equippedWeapon.getDmg() * 2;
        }else{
            return equippedWeapon.getDmg();
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " has " + Math.max(0, hp) + " HP left.");
    }
    
    public void heal(Potion potion) {
        System.out.println("You have " + hp + " hp.");
        System.out.println("You used the " + potion.getName() + " which healed " + potion.getHealAmount() + "HP.");
        hp += potion.getHealAmount();
        System.out.println("You now have " + hp + " hp.");
    }

    //Player initialy needs 1000 xp to lvl up, each lvl after requires 20% more xp
    public boolean lvlUp() {
        if(xp >= xpNeededForLvlUp) {
            System.out.println("You leveled up from " + lvl + " to " + (lvl+1) + "!");
            System.out.println("All stats increased");  //?
            lvl++;
            hp += 10;
            strength++;
            intelligence++;
            criticalStrike *= 1.05;
            xp = 0; //reset player xp after leveling up
            xpNeededForLvlUp *= 1.2; //next level take 20% more xp
            return true;
        } else {
            System.out.println("Cannot level up yet.");
            return false;
        }
    }

    public void equipArmor(Armor armor) {
        if(equippedArmor == armor) {
            System.out.println(armor + " is already equipped!");
            return;
        }
        System.out.println("You currently have the " + equippedArmor + " equipped for " + equippedArmor.getDefense() + " defense.");
        System.out.println("You equipped the " + armor.getName() + " with " + armor.getDefense() + ".");
        equippedArmor = armor;
        System.out.println("You now have the " + equippedArmor + " equipped for " + armor.getDefense() + " defense.");
    }

    public void equipWeapon(Weapon weapon) {
        if(equippedWeapon == weapon) {
            System.out.println(weapon + " is already equipped!");
            return;
        }
        System.out.println("You currently have the " + equippedWeapon + " equipped with " + equippedWeapon.getDmg() + " damage.");
        System.out.println("You equipped the " + weapon.getName() + " with " + weapon.getDmg() + ".");
        equippedWeapon = weapon;
        System.out.println("You now have the " + equippedWeapon + " equipped with " + weapon.getDmg() + " damage.");
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
