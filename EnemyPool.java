import java.util.*;

public class EnemyPool {
    private static final List<Enemy> baseEnemies = new ArrayList<>();
    private static final List<Boss> bossEnemies = new ArrayList<>();
    private static final Random random = new Random();

    static {
        // Base enemies
        baseEnemies.add(new Enemy("Skeleton", 30, 5, 200.0));
        baseEnemies.add(new Enemy("Goblin", 25, 8, 150.0));
        baseEnemies.add(new Enemy("Zombie", 40, 7, 350.0));
        baseEnemies.add(new Enemy("Bandit", 35, 9, 250.0));
        baseEnemies.add(new Enemy("Slime", 20, 6, 80.0));
        baseEnemies.add(new Enemy("Bat", 15, 8, 60.0));
        baseEnemies.add(new Enemy("Giant Spider", 28, 8, 170.0));
        baseEnemies.add(new Enemy("Cultist", 32, 9, 220.0));

        bossEnemies.add(new Necromancer());
        bossEnemies.add(new AncientDragon());
        bossEnemies.add(new MindBender());
        bossEnemies.add(new OrcWarlord());
        bossEnemies.add(new DemonLord());


    }

    // Returns a random base enemy
    public static Enemy getRandomBaseEnemy() {
        return new Enemy(baseEnemies.get(random.nextInt(baseEnemies.size())));
    }

    // Returns a random boss enemy
    public static Boss getRandomBossEnemy() {
        Boss template = bossEnemies.get(random.nextInt(bossEnemies.size()));
        return (Boss)template.copy();
    }
}
