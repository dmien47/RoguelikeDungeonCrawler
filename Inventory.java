
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private static Inventory instance;
    private ArrayList<Item> items = new ArrayList<>();

    private Inventory() {
        items.add(new Weapon("Long Sword", "Weapon", 25));
        items.add(new Armor("Mage robes", "Armor", 25));
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayInventory(Scanner scanner, Player player) {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        } else {
            //display inventory
            System.out.println("Inventory: ");
            for (Item item : items) {
                System.out.println(item.getName());
            }
            //give choice to use something from inv, or exit inv
            System.out.println("\n1. Use/equip an item.");
            System.out.println("2. Exit Inventory");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    useItem(scanner, player);
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    //for equipping a weapon/armor and or using a potion from the inventory
    public void useItem(Scanner scanner, Player player) {
        Item selectedItem = null;

        System.out.print("Enter the name of an item to use/equip: ");
        String choice = scanner.nextLine();

        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(choice.trim())) {
                selectedItem = item;
                break;
            }
        }

        //if user chooses to use a potion from inv
        if (selectedItem.getType().equalsIgnoreCase("Potion")) {
            System.out.println("Use the " + selectedItem + "? (y/n)");
            String confirmPotion = scanner.nextLine();
            switch (confirmPotion) {
                case "y":
                case "Y":
                    player.heal((Potion)selectedItem);
                    items.remove(selectedItem);
                    break;
                case "n":
                case "N":
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        //if user chooses to equip a weapon from inv
        /*********currently cannot equip/re-equip starter gear for some reason*********/
        else if(selectedItem.getType().equalsIgnoreCase("Weapon")) {
            System.out.println("Equip " + selectedItem + "? (y/n)");
            String confirmWeapon = scanner.nextLine();
            switch (confirmWeapon) {
                case "y":
                case "Y":
                    player.equipWeapon((Weapon)selectedItem);
                    break;
                case "n":
                case "N":
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        //if user chooses to equip an armor from inv
        /********currently cannot equip/re-equip starter gear for some reason*********/
        else if(selectedItem.getType().equalsIgnoreCase("Armor")) {
            System.out.println("Equip " + selectedItem + "? (y/n)");
            String confirmArmor = scanner.nextLine();
            switch (confirmArmor) {
                case "y":
                case "Y":
                    player.equipArmor((Armor)selectedItem);
                    //items.remove(selectedItem);
                    break;
                case "n":
                case "N":
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }
}


class Item {
    private String name;
    private String type;

    public Item(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}