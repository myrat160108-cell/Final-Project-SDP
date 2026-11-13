package gameengine.ai;

import gameengine.entities.Enemy;
import gameengine.entities.Player;

public interface AiBehavior {
    void executeTurn(Enemy enemy, Player target);
}