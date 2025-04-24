import java.util.Scanner;

public class CharacterCreation {
    public static Player createCharacter(Scanner scanner) {

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.println("\nChoose a class:");
        System.out.println("[1] Warrior:\nStrong and mighty warrior, utilizes heavy armor to take fights head on.\n");
        System.out.println("[2] Mage:\nStudents of sorcery. Though vulnerable to attacks, mages are capable of an assortment of powerful spells.\n");
        System.out.println("[3] Rogue:\nMasters of stealth and deception, excelling at exploiting their foes vulnerabilities.\n");

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