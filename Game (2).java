import java.util.Scanner;


public class Game {
    private boolean isRunning;
    private Player player;
    private Scanner scanner;
    private Inventory inventory;

    public void start() {
        isRunning = true;
        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Roguelike Dungeon!");
        player = CharacterCreation.createCharacter(scanner);
        inventory = Inventory.createInventory(scanner);

        while (isRunning) {
            System.out.println("Select an option");
            System.out.println("1. View Stats");
            System.out.println("2. Exit");
            System.out.println("3. View Inventory");
            System.out.println("4. Fight Goblin");


            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    player.showStats();
                    break;
                case "2":
                    isRunning = false;
                    System.out.println("Thanks for playing!");
                    break;
                case "3":
                    if (inventory != null) {
                        inventory.showItems();
                    } else {
                        System.out.println("Inventory is empty.");
                    }
                    break;
                
                case "4"://Battle
                    Enemy goblin = new Enemy("Goblin", 30, 5); 
                    Battle battle = new Battle(player, goblin, inventory, scanner);
                    battle.start();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}