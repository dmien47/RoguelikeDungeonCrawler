import java.util.Scanner;

public class OrcWarlord extends Boss {
    public OrcWarlord() {
        super("Orc Warlord", 120, 36, 1000.0);
    }

    public OrcWarlord(OrcWarlord org) {
        super(org.getName(), org.getHp(), org.getAttackPower(), org.getXpDropped());
    }

    @Override
    public Enemies copy() {
        return new OrcWarlord(this);
    }

    @Override
    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory) {
        System.out.println("The Orc Warlord stomps the ground sending you flying off your feet!");
        player.takeDamage(20);
        player.setStatusAffliction("grounded");
    }
}