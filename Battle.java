import java.util.*;

public class Battle {
    private Player player;
    private Enemies enemy;
    private Scanner scanner;
    private Inventory inventory;
    private Random random = new Random();

    //for freeze status effect, 30% chance of thawing out, increases each round
    private double chance = 0.3;

    //for paralyze status effect
    private boolean firstTurnSkipped = false;
    
    //for displaying results after killed
    private static int enemiesKilled = 0;
    private static int bossesKilled = 0;

    public Battle(Player player, Enemies enemy, Scanner scanner, Inventory inventory) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
        this.inventory = inventory;
    }

    public void start() {
        System.out.println("\nA wild " + enemy.getName() + " with " + enemy.getHp() +  " hp that does " + enemy.getAttackPower() + " damage appears!");

        while (player.isAlive() && enemy.isAlive()) {
            if (player.isAfflicted()) {
                switch (player.getStatusAffliction()) {
                    case "burn": //take small amount of damage every turn until boss is dead
                        System.out.println("\nYou take 5 burn damage!");
                        player.takeDamage(9);
                        break;
                    case "poison": //take small amount of damage every turn until boss is dead
                        System.out.println("\nYou take 3 poison damage!");
                        player.takeDamage(8);
                        break;
                    case "grounded": //skips player turn
                        System.out.println("\nYou cant get in time to attack!");
                        enemyTurn();
                        player.setStatusAffliction(null);
                        break;
                    case "freeze": //player has increasing chance to thaw out after each turn, starting at 30%, like pokemon
                        if (Math.random() < chance) {
                            System.out.println("\nYou're frozen solid!");
                            chance += 0.1; //increase chance of snapping out of freeze next round
                            enemyTurn();
                        } else {
                            System.out.println("\nYou thawed out!");
                            player.setStatusAffliction(null);
                            chance = 0.3; //reset chance
                        }
                        break;
                    case "paralyze": //skips player turn, 40% chance of skipping future turns
                        if (Math.random() < 0.4 || !firstTurnSkipped) {
                            System.out.println("\nYou're paralyzed and can't move!");
                            firstTurnSkipped = true;
                            enemyTurn();
                        } else {
                            playerTurn();
                        }
                        break;
                }
            }
            playerTurn();
            if (!enemy.isAlive()) break;
            enemyTurn();
        }

        if (player.isAlive()) {
            player.setStatusAffliction(null); //clear status effect if any
            System.out.println(enemy.getName() + " has been defeated!\n");
            if(enemy instanceof Boss) {
                bossesKilled++;
            } else {
                enemiesKilled++;
            }
            System.out.println("You have " + player.getXp() + " and gained " + enemy.getXpDropped() + " xp!");
            double newXp = player.getXp() + enemy.getXpDropped();
            if(random.nextDouble() <= .5){
                Item loot = LootPool.getRandomLoot(player.getCharacterClass());
                Inventory.getInstance().addItem(loot);
                System.out.println("You recieved the " + loot.getType().toLowerCase() + " " + loot.getName());
            }
            player.xp = newXp;
            while(player.lvlUp()){};
        } else {
            System.out.println("\nYou were defeated at lvl " + player.lvl + " by the " + enemy.getName() + "...");
            System.out.println("Dungeons cleared: " + Game.dungeonsCleared);
            System.out.println("Enemies Killed: " + enemiesKilled);
            System.out.println("Bosses killed: " + bossesKilled);
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
                System.out.println("\nInvalid choice. Skipping turn.");
        }
    }

    private void enemyTurn() {
        System.out.println("\n" + enemy.getName() + "'s Turn!");

        if (enemy instanceof Boss) {
            //50% chance of boss using special move, if it applies an effect, they wont reuse move until effect ends
            if (Math.random() < 0.5 && player.getStatusAffliction() == null) {
                enemy.specialMove(player, scanner, enemy, inventory);
            } else {
                int damage = (int) ((enemy.attack())*(1-player.getEquippedArmor().getDefense()));
                System.out.println(enemy.getName() + " dealt " + damage + " damage to you.\n");
                player.takeDamage(damage);
            }

        } else {
            int damage = (int) ((enemy.attack())*(1-player.getEquippedArmor().getDefense()));
            System.out.println(enemy.getName() + " dealt " + damage + " damage to you.\n");
            player.takeDamage(damage);
        }
    }
}