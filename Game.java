import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean isRunning;
    private Player player;
    private Scanner scanner;

    private int nonBossRoomsStreak = 0;
    public static int dungeonsCleared = 0;

    public void start() {
        isRunning = true;
        scanner = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                  Welcome to the Roguelike Dungeon!                  |");
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|     In this game, you will explore through a variety of unique      |"); 
        System.out.println("|  dungeons, fighting your way through hords of enemies, challenging  |"); 
        System.out.println("|     menacing bosses and collecting powerful loot along the way.     |");
        System.out.println("-----------------------------------------------------------------------\n");

        player = CharacterCreation.createCharacter(scanner);

        //add starting gear to inventory
        Inventory.getInstance().addItem(player.getEquippedWeapon());
        Inventory.getInstance().addItem(player.getEquippedArmor());
        Inventory.getInstance().addItem(new Potion("Weak Potion", "Potion", 20));

        while (isRunning) {
            System.out.println("------------------------");
            System.out.println("|  Select an option    |");
            System.out.println("|  1. View Stats       |");
            System.out.println("|  2. View Inventory   |");
            System.out.println("|  3. Enter a dungeon  |");
            System.out.println("|  4. Exit             |");
            System.out.println("------------------------");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    player.showStats();
                    break;
                case "2":
                    Inventory.getInstance().displayInventory(scanner, player);
                    break;
                case "3":
                    List<Enemies> enemiesInRoom = RoomGenerator.generate(nonBossRoomsStreak);
                    for(int i = 0; i < enemiesInRoom.size(); i++){
                        Battle battle = new Battle(player, enemiesInRoom.get(i), scanner, Inventory.getInstance());
                        battle.start();
                    }
                    if(!(enemiesInRoom.get(0) instanceof Boss)){
                        nonBossRoomsStreak++;
                    }else{
                        nonBossRoomsStreak = 0;
                    }
                    dungeonsCleared++;
                    break;
                case "4":
                    System.out.println("Are you sure you want to exit? (y/n)");
                    String confirmChoice = scanner.nextLine();
                    switch (confirmChoice) {
                        case "y":
                        case "Y":
                            isRunning = false;
                            System.out.println("Thanks for playing!");
                            break;
                        case "n":
                        case "N":
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}