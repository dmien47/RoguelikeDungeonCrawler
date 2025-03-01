import java.util.Scanner;

public class Game {
    private boolean isRunning;
    private Player player;
    private Scanner scanner;

    public void start() {
        isRunning = true;
        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Roguelike Dungeon!");
        player = CharacterCreation.createCharacter(scanner);

        while (isRunning) {
            System.out.println("Select an option");
            System.out.println("1. View Stats");
            System.out.println("2. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    player.showStats();
                    break;
                case "2":
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