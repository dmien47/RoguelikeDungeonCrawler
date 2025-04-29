import java.util.*;

public class RoomGenerator {
    private static final Random random = new Random();

    public static List<Enemies> generate(int nonBossRoomCount) {
        List<Enemies> roomEnemies = new ArrayList<>();

        // 10% base boss probability scaled by number of non-boss rooms
        double bossProbability = Math.min(0.1 * nonBossRoomCount, 0.5); // clamp max to 50% chance

        if (random.nextDouble() < bossProbability) {
            // Boss room: one boss enemy
            Boss boss = EnemyPool.getRandomBossEnemy();
            roomEnemies.add(boss);
            System.out.println("Boss Room Encountered: " + boss.getName());
        } else {
            // Normal room: 2–5 base enemies
            int enemyCount = 2 + random.nextInt(3); // (0–3) + 2 => 2 to 5
            for (int i = 0; i < enemyCount; i++) {
                Enemy enemy = EnemyPool.getRandomBaseEnemy();
                roomEnemies.add(enemy);
            }
            System.out.println("Normal Room Encountered with " + enemyCount + " enemies.");
        }

        return roomEnemies;
    }
}
