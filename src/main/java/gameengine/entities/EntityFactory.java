package gameengine.entities;

import gameengine.ai.PatrolStrategy;
import gameengine.observer.GameEventManager;

public class EntityFactory {
    private final GameEventManager eventManager;

    public EntityFactory(GameEventManager eventManager) {
        this.eventManager = eventManager;
    }

    public GameEntity createEntity(String type, String name, int x, int y) {
        return switch (type.toUpperCase()) {
            case "PLAYER" -> new Player(name, x, y, 100, eventManager);
            case "GOBLIN" -> new Enemy(name, x, y, 50, 15, new PatrolStrategy());
            case "BOSS" -> new Enemy(name, x, y, 200, 35, new PatrolStrategy());
            case "WALL" -> new Obstacle(name, x, y, false);
            default -> throw new IllegalArgumentException("Unknown entity type: " + type);
        };
    }
}