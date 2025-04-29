import java.util.Scanner;

public class Boss implements Enemies{
    private String name;
    private int hp;
    private int attackPower;
    private double xpDropped;

    public Boss(String name, int hp, int attackPower, double xpDropped) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.xpDropped = xpDropped;
    }

    public Boss(Boss old){
        this.name = old.getName();
        this.hp = old.getHp();
        this.attackPower = old.getAttackPower();
        this.xpDropped = old.getXpDropped();
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
    public int getHp() {
        return hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive(){
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
    public void specialMove(Player player, Scanner scanner, Enemies enemy, Inventory inventory){}

    @Override
    public Enemies copy() {
        return new Boss(this); 
    }
}

