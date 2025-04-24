import java.util.Scanner;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Scanner scanner;

    public Battle(Player player, Enemy enemy, Scanner scanner) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
    }

    public void start() {
        //displayed enemy stats for testing
        System.out.println("A wild " + enemy.getName() + " with " + enemy.getHp() +  " hp that does " + enemy.getAttackPower() + " damage appears!");

        while (player.isAlive() && enemy.isAlive()) {
            playerTurn();
            if (!enemy.isAlive()) break;

            enemyTurn();
        }

        if (player.isAlive()) {
            System.out.println("You defeated the " + enemy.getName() + "!");
            System.out.println("You have " + player.getXp() + " and gained " + enemy.getXpDropped() + " xp!");
            double newXp = player.getXp() + enemy.getXpDropped();
            player.xp = newXp;
            player.lvlUp();
        } else {
            System.out.println("You were defeated by the " + enemy.getName() + "...");
            System.exit(0);
        }
    }

    private void playerTurn() {
        System.out.println("\nYour Turn!");
        System.out.println("1. Attack\n2. Use Item");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                int damage = player.attack();
                System.out.println("You dealt " + damage + " damage to the " + enemy.getName());
                enemy.takeDamage(damage);
                break;
            case "2":
                Inventory.getInstance().displayInventory(scanner, player);
                break;
            default:
                System.out.println("Invalid choice. Skipping turn.");
        }
    }

    private void enemyTurn() {
        System.out.println("\n" + enemy.getName() + "'s Turn!");
        int damage = enemy.attack()*(100 - player.getEquippedArmor().getDefense());
        player.takeDamage(damage);
        System.out.println(enemy.getName() + " dealt " + damage + " damage to you.");
    }
}