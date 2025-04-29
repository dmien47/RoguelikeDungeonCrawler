import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MindBender extends Boss {
    public MindBender() {
        super("Mind Bender", 150, 35, 1000.0);
    }

    public MindBender(MindBender org) {
        super(org.getName(), org.getHp(), org.getAttackPower(), org.getXpDropped());
    }

    @Override
    public Enemies copy() {
        return new MindBender(this);
    }

    //Swaps the players equipped armor and weapon at random from gear in their inventory
    @Override
    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory) { //chatgpt'd this one but it seems to be working fine
        System.out.println("The Mind Bender unleashes a beam of energy!");
        player.takeDamage(25);
        System.out.println("\nYour gear has been swapped at random!");

        ArrayList<Item> items = inventory.getItems();
        ArrayList<Weapon> weapons = new ArrayList<>();
        ArrayList<Armor> armors = new ArrayList<>();

        for (Item item : items) {
            if (item.getType().equalsIgnoreCase("Weapon")) {
                Weapon weapon = (Weapon) item;
                //only swap if it's not the currently equipped weapon
                if (!weapon.getName().equals(player.getEquippedWeapon().getName())) {
                    weapons.add(weapon);
                }
            }
        }
        for (Item item : items) {
            if (item.getType().equalsIgnoreCase("Armor")) {
                Armor armor = (Armor) item;
                //only swap if it's not the currently equipped armor
                if (!armor.getName().equals(player.getEquippedArmor().getName())) {
                    armors.add(armor);
                }
            }
        }

        if (weapons.isEmpty()) {
            System.out.println("...But you have no other weapons to swap!");
            return;
        }
        if (armors.isEmpty()) {
            System.out.println("...But you have no other armor to swap!");
            return;
        }

        Weapon selectedWeapon = weapons.get(new Random().nextInt(weapons.size()));
        player.equipWeapon(selectedWeapon);
        Armor selectedArmor = armors.get(new Random().nextInt(armors.size()));
        player.equipArmor(selectedArmor);
    }
}
