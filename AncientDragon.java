import java.util.Scanner;

public class AncientDragon extends Boss {
    public AncientDragon() {
        super("Ancient Dragon", 120, 35, 100.0);
    }

    public AncientDragon(AncientDragon org) {
        super(org.getName(), org.getHp(), org.getAttackPower(), org.getXpDropped());
    }

    @Override
    public Enemies copy() {
        return new AncientDragon(this);
    }

    //50/50 chance of freezing or burning the opponent
    @Override
    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory) {
        if (Math.random() < 0.5) {
            System.out.println("The Ancient Dragon spews a breath of fire!");
            player.takeDamage(20);
            System.out.println("You are burning!");
            player.setStatusAffliction("burn");
        }
        else { //freeze
            System.out.println("The Ancient Dragon spews a breath of Ice!");
            player.takeDamage(20);
            System.out.println("You are frozen solid!");
            player.setStatusAffliction("freeze");
        }
    }
}