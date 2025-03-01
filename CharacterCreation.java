import java.util.Scanner;

public class CharacterCreation {
    public static Player createCharacter(Scanner scanner) {
        System.out.println("Enter your character's name:");
        String name = scanner.nextLine();

        System.out.println("Choose a class: [1] Warrior [2] Mage [3] Rogue");
        String choice = scanner.nextLine();

        while(true){
            switch (choice) {
                case "1":
                    return new Warrior(name);
                case "2":
                    return new Mage(name);
                case "3":
                    return new Rogue(name);
                default:
                    System.out.println("Choice Invalid. Please choose again");
                    choice = scanner.nextLine();
            }
        }
    }
}