import java.util.Scanner;

public class OrcWarlord extends Enemy {
    public OrcWarlord() {
        super("Orc Warlord", 120, 36, 1000.0);
    }

    public OrcWarlord(Enemy enemy) {
        super(enemy);
    }

    @Override
    public void specialMove(Player player, Scanner scanner, Enemy enemy, Inventory inventory) {
        System.out.println("The Orc Warlord stomps the ground sending you flying off your feet!");
        player.takeDamage(20);
        player.setStatusAffliction("grounded");
    }
}