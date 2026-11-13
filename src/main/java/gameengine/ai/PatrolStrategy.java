package gameengine.ai;

import gameengine.entities.Enemy;
import gameengine.entities.Player;

public class PatrolStrategy implements AiBehavior {
    @Override
    public void executeTurn(Enemy enemy, Player target) {
        enemy.move(1, 0);
        System.out.println("[AI - Patrol] " + enemy.getName() + " patrols area at (" + enemy.getX() + ", " + enemy.getY() + ")");
    }
}