
public class Enemy {
    private String name;
    private int hp;
    private int attackPower;
    private double xpDropped;

    public Enemy(String name, int hp, int attackPower, double xpDropped) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.xpDropped = xpDropped;
    }

    public Enemy(Enemy old){
        this.name = old.getName();
        this.hp = old.getHp();
        this.attackPower = old.getAttackPower();
        this.xpDropped = old.getXpDropped();
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
    public double getXpDropped() {
        return xpDropped;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public boolean isAlive() {
        return hp > 0;
    }


    public int attack() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " has " + Math.max(0, hp) + " HP left.");
    }
}