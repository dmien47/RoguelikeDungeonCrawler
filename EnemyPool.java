import java.util.*;

public class EnemyPool {
    private static final List<Enemy> baseEnemies = new ArrayList<>();
    private static final List<Enemy> bossEnemies = new ArrayList<>();
    private static final Random random = new Random();

    static {
        // Base enemies
        baseEnemies.add(new Enemy("Skeleton", 30, 5, 200.0));
        baseEnemies.add(new Enemy("Goblin", 25, 7, 120.5));
        baseEnemies.add(new Enemy("Zombie", 40, 4, 150.0));
        baseEnemies.add(new Enemy("Bandit", 35, 8, 20.0));
        baseEnemies.add(new Enemy("Slime", 20, 3, 8.0));
        baseEnemies.add(new Enemy("Bat", 15, 6, 6.0));
        baseEnemies.add(new Enemy("Spider", 28, 6, 11.0));
        baseEnemies.add(new Enemy("Cultist", 32, 9, 18.0));

        // Boss enemies
        bossEnemies.add(new Enemy("Necromancer", 120, 20, 100.0));
        bossEnemies.add(new Enemy("Orc Warlord", 150, 25, 120.0));
        bossEnemies.add(new Enemy("Ancient Dragon", 200, 35, 200.0));
        bossEnemies.add(new Enemy("Lich King", 180, 30, 180.0));
        bossEnemies.add(new Enemy("Demon Lord", 220, 40, 250.0));
    }

    // Returns a random base enemy
    public static Enemy getRandomBaseEnemy() {
        return new Enemy(baseEnemies.get(random.nextInt(baseEnemies.size())));
    }

    // Returns a random boss enemy
    public static Enemy getRandomBossEnemy() {
        return new Enemy(bossEnemies.get(random.nextInt(bossEnemies.size())));
    }
}
