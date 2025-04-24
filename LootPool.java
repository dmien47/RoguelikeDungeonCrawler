import java.util.*;

public class LootPool {
    private static final List<Weapon> weaponPool = new ArrayList<>();
    private static final List<Armor> armorPool = new ArrayList<>();
    private static final List<Potion> potionPool = new ArrayList<>();
    private static final Random random = new Random();

    static {
        //Loot pool with varying tiers of weapons, armor, and potions

        //weapons
        //knight weapons?
        weaponPool.add(new Weapon("Short Sword", "Weapon", 10));
        weaponPool.add(new Weapon("Long Sword", "Weapon", 15));
        weaponPool.add(new Weapon("Great Sword", "Weapon", 20));
        weaponPool.add(new Weapon("Zweihander", "Weapon", 30));
        weaponPool.add(new Weapon("Halberd", "Weapon", 22));
        weaponPool.add(new Weapon("Spear", "Weapon", 13));
        weaponPool.add(new Weapon("Mace", "Weapon", 22));
        weaponPool.add(new Weapon("Battle axe", "Weapon", 24));
        weaponPool.add(new Weapon("Morning Star", "Weapon", 23));
        weaponPool.add(new Weapon("Great Bow", "Weapon", 30));
        weaponPool.add(new Weapon("Crossbow", "Weapon", 20));

        //Rouge weapons?
        weaponPool.add(new Weapon("Rusty Dagger", "Weapon", 5));
        weaponPool.add(new Weapon("Thief's Dagger", "Weapon", 10));
        weaponPool.add(new Weapon("Assassin's Dagger", "Weapon", 17));
        weaponPool.add(new Weapon("Short Bow", "Weapon", 12));
        weaponPool.add(new Weapon("Long Bow", "Weapon", 16));

        //mage weapons?
        weaponPool.add(new Weapon("Novice Staff", "Weapon", 13));
        weaponPool.add(new Weapon("Apprentice Staff", "Weapon", 25));
        weaponPool.add(new Weapon("Masters Staff", "Weapon", 35));
        weaponPool.add(new Weapon("Staff of the Dark Arts", "Weapon", 40));
        weaponPool.add(new Weapon("Demon's staff", "Weapon", 42));

        //armor
        //knight?
        armorPool.add(new Armor("Chain-mail", "Armor", 12));
        armorPool.add(new Armor("Knight's Armor", "Armor", 20));
        armorPool.add(new Armor("Elite Knight's Armor", "Armor", 30));
        armorPool.add(new Armor("Dragon-scale Armor", "Armor", 40));

        //rouge?
        armorPool.add(new Armor("Thief's Cloak", "Armor", 7));
        armorPool.add(new Armor("Assassin's Cloak", "Armor", 14));
        armorPool.add(new Armor("Leather Vest", "Armor", 18));

        //mage?
        armorPool.add(new Armor("Novice Robes", "Armor", 3));
        armorPool.add(new Armor("Apprentice Robes", "Armor", 7));
        armorPool.add(new Armor("Master's Robes", "Armor", 13));
        armorPool.add(new Armor("Robes of the Dark Arts", "Armor", 15));

        //potions
        potionPool.add(new Potion("Weak Potion", "Potion", 25));
        potionPool.add(new Potion("Regular Potion", "Potion", 50));
        potionPool.add(new Potion("Strong Potion", "Potion", 100));
    }

    //basic function for returning random loot from the loot pool, 0 is weapon, 1 is armor, 2 is potion
    //will have to edit probabilities of getting higher tier stuff depending on dungeon difficulty or progression level later
    public static Item getRandomLoot() {
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                return weaponPool.get(random.nextInt(weaponPool.size()));
            case 1:
                return armorPool.get(random.nextInt(armorPool.size()));
            case 2:
                return potionPool.get(random.nextInt(potionPool.size()));
            default:
                return null;
        }
    }

    //returns only a random weapon from the weapon pool
    public static Item getRandomWeapon() {
        return weaponPool.get(random.nextInt(weaponPool.size()));
        //alternatively something like this
        /*
        Item weaponLoot = LootPool.getRandomWeapon();
        System.out.println("The chest gave you: " + weaponLoot.getName());
        inventory.addItem(weaponLoot);
         */
    }

    //returns only a random armor from the armor pool
    public static Item getRandomArmor() {
        return armorPool.get(random.nextInt(armorPool.size()));
    }

    //returns only a random potion from the potion pool
    public static Item getRandomPotion() {
        return potionPool.get(random.nextInt(potionPool.size()));
    }
}