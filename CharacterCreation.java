import java.util.Scanner;

public class CharacterCreation {
    public static Player createCharacter(Scanner scanner) {

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.println("\nChoose a class:\n");
        System.out.println("[1] Warrior:\n    Strong and mighty soilder, utilizes heavy armor to take fights head on.");
        System.out.println("[2] Mage:\n    Students of sorcery. Though vunarable to attacks, mages are capable of an assortment of powerful spells.");
        System.out.println("[3] Rogue:\n    Masters of stealth and decpetion, excelling at exploiting their foes vulnerabilities.");

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