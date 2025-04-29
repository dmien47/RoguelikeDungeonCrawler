import java.util.Scanner;

public interface Enemies {
    public double getXpDropped();
    public String getName();
    public int getHp();
    public boolean isAlive();
    public int getAttackPower();
    public int attack();
    public void takeDamage(int damage);
    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory);
    public Enemies copy();
}
