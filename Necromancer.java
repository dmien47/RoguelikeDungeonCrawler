import java.util.Scanner;

public class Necromancer extends Boss {
    public Necromancer() {
        super("Necromancer", 120, 30, 1000.0);
    }

    public Necromancer(Necromancer org) {
        super(org.getName(), org.getHp(), org.getAttackPower(), org.getXpDropped());
    }

    @Override
    public Enemies copy() {
        return new Necromancer(this);
    }

    @Override
    public void specialMove(Player player, Scanner scanner, Enemies boss, Inventory inventory) {
        System.out.println("The Necromancer chants an incantation... A Skeleton appears!");
        Enemy skeleton = new Enemy("Summoned Skeleton", 30, 15, 100.0);
        Battle summonedBattle = new Battle(player, skeleton, scanner, inventory);
        summonedBattle.start();
    }
}