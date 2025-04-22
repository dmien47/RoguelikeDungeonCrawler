import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean isRunning;
    private Player player;
    private Scanner scanner;

    private Inventory inventory;

    private int nonBossRoomsStreak = 0;

    public void start() {
        isRunning = true;
        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Roguelike Dungeon!");
        inventory = Inventory.createInventory(scanner);
        player = CharacterCreation.createCharacter(scanner);

        //add starting gear to inventory
        inventory.addItem(player.getEquippedWeapon());
        inventory.addItem(player.getEquippedArmor());
        inventory.addItem(new Potion("Weak Potion", "Potion", 20));

        while (isRunning) {
            System.out.println("Select an option");
            System.out.println("1. View Stats");
            System.out.println("2. View Inventory");
            System.out.println("3. Go to next room");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    player.showStats();
                    break;
                case "2":
                    inventory.displayInventory(scanner, player);
                    break;
                case "3":
                    /*Enemy goblin = new Enemy("Goblin", 30, 5, 500);
                    Battle battle = new Battle(player, goblin, inventory, scanner);
                    battle.start();*/
                    List<Enemy> enemiesInRoom = RoomGenerator.generate(nonBossRoomsStreak);
                    for(int i = 0; i < enemiesInRoom.size(); i++){
                        Battle battle = new Battle(player, enemiesInRoom.get(i), inventory, scanner);
                        battle.start();
                    }
                    nonBossRoomsStreak++;
                    break;
                case "4":
                    isRunning = false;
                    System.out.println("Thanks for playing!");
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