import java.util.Scanner;

public class Necromancer extends Enemy {
    public Necromancer() {
        super("Necromancer", 120, 20, 100.0);
    }

    public Necromancer(Enemy enemy) {
        super(enemy);
    }

    @Override
    public void specialMove(Player player, Scanner scanner) {
        System.out.println("The Necromancer chants an incantation... A Skeleton appears!");
        Enemy skeleton = new Enemy("Summoned Skeleton", 20, 5, 10.0);
        Battle summonedBattle = new Battle(player, skeleton, scanner);
        summonedBattle.start();
    }
}