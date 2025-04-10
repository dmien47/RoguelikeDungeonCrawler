
import java.util.ArrayList;
import java.util.Scanner;


public class Inventory implements IInventory{
    private ArrayList<Item> items = new ArrayList<>();

    public static Inventory createInventory(Scanner scanner) {
        Inventory inv = new Inventory();
        inv.addItem(new Item("HP Potion", "Potion", new HealBehavior(20)));
        inv.addItem(new Item("Strength Elixir", "Buff", new AttributeBoostBehavior("strength", 5)));
        inv.addItem(new Item("Fireball Tome", "Skill Book", new UnlockSkillBehavior("Fireball")));
        return inv;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public void useItem(Scanner scanner, Player player) {
        showItems();
        System.out.println("Choose an item to use:");
        try {
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < items.size()) {
                items.get(choice).use(player);
                items.remove(choice);
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}

//UseBehavior

interface UseBehavior {
    void use(Player player);
}

class HealBehavior implements UseBehavior {
    private int healAmount;

    public HealBehavior(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void use(Player player) {
        player.heal(healAmount);
    }
}

class AttributeBoostBehavior implements UseBehavior {
    private String attribute;
    private int amount;

    public AttributeBoostBehavior(String attribute, int amount) {
        this.attribute = attribute;
        this.amount = amount;
    }

    @Override
    public void use(Player player) {
        player.boostAttribute(attribute, amount);
    }
}

class UnlockSkillBehavior implements UseBehavior {
    private String skillName;

    public UnlockSkillBehavior(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public void use(Player player) {
        player.unlockSkill(skillName);
    }
}

class Item {
    private String name;
    private String type;
    private UseBehavior useBehavior;

    public Item(String name, String type, UseBehavior useBehavior) {
        this.name = name;
        this.type = type;
        this.useBehavior = useBehavior;
    }

    public void use(Player player) {
        if (useBehavior != null) {
            useBehavior.use(player);
        }
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
