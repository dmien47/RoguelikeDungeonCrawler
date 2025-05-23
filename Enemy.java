import java.util.Scanner;

public class Enemy implements Enemies{
    private String name;
    private int hp;
    private int attackPower;
    private double xpDropped;
    private boolean isBoss;

    public Enemy(String name, int hp, int attackPower, double xpDropped) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.xpDropped = xpDropped;
        this.isBoss = false;
    }

    public Enemy(Enemy old){
        this.name = old.getName();
        this.hp = old.getHp();
        this.attackPower = old.getAttackPower();
        this.xpDropped = old.getXpDropped();
        this.isBoss = old.getIsBoss();
    }

    public void setIsBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }

    public boolean getIsBoss() {
        return isBoss;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public double getXpDropped() {
        return xpDropped;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public int attack() {
        return attackPower;
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " has " + Math.max(0, hp) + " HP left.");
    }

    @Override
    public Enemies copy() {
        return new Enemy(this);
    }

    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory) {}
}