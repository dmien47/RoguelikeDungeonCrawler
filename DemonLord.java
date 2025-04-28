import java.util.Scanner;

public class DemonLord extends Enemy {
    public DemonLord() {
        super("Demon Lord", 100, 35, 1000.0);
    }

    public DemonLord(Enemy enemy) {
        super(enemy);
    }

    @Override
    public void specialMove(Player player, Scanner scanner, Enemy enemy, Inventory inventory) {
        System.out.println("The Demon Lord paralyzes you with fear!");
        player.setStatusAffliction("paralyze");
    }
}