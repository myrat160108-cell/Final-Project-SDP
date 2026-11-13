package gameengine.visitor;

import gameengine.entities.Enemy;
import gameengine.entities.Obstacle;
import gameengine.entities.Player;

public class StatsAuditVisitor implements EntityVisitor {
    private int totalEnemyHp = 0;
    private int totalThreatDamage = 0;
    private int entityCount = 0;

    @Override
    public void visitPlayer(Player player) {
        entityCount++;
    }

    @Override
    public void visitEnemy(Enemy enemy) {
        entityCount++;
        totalEnemyHp += enemy.getHealth();
        totalThreatDamage += enemy.getDamage();
    }

    @Override
    public void visitObstacle(Obstacle obstacle) {
        entityCount++;
    }

    public String getSummary() {
        return String.format("Total Entities: %d | Combined Enemy HP: %d | Total Threat DPS: %d",
                entityCount, totalEnemyHp, totalThreatDamage);
    }
}