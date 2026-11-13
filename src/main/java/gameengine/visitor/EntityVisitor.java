package gameengine.visitor;

import gameengine.entities.Enemy;
import gameengine.entities.Obstacle;
import gameengine.entities.Player;

public interface EntityVisitor {
    void visitPlayer(Player player);
    void visitEnemy(Enemy enemy);
    void visitObstacle(Obstacle obstacle);
}