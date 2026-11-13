package gameengine;

import gameengine.ai.AggressiveChaseStrategy;
import gameengine.entities.Enemy;
import gameengine.facade.GameEngineFacade;

public class Main {
    public static void main(String[] args) {
        GameEngineFacade engine = new GameEngineFacade();
        engine.initializeEngine();

        engine.spawnPlayer("Arthur", 0, 0);
        Enemy goblin = engine.spawnEnemy("GOBLIN", "Sneaky Goblin", 2, 1);
        engine.spawnWall("Stone Fortress Wall", 5, 5);

        engine.equipFullBuffsOnPlayer();

        engine.runSimulationTick();

        engine.changeEnemyStrategy(goblin, new AggressiveChaseStrategy());
        engine.runSimulationTick();

        engine.exportAndAuditScene();
    }
}