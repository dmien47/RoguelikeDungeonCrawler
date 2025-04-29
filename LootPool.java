import java.util.*;

public class LootPool {
    private static final List<Weapon> rogueWeaponPool = new ArrayList<>();
    private static final List<Weapon> mageWeaponPool = new ArrayList<>();
    private static final List<Weapon> warriorWeaponPool = new ArrayList<>();

    private static final List<Armor> rogueArmorPool = new ArrayList<>();
    private static final List<Armor> mageArmorPool = new ArrayList<>();
    private static final List<Armor> warriorArmorPool = new ArrayList<>();
    private static final List<Potion> potionPool = new ArrayList<>();
    private static final Random random = new Random();

    static {
        //Loot pool with varying tiers of weapons, armor, and potions

        //weapons
        //knight weapons?
        warriorWeaponPool.add(new Weapon("Short Sword", "Weapon", 10));
        warriorWeaponPool.add(new Weapon("Long Sword", "Weapon", 15));
        warriorWeaponPool.add(new Weapon("Great Sword", "Weapon", 20));
        warriorWeaponPool.add(new Weapon("Zweihander", "Weapon", 30));
        warriorWeaponPool.add(new Weapon("Halberd", "Weapon", 22));
        warriorWeaponPool.add(new Weapon("Spear", "Weapon", 13));
        warriorWeaponPool.add(new Weapon("Mace", "Weapon", 22));
        warriorWeaponPool.add(new Weapon("Battle axe", "Weapon", 24));
        warriorWeaponPool.add(new Weapon("Morning Star", "Weapon", 23));
        warriorWeaponPool.add(new Weapon("Great Bow", "Weapon", 30));
        warriorWeaponPool.add(new Weapon("Crossbow", "Weapon", 20));

        //Rouge weapons?
        rogueWeaponPool.add(new Weapon("Rusty Dagger", "Weapon", 5));
        rogueWeaponPool.add(new Weapon("Thief's Dagger", "Weapon", 10));
        rogueWeaponPool.add(new Weapon("Assassin's Dagger", "Weapon", 17));
        rogueWeaponPool.add(new Weapon("Short Bow", "Weapon", 12));
        rogueWeaponPool.add(new Weapon("Long Bow", "Weapon", 16));

        //mage weapons?
        mageWeaponPool.add(new Weapon("Novice Staff", "Weapon", 13));
        mageWeaponPool.add(new Weapon("Apprentice Staff", "Weapon", 25));
        mageWeaponPool.add(new Weapon("Masters Staff", "Weapon", 35));
        mageWeaponPool.add(new Weapon("Staff of the Dark Arts", "Weapon", 40));
        mageWeaponPool.add(new Weapon("Demon's staff", "Weapon", 42));

        //armor
        //knight?
        warriorArmorPool.add(new Armor("Chain-mail", "Armor", .12));
        warriorArmorPool.add(new Armor("Knight's Armor", "Armor", .2));
        warriorArmorPool.add(new Armor("Elite Knight's Armor", "Armor", .3));
        warriorArmorPool.add(new Armor("Dragon-scale Armor", "Armor", .4));

        //rouge?
        rogueArmorPool.add(new Armor("Thief's Cloak", "Armor", .07));
        rogueArmorPool.add(new Armor("Assassin's Cloak", "Armor", .14));
        rogueArmorPool.add(new Armor("Leather Vest", "Armor", .18));

        //mage?
        mageArmorPool.add(new Armor("Novice Robes", "Armor", .03));
        mageArmorPool.add(new Armor("Apprentice Robes", "Armor", .07));
        mageArmorPool.add(new Armor("Master's Robes", "Armor", .13));
        mageArmorPool.add(new Armor("Robes of the Dark Arts", "Armor", .15));

        //potions
        potionPool.add(new Potion("Weak Potion", "Potion", 25));
        potionPool.add(new Potion("Regular Potion", "Potion", 50));
        potionPool.add(new Potion("Strong Potion", "Potion", 100));
    }

    //basic function for returning random loot from the loot pool, 0 is weapon, 1 is armor, 2 is potion
    //will have to edit probabilities of getting higher tier stuff depending on dungeon difficulty or progression level later
    public static Item getRandomLoot(String spec) {
        int type = random.nextInt(3);
        switch(spec){
            case "Warrior":
                switch (type) {
                    case 0:
                        return new Weapon(warriorWeaponPool.get(random.nextInt(warriorWeaponPool.size())));
                    case 1:
                        return new Armor(warriorArmorPool.get(random.nextInt(warriorArmorPool.size())));
                    case 2:
                        return new Potion(potionPool.get(random.nextInt(potionPool.size())));
                    default:
                        return null;
                }
            case "Mage":
                switch (type) {
                    case 0:
                        return new Weapon(mageWeaponPool.get(random.nextInt(mageWeaponPool.size())));
                    case 1:
                        return new Armor(mageArmorPool.get(random.nextInt(mageArmorPool.size())));
                    case 2:
                        return new Potion(potionPool.get(random.nextInt(potionPool.size())));
                    default:
                        return null;
                }
                case "Rogue":
                switch (type) {
                    case 0:
                        return new Weapon(rogueWeaponPool.get(random.nextInt(rogueWeaponPool.size())));
                    case 1:
                        return new Armor(rogueArmorPool.get(random.nextInt(rogueArmorPool.size())));
                    case 2:
                        return new Potion(potionPool.get(random.nextInt(potionPool.size())));
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    //returns only a random weapon from the weapon pool
    public static Item getRandomWeapon(String spec) {
        switch(spec){
            case "Warrior":
                return new Item(warriorWeaponPool.get(random.nextInt(warriorWeaponPool.size())));
            case "Mage":
                return new Item(mageWeaponPool.get(random.nextInt(mageWeaponPool.size())));
            case "Rogue":
                return new Item(rogueWeaponPool.get(random.nextInt(rogueWeaponPool.size())));
            default:
                return null;
        }
    }

    //returns only a random armor from the armor pool
    public static Item getRandomArmor(String spec) {
        switch(spec){
            case "Warrior":
                return new Item(warriorArmorPool.get(random.nextInt(warriorArmorPool.size())));
            case "Mage":
                return new Item(mageArmorPool.get(random.nextInt(mageArmorPool.size())));
            case "Rogue":
                return new Item(rogueArmorPool.get(random.nextInt(rogueArmorPool.size())));
            default:
                return null;
        }
    }

    //returns only a random potion from the potion pool
    public static Item getRandomPotion() {
        return new Item(potionPool.get(random.nextInt(potionPool.size())));
    }
}