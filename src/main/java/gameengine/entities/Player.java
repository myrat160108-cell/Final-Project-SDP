package gameengine.entities;

import gameengine.observer.GameEventManager;
import gameengine.visitor.EntityVisitor;

public class Player extends GameEntity {
    private int health;
    private final int baseAttack;
    private final int baseSpeed;
    private final GameEventManager eventManager;

    public Player(String name, int x, int y, int health, GameEventManager eventManager) {
        super(name, x, y);
        this.health = health;
        this.baseAttack = 20;
        this.baseSpeed = 5;
        this.eventManager = eventManager;
    }

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
        if (eventManager != null) {
            eventManager.notifyListeners("PLAYER_DAMAGED", name + " took " + amount + " dmg! Remaining HP: " + health);
        }
    }

    @Override
    public void accept(EntityVisitor visitor) {
        visitor.visitPlayer(this);
    }

    public int getHealth() { return health; }
    public int getBaseAttack() { return baseAttack; }
    public int getBaseSpeed() { return baseSpeed; }
}