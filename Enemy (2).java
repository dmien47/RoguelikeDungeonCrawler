
public class Enemy {
    private String name;
    private int hp;
    private int attackPower;

    public Enemy(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
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