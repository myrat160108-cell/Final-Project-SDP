package gameengine.ai;

import gameengine.entities.Enemy;
import gameengine.entities.Player;

public class AggressiveChaseStrategy implements AiBehavior {
    @Override
    public void executeTurn(Enemy enemy, Player target) {
        int dx = Integer.compare(target.getX(), enemy.getX());
        int dy = Integer.compare(target.getY(), enemy.getY());
        enemy.move(dx, dy);
        System.out.println("[AI - Aggressive] " + enemy.getName() + " chases " + target.getName()
                + " to (" + enemy.getX() + ", " + enemy.getY() + ") and attacks!");
        target.takeDamage(enemy.getDamage());
    }
}
