import java.util.Scanner;

public class DemonLord extends Boss {
    public DemonLord() {
        super("Demon Lord", 100, 35, 1000.0);
    }

    public DemonLord(DemonLord org) {
        super(org.getName(), org.getHp(), org.getAttackPower(), org.getXpDropped());
    }

    @Override
    public Enemies copy() {
        return new DemonLord(this);
    }

    @Override
    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory) {
        System.out.println("The Demon Lord paralyzes you with fear!");
        player.setStatusAffliction("paralyze");
    }
}