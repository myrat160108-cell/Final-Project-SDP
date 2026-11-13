package gameengine.facade;

import gameengine.ai.AiBehavior;
import gameengine.decorator.BasePlayerCombatant;
import gameengine.decorator.Combatant;
import gameengine.decorator.FireWeaponDecorator;
import gameengine.decorator.SpeedBoostDecorator;
import gameengine.entities.Enemy;
import gameengine.entities.EntityFactory;
import gameengine.entities.GameEntity;
import gameengine.entities.Player;
import gameengine.observer.AchievementObserver;
import gameengine.observer.GameEventManager;
import gameengine.observer.HudDisplayObserver;
import gameengine.visitor.SceneExportVisitor;
import gameengine.visitor.StatsAuditVisitor;

import java.util.ArrayList;
import java.util.List;

public class GameEngineFacade {
    private final AudioSubsystem audio = new AudioSubsystem();
    private final RenderSubsystem render = new RenderSubsystem();
    private final GameEventManager eventManager = new GameEventManager();
    private final EntityFactory factory = new EntityFactory(eventManager);
    private final List<GameEntity> sceneEntities = new ArrayList<>();

    private Player mainPlayer;

    public void initializeEngine() {
        System.out.println("=== STARTING GAME ENGINE ===");
        audio.initAudio();
        render.initGraphics();
        eventManager.subscribe(new HudDisplayObserver());
        eventManager.subscribe(new AchievementObserver());
        audio.playSound("engine_startup.wav");
    }

    public Player spawnPlayer(String name, int x, int y) {
        mainPlayer = (Player) factory.createEntity("PLAYER", name, x, y);
        sceneEntities.add(mainPlayer);
        return mainPlayer;
    }

    public Enemy spawnEnemy(String type, String name, int x, int y) {
        Enemy enemy = (Enemy) factory.createEntity(type, name, x, y);
        sceneEntities.add(enemy);
        return enemy;
    }

    public void spawnWall(String name, int x, int y) {
        sceneEntities.add(factory.createEntity("WALL", name, x, y));
    }

    public void equipFullBuffsOnPlayer() {
        Combatant buffed = new SpeedBoostDecorator(new FireWeaponDecorator(new BasePlayerCombatant(mainPlayer)));
        System.out.println("[Decorator Buffs] Equipped: " + buffed.getDescription()
                + " | ATK: " + buffed.getAttackPower() + " | SPD: " + buffed.getSpeed());
        audio.playSound("powerup.wav");
    }

    public void changeEnemyStrategy(Enemy enemy, AiBehavior newStrategy) {
        enemy.setAiBehavior(newStrategy);
    }

    public void runSimulationTick() {
        System.out.println("\n--- Simulation Tick ---");
        render.renderScene(sceneEntities);
        for (GameEntity entity : sceneEntities) {
            if (entity instanceof Enemy enemy) {
                enemy.performTurn(mainPlayer);
            }
        }
    }

    public void exportAndAuditScene() {
        System.out.println("\n--- Visitor Operations (Audit & XML Export) ---");
        StatsAuditVisitor auditVisitor = new StatsAuditVisitor();
        SceneExportVisitor exportVisitor = new SceneExportVisitor();

        for (GameEntity entity : sceneEntities) {
            entity.accept(auditVisitor);
            entity.accept(exportVisitor);
        }

        System.out.println("[Visitor Audit] " + auditVisitor.getSummary());
        System.out.println("[Visitor XML Export]\n" + exportVisitor.getXmlReport());
    }
}